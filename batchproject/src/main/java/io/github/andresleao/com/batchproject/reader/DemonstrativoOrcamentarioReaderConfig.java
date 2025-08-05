package io.github.andresleao.com.batchproject.reader;

import io.github.andresleao.com.batchproject.domain.GrupoLancamento;
import io.github.andresleao.com.batchproject.domain.Lancamento;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DemonstrativoOrcamentarioReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Lancamento> lancamentoItemReader() {
        return new FlatFileItemReaderBuilder<Lancamento>()
                .name("lancamentoItemReader")
                .delimited()
                .delimiter(",")
                .names("codigoNaturezaDespesa", "descricaoNaturezaDespesa", "descricao", "data", "valor")
                .fieldSetMapper(new LancamentoFieldSetMapper())
                .build();
    }

    @Bean
    @StepScope
    public MultiResourceItemReader<Lancamento> multiLancamentoItemReader(
            @Value("#{jobParameters['arquivosLancamento']}") Resource[] arquivosLancamento,
            FlatFileItemReader<Lancamento> lancamentoItemReader
    ) {
        return new MultiResourceItemReaderBuilder<Lancamento>()
                .name("multiLancamentoItemReader")
                .resources(arquivosLancamento)
                .delegate(lancamentoItemReader)
                .build();
    }

    @Bean(name = "demonstrativoOrcamentarioReader")
    @StepScope
    public ItemReader<GrupoLancamento> grupoLancamentoItemReader(
            @Value("#{jobParameters['arquivosLancamento']}") Resource[] arquivosLancamento,
            FlatFileItemReader<Lancamento> lancamentoItemReader
    ) {
        MultiResourceItemReader<Lancamento> multiReader = new MultiResourceItemReaderBuilder<Lancamento>()
                .name("multiLancamentoItemReader")
                .resources(arquivosLancamento)
                .delegate(lancamentoItemReader)
                .build();

        return new GrupoLancamentoReader(multiReader);
    }
}
