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
public class ProcessorValidacaoJobConfig {

    private final JobRepository jobRepository;

    @Bean("processorValidacaoJob")
    public Job processorValidacaoJob(Step processorValidacaoStep) {
        return new JobBuilder("processorValidacaoJob", jobRepository)
                .start(processorValidacaoStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
