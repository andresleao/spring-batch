package io.github.andresleao.com.batchproject.step;

import io.github.andresleao.com.batchproject.domain.GrupoLancamento;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class DemonstrativoOrcamentarioStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public Step demonstrativoOrcamentarioStep(
        @Qualifier("demonstrativoOrcamentarioReader") ItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
        @Qualifier("demonstrativoOrcamentarioWriter") ItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter
    ) {
        return new StepBuilder("demonstrativoOrcamentarioStep", jobRepository)
                .<GrupoLancamento, GrupoLancamento>chunk(100, transactionManager)
                .reader(demonstrativoOrcamentarioReader)
                .writer(demonstrativoOrcamentarioWriter)
                .build();
    }
}
