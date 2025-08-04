package io.github.andresleao.com.batchproject.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProcessorClassifierJobConfig {

    private final JobRepository jobRepository;

    @Bean("processorClassifierJob")
    public Job processorClassifierJob(Step processorClassifierStep) {
        return new JobBuilder("processorClassifierJob", jobRepository)
                .start(processorClassifierStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
