package io.github.andresleao.com.batchproject.step;

import io.github.andresleao.com.batchproject.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ProcessorClassifierStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean("processorClassifierStep")
    public Step processorClassifierStep(
        @Qualifier("processorClassifierReader") ItemReader<Cliente> processorClassifierReader,
        @Qualifier("processorClassifierProcessor") ItemProcessor<Cliente, Cliente> processorClassifierProcessor,
        @Qualifier("processorClassifierWriter") ItemWriter<Cliente> processorClassifierWriter
    ) {
        return new StepBuilder("processorClassifierStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(processorClassifierReader)
                .processor(processorClassifierProcessor)
                .writer(processorClassifierWriter)
                .build();
    }
}
