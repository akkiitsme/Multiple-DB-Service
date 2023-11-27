package com.multiserverservice.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouter extends AbstractRoutingDataSource {

    @Autowired
    RequestContext requestContext;

    @Override
    protected Object determineCurrentLookupKey() {
        // Get the current datasource identifier from the request context
        String sourceIdentifier = requestContext.getCurrentSourceIdentifier();
        if (sourceIdentifier == null) {
            // Default to the first data source
            sourceIdentifier = "US";
        }
        return sourceIdentifier;
    }
}
