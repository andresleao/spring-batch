package io.github.andresleao.com.batchproject.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Lancamento {
    private Integer codigoNaturezaDespesa;
    private String descricaoNaturezaDespesa;
    private String descricao;
    private Date data;
    private Double valor;
}
