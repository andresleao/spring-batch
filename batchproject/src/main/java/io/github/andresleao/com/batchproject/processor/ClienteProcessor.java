package io.github.andresleao.com.batchproject.processor;

import io.github.andresleao.com.batchproject.domain.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        System.out.printf("\nAplicando regras de negócio no cliente: %s%n", cliente.getEmail());
        return cliente;
    }
}
