package io.github.andresleao.com.batchproject.writer;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteItemWriterConfig {

    @Bean("clienteItemWriter")
    public ItemWriter<Cliente> clienteItemWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}

//@Component("clienteItemWriter")
//public class ClienteItemWriter implements ItemWriter<Cliente> {
//
//    private static final Logger logger = LoggerFactory.getLogger(ClienteItemWriter.class);
//
//    @Override
//    public void write(Chunk<? extends Cliente> chunk) throws Exception {
//        logger.info("Processing {} clients", chunk.size());
//
//        for (Cliente cliente : chunk) {
//            logger.info("Client: {} {}, {} years, Email: {}",
//                    cliente.getNome(),
//                    cliente.getSobrenome(),
//                    cliente.getIdade(),
//                    cliente.getEmail());
//        }
//    }
//}