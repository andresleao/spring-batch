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
public class ReadingDelimitedFileReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> readingDelimitedFileReader(
            @Value("#{jobParameters['clientsFile']}") Resource clientsFile
    ) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("readingDelimitedFileReader")
                .resource(clientsFile)
                .delimited()
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }
}
