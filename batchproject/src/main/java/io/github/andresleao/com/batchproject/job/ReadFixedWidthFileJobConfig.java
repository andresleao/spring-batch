package io.github.andresleao.com.batchproject.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class ReadFixedWidthFileJobConfig {

    private final JobRepository jobRepository;

    @Bean("readFixedWidthFileJob")
    public Job readFixedWidthFileJob(Step readFixedWidthFileStep) {
        return new JobBuilder("readFixedWidthFileJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(readFixedWidthFileStep)
                .build();
    }
}
