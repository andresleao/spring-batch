package io.github.andresleao.com.batchproject.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorClassifierWriterConfig {

    @Bean("processorClassifierWriter")
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ItemWriter processorClassifierWriter() {
        return items -> items.forEach(System.out::println);
    }
}
