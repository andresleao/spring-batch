package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.Lancamento;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LancamentoFieldSetMapper implements FieldSetMapper<Lancamento> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Lancamento mapFieldSet(FieldSet fieldSet) {
        Lancamento lancamento = new Lancamento();

        lancamento.setCodigoNaturezaDespesa(fieldSet.readInt("codigoNaturezaDespesa"));
        lancamento.setDescricaoNaturezaDespesa(fieldSet.readString("descricaoNaturezaDespesa"));
        lancamento.setDescricao(fieldSet.readString("descricao"));

        String dataStr = fieldSet.readString("data");

        try {
            Date data = dateFormat.parse(dataStr);
            lancamento.setData(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("Data inválida: " + dataStr, e);
        }

        BigDecimal valorBD = fieldSet.readBigDecimal("valor");
        lancamento.setValor(valorBD.doubleValue());

        return lancamento;
    }
}
