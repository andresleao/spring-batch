package io.github.andresleao.com.batchproject.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PrintEvenOrOddStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step printEvenOrOddStep() {
        return new StepBuilder("printEvenOrOddStep", jobRepository)
                .<Integer, String>chunk(10, transactionManager)
                .reader(countUntilTen())
                .processor(evenOrOddProcessor())
                .writer(printWriter())
                .build();
    }

    @Bean
    public ItemReader<Integer> countUntilTen() {
        return new ListItemReader<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Bean
    public ItemProcessor<Integer, String> evenOrOddProcessor() {
        return item -> item % 2 == 0
                ? item + " é par"
                : item + " é ímpar";
    }

    @Bean
    public ItemWriter<String> printWriter() {
        return items -> items.forEach(System.out::println);
    }
}
