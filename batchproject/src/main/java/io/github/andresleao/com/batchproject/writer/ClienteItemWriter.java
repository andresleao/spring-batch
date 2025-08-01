package io.github.andresleao.com.batchproject.writer;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("clienteItemWriter")
public class ClienteItemWriter implements ItemWriter<Cliente> {

    private static final Logger logger = LoggerFactory.getLogger(ClienteItemWriter.class);

    @Override
    public void write(Chunk<? extends Cliente> chunk) throws Exception {
        logger.info("Processing {} clients", chunk.size());

        for (Cliente cliente : chunk) {
            logger.info("Client: {} {}, {} years, Email: {}",
                    cliente.getNome(),
                    cliente.getSobrenome(),
                    cliente.getIdade(),
                    cliente.getEmail());
        }
    }
}