package io.github.andresleao.com.batchproject.processor;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorClassifierProcessorConfig {

    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ItemProcessor processorClassifierProcessor() {
        return new ClassifierCompositeItemProcessorBuilder()
                .classifier(classifier())
                .build();
    }

    @SuppressWarnings("rawtypes")
    private Classifier classifier() {
        return new Classifier<Object, ItemProcessor>() {

            @Override
            public ItemProcessor classify(Object object) {
                if (object instanceof Cliente) {
                    return new ClienteProcessor();
                }
                return new TransacaoProcessor();
            }
        };
    }
}
