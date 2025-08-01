package io.github.andresleao.com.batchproject.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


public class ClienteFieldSetMapper implements FieldSetMapper<Cliente> {
    @Override
    public Cliente mapFieldSet(FieldSet fieldSet) throws BindException {
        Cliente cliente = new Cliente();
        cliente.setNome(fieldSet.readString("nome").trim());
        cliente.setSobrenome(fieldSet.readString("sobrenome").trim());

        try {
            cliente.setIdade(fieldSet.readInt("idade"));
        } catch (NumberFormatException e) {
            throw new BindException("Invalid age format", e.getMessage());
        }

        cliente.setEmail(fieldSet.readString("email").trim());
        return cliente;
    }
}
