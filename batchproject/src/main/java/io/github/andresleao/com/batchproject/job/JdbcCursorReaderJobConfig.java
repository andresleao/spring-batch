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
public class JdbcCursorReaderJobConfig {
    private final JobRepository jobRepository;

    @Bean("jdbcCursorReaderJob")
    public Job jdbcCursorReaderJob(Step jdbcCursorReaderStep) {
        return new JobBuilder("jdbcCursorReaderJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(jdbcCursorReaderStep)
                .build();
    }
}
