package io.github.andresleao.com.batchproject.step;

import io.github.andresleao.com.batchproject.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ReadDelimitedFileStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step readDelimitedFileStep(
            @Qualifier("readingDelimitedFileReader") ItemReader<Cliente> readingDelimitedFileReader,
            @Qualifier("readingDelimitedFileWriter") ItemWriter<Cliente> readingDelimitedFileWriter
    ) {
        return new StepBuilder("readDelimitedFileStep", jobRepository)
                .<Cliente, Cliente>chunk(10, transactionManager)
                .reader(readingDelimitedFileReader)
                .writer(readingDelimitedFileWriter)
                .build();
    }
}
