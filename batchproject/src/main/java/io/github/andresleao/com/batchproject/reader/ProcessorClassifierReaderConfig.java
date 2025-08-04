package io.github.andresleao.com.batchproject.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessorClassifierReaderConfig {

    @Bean("processorClassifierReader")
    @StepScope
    @SuppressWarnings({"rawtypes", "unchecked"})
    public FlatFileItemReader processorClassifierReader(
        @Value("#{jobParameters['clientsFile']}") Resource arquivoClientes,
        LineMapper lineMapper
    ) {
        return new FlatFileItemReaderBuilder()
                .name("processorClassifierReader")
                .resource(arquivoClientes)
                .lineMapper(lineMapper)
                .build();
    }
}
