package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.Cliente;
import io.github.andresleao.com.batchproject.domain.Transacao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ClieneTransacaoFileReader implements ItemStreamReader<Cliente>, ResourceAwareItemReaderItemStream<Cliente> {

    private Object currentObj;
    private FlatFileItemReader<Object> delegate;
    //private ItemStreamReader<Object> delegate;

    public ClieneTransacaoFileReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public Cliente read() throws Exception {
        if (currentObj == null) currentObj = delegate.read();

        Cliente cliente = (Cliente) currentObj;
        currentObj = null;

        if (cliente != null) {
            while(peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) currentObj);
            }
        }

        return cliente;
    }

    private Object peek() throws Exception {
        currentObj = delegate.read();
        return currentObj;
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
