package com.soulballad.usage.springcloud.config;

import javax.sql.DataSource;

import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.JDBCConfigurationSource;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/5/31 17:17
 */
@Configuration
public class DbLocationConfig {

    @Autowired
    private DataSource h2DataSource;

    @Bean
    public AbstractConfiguration addDbConfigurationSource() {
        PolledConfigurationSource source = new JDBCConfigurationSource(h2DataSource,
            "select distinct key, value from t_archaius_config", "key", "value");
        return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
    }
}
