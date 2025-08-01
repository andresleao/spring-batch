package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReadingFixedWidthFileReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> readingFixedWidthFileReader(
            @Value("#{jobParameters['clientsFile']}") Resource clientsFile
    ) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("readingFixedWidthFileReader")
                .resource(clientsFile)
                .fixedLength()
                .columns(
                        new Range(1, 10),
                        new Range(11, 20),
                        new Range(21, 23),
                        new Range(24)
                )
                .names("nome", "sobrenome", "idade", "email")
                //.fieldSetMapper(new ClienteFieldSetMapper())
                .targetType(Cliente.class)
                .build();
    }
}
