package io.github.andresleao.com.batchproject.domain;

import lombok.Data;

@Data
public class Transacao {
    public String id;
    public String descricao;
    public Double valor;
}
