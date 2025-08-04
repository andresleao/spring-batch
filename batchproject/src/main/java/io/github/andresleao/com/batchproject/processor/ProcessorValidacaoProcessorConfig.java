package io.github.andresleao.com.batchproject.processor;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessorValidacaoProcessorConfig {

    private Set<String> emails = new HashSet<>();

    @Bean("processorValidacaoProcessor")
    public ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor() throws Exception {
        return new CompositeItemProcessorBuilder<Cliente, Cliente>()
                .delegates(beanValidatingItemProcessor(), emailValidatingProcessor())
                .build();
    }

    private BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
        processor.setFilter(true);
        processor.afterPropertiesSet();

        return processor;
    }

    private ValidatingItemProcessor<Cliente> emailValidatingProcessor() {
        ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
        processor.setFilter(true);
        processor.setValidator(validator());

        return processor;
    }

    private Validator<Cliente> validator() {
        return new Validator<Cliente>() {
            @Override
            public void validate(Cliente cliente) throws ValidationException {
                if (emails.contains(cliente.getEmail())) {
                    throw new ValidationException(
                        String.format("O cliente %s já foi processado!",
                        cliente.getEmail())
                    );
                }
                emails.add(cliente.getEmail());
            }
        };
    }
}
