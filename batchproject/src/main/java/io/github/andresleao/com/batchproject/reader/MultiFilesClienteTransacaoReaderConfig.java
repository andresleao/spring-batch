package io.github.andresleao.com.batchproject.reader;



import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
public class MultiFilesClienteTransacaoReaderConfig {

    @Bean
    @StepScope
    @SuppressWarnings({"rawtypes", "unchecked"})
    public MultiResourceItemReader multiFilesClienteTransacaoReader(
            @Value("#{jobParameters['clientsFiles']}") Resource[] files,
            FlatFileItemReader readingMultiFormatFileReader
    ) {
        return new MultiResourceItemReaderBuilder<>()
                .name("multiFilesClienteTransacaoReader")
                .resources(files)
                .delegate(new ClieneTransacaoFileReader(readingMultiFormatFileReader))
                .build();
    }
}
