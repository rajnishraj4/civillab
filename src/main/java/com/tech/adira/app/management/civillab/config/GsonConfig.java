package com.tech.adira.app.management.civillab.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tech.adira.app.management.civillab.config.adapters.GsonAdaptersRegistrar;
import com.tech.adira.app.management.civillab.config.adapters.HibernateProxyTypeAdapter;
import com.tech.adira.app.management.civillab.config.adapters.InstantTypeAdapter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class GsonConfig {

    @Bean
    public Gson gson(){
        GsonBuilder builder = new GsonBuilder()
                .registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxyTypeAdapter())
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .serializeNulls()
                .setPrettyPrinting();
        GsonAdaptersRegistrar.registerAll(builder);

        return builder.create();
    }
}
