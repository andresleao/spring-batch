package io.github.andresleao.com.batchproject.config;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BatchConfig extends DefaultBatchConfiguration {
    private final DataSource batchDataSource;

    public BatchConfig(@Qualifier("dataSource") DataSource batchDataSource) {
        this.batchDataSource = batchDataSource;
    }

    @Override
    public DataSource getDataSource() {
        return this.batchDataSource;
    }
}
