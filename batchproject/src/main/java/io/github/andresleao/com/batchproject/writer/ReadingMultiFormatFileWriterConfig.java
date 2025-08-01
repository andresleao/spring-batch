package io.github.andresleao.com.batchproject.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadingMultiFormatFileWriterConfig  {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ItemWriter readingMultiFormatFileWriter() {
        return items -> items.forEach(System.out::println);
    }
}
