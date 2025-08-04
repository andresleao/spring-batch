package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration

public class ProcessorValidacaoReaderConfig {

    @Bean("processorValidacaoReader")
    @StepScope
    public FlatFileItemReader<Cliente> processorValidacaoReader(
        @Value("#{jobParameters['clientsFile']}") Resource clientsFile
    ) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("processorValidacaoReader")
                .resource(clientsFile)
                .delimited()
                .names("nome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }
}
