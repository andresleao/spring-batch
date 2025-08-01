package io.github.andresleao.com.batchproject.writer;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadingDelimitedFileWriterConfig {

    @Bean("readingDelimitedFileWriter")
    public ItemWriter<Cliente> readingDelimitedFileWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
