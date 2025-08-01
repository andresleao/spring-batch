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
public class JdbcCursorReaderStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step jdbcCursorReaderStep(
            ItemReader<Cliente> jdbcCursorReader,
            @Qualifier("jdbcCursorWriter") ItemWriter<Cliente> jdbcCursorWriter
    ) {
        return new StepBuilder("jdbcCursorReaderStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .faultTolerant().skip(Exception.class).skipLimit(2)
                .build();
    }
}
