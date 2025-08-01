package io.github.andresleao.com.batchproject.step;

import io.github.andresleao.com.batchproject.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ReadMultiFormatFileStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Step readMultiFormatFileStep(
            //FlatFileItemReader readingMultiFormatFileReader,
            MultiResourceItemReader<Cliente> multiFilesClienteTransacaoReader,
            ItemWriter readingMultiFormatFileWriter
    ) {
        return new StepBuilder("readMultiFormatFileStep", jobRepository)
                .chunk(10, transactionManager)
                //.reader(new ClieneTransacaoFileReader(readingMultiFormatFileReader))
                .reader(multiFilesClienteTransacaoReader)
                .writer(readingMultiFormatFileWriter)
                .build();
    }
}
