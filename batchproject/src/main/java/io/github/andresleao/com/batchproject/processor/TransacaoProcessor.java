package io.github.andresleao.com.batchproject.processor;

import io.github.andresleao.com.batchproject.domain.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

    @Override
    public Transacao process(Transacao transacao) throws Exception {
        System.out.printf("\nAplicando regras de negócio a transacao: %s%n", transacao.id);
        return transacao;
    }
}
