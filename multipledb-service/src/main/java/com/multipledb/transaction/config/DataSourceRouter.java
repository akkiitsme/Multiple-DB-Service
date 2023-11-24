package com.multipledb.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouter extends AbstractRoutingDataSource {

    @Autowired
    RequestContext requestContext;

    @Override
    protected Object determineCurrentLookupKey() {
        // Get the current tenant identifier from the request context
        String tenantIdentifier = requestContext.getCurrentTenantIdentifier();
        if (tenantIdentifier == null) {
            // Default to the first data source
            tenantIdentifier = "default";
        }
        return tenantIdentifier;
    }
}
