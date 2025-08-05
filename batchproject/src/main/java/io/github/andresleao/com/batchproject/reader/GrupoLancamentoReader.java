package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.GrupoLancamento;
import io.github.andresleao.com.batchproject.domain.Lancamento;
import org.springframework.batch.item.ItemReader;

public class GrupoLancamentoReader implements ItemReader<GrupoLancamento> {

    private final ItemReader<Lancamento> delegate;
    private GrupoLancamento currentGroup;

    public GrupoLancamentoReader(ItemReader<Lancamento> delegate) {
        this.delegate = delegate;
    }

    @Override
    public GrupoLancamento read() throws Exception {
        if (currentGroup == null) {
            currentGroup = new GrupoLancamento();
        }

        Lancamento lancamento;
        while ((lancamento = delegate.read()) != null) {
            if (currentGroup.getCodigoNaturezaDespesa() == null) {
                currentGroup.setCodigoNaturezaDespesa(lancamento.getCodigoNaturezaDespesa());
                currentGroup.setDescricaoNaturezaDespesa(lancamento.getDescricaoNaturezaDespesa());
                currentGroup.getLancamentos().add(lancamento);
            } else if (currentGroup.getCodigoNaturezaDespesa().equals(lancamento.getCodigoNaturezaDespesa())) {
                currentGroup.getLancamentos().add(lancamento);
            } else {
                GrupoLancamento completedGroup = currentGroup;
                currentGroup = new GrupoLancamento();
                currentGroup.setCodigoNaturezaDespesa(lancamento.getCodigoNaturezaDespesa());
                currentGroup.setDescricaoNaturezaDespesa(lancamento.getDescricaoNaturezaDespesa());
                currentGroup.getLancamentos().add(lancamento);
                return completedGroup;
            }
        }

        if (!currentGroup.getLancamentos().isEmpty()) {
            GrupoLancamento completedGroup = currentGroup;
            currentGroup = null;
            return completedGroup;
        }

        return null;
    }
}
