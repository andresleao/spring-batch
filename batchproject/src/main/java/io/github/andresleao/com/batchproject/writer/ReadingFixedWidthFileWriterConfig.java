package io.github.andresleao.com.batchproject.writer;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.WritableResource;

@Configuration
public class ReadingFixedWidthFileWriterConfig {

    @Bean("readingFixedWidthFileWriter")
    @StepScope
    public FlatFileItemWriter<Cliente> readingFixedWidthFileWriter(
            @Value("#{jobParameters['outputClientsFile']}") WritableResource outputClientsFile
    ) {
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("readingFixedWidthFileWriter")
                .resource(outputClientsFile)
                .formatted()
                .format("%-10s%-10s%-3s%-20s")
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }
}
