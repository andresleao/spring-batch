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
public class DemonstrativoOrcamentarioJobConfig {

    private final JobRepository jobRepository;

    @Bean("demonstrativoOrcamentarioJob")
    public Job demonstrativoOrcamentarioJob(Step demonstrativoOrcamentarioStep) {
        return new JobBuilder("demonstrativoOrcamentarioJob", jobRepository)
                .start(demonstrativoOrcamentarioStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
