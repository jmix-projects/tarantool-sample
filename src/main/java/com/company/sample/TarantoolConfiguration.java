package com.company.sample;

import com.company.sample.config.TarantoolProperties;
import io.tarantool.driver.api.TarantoolServerAddress;
import io.tarantool.driver.auth.SimpleTarantoolCredentials;
import io.tarantool.driver.auth.TarantoolCredentials;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.tarantool.config.AbstractTarantoolDataConfiguration;
import org.springframework.data.tarantool.repository.config.EnableTarantoolRepositories;

@Configuration
@EnableTarantoolRepositories
public class TarantoolConfiguration extends AbstractTarantoolDataConfiguration {

    private TarantoolProperties tarantoolProperties;

    public TarantoolConfiguration(TarantoolProperties tarantoolProperties) {
        this.tarantoolProperties = tarantoolProperties;
    }

    @Override
    protected TarantoolServerAddress tarantoolServerAddress() {
        return new TarantoolServerAddress(tarantoolProperties.getHost(), tarantoolProperties.getPort());
    }

    @Override
    public TarantoolCredentials tarantoolCredentials() {
        return new SimpleTarantoolCredentials(tarantoolProperties.getUsername(), tarantoolProperties.getPassword());
    }

    /**
     * We don't need a {@code ProxyTarantoolTupleClient} because in this example we work with a single Tarantool instance
     */
//    @Override
//    public TarantoolClient tarantoolClient(TarantoolClientConfig tarantoolClientConfig,
//                                           TarantoolClusterAddressProvider tarantoolClusterAddressProvider) {
//        return new ProxyTarantoolTupleClient(super.tarantoolClient(tarantoolClientConfig, tarantoolClusterAddressProvider));
//    }
}
