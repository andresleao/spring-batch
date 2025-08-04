package io.github.andresleao.com.batchproject.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome deve ser alfabético")
    private String nome;

    private String sobrenome;

    @NotNull
    @Range(min = 18, max = 200)
    private Integer idade;

    @NotNull
    @Size(min = 1, max = 50)
    @Email(message = "Email inválido")
    private String email;

    private List<Transacao> transacoes = new ArrayList<>();
}
