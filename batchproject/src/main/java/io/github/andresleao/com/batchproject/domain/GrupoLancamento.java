package io.github.andresleao.com.batchproject.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GrupoLancamento {
    private Integer codigoNaturezaDespesa;
    private String descricaoNaturezaDespesa;
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Double getTotal() {
        return lancamentos.stream()
                .mapToDouble(Lancamento::getValor)
                .sum();
    }
}
