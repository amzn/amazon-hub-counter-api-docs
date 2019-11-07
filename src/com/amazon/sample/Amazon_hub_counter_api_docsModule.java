package com.amazon.sample;

import com.amazon.coral.metrics.MetricsFactory;
import com.amazon.coral.metrics.helper.MetricsHelper;
import com.amazon.coral.metrics.helper.QuerylogHelper;
import com.amazon.guice.brazil.AppConfigBinder;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class Amazon_hub_counter_api_docsModule extends AbstractModule {

    private final String root;
    private final String realm;
    private final String domain;

	Amazon_hub_counter_api_docsModule(final String root, final String domain, final String realm) {
        this.root = root;
        this.realm = realm;
        this.domain = domain;
    }

    @Override
    protected void configure() {
        AppConfigBinder appConfigBinder = new AppConfigBinder(binder());
        appConfigBinder.bindPrefix("*");
    }

    @Provides
    @Singleton
    MetricsFactory factory() {

        QuerylogHelper queryLogHelper = new QuerylogHelper();
        queryLogHelper.setFilename(root + "/var/output/logs/service_log");

        MetricsHelper metricsFactory = new MetricsHelper();
        metricsFactory.setReporters(queryLogHelper);
        metricsFactory.setProgram("Amazon-hub-counter-api-docs");
        metricsFactory.setMarketplace(realm);
        return metricsFactory;
    }
    
}
