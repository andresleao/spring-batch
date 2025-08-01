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
public class ReadMultiFormatFileJobConfig {

    private final JobRepository jobRepository;

    @Bean("readMultiFormatFileJob")
    public Job readFixedWidthFileJob(Step readMultiFormatFileStep) {
        return new JobBuilder("readMultiFormatFileJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(readMultiFormatFileStep)
                .build();
    }
}
