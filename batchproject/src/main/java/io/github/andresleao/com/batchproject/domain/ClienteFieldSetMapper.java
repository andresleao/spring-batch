package io.github.andresleao.com.batchproject.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ClienteFieldSetMapper implements FieldSetMapper<Cliente> {

    @Override
    public Cliente mapFieldSet(FieldSet fieldSet) throws BindException {
        Cliente cliente = new Cliente();

        cliente.setNome(fieldSet.readString("nome"));
        cliente.setSobrenome(fieldSet.readString("sobrenome"));

        String idadeStr = fieldSet.readString("idade");

        if (!idadeStr.isBlank()) {
            cliente.setIdade(Integer.parseInt(idadeStr));
        } else {
            cliente.setIdade(null);
        }

        cliente.setEmail(fieldSet.readString("email"));

        return cliente;
    }
}
