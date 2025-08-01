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
public class JdbcPagingReaderStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step jdbcPagingReaderStep(
            @Qualifier("jdbcPagingReader") ItemReader<Cliente> jdbcPagingReader,
            @Qualifier("jdbcPagingReaderWriter") ItemWriter<Cliente> jdbcPagingReaderWriter
    ) {
        return new StepBuilder("jdbcPagingReaderStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(jdbcPagingReader)
                .writer(jdbcPagingReaderWriter)
                .build();
    }
}
