package io.github.andresleao.com.batchproject.writer;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorScriptWriterConfig {

    @Bean("processorScriptWriter")
    public ItemWriter<Cliente> processorScriptWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
