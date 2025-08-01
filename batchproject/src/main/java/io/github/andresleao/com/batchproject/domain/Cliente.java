package io.github.andresleao.com.batchproject.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private String nome;
    private String sobrenome;
    private int idade;
    private String email;
    private List<Transacao> transacoes = new ArrayList<>();
}
