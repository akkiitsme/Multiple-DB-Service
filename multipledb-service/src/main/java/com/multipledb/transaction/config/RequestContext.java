package com.multipledb.transaction.config;

public class RequestContext {
    String currentIdentifier = null;

    private static final ThreadLocal<String> tenantIdentifierHolder = new ThreadLocal<>();

    public String getCurrentTenantIdentifier() {
        System.out.println("currentIdentifier: "+currentIdentifier);
        if (currentIdentifier != null) {
            // If not set, return a default value or handle accordingly
            return currentIdentifier;
        }
        return tenantIdentifierHolder.get();
    }

    public void setCurrentTenantIdentifier(String tenantIdentifier) {
        currentIdentifier = tenantIdentifier;
        tenantIdentifierHolder.set(tenantIdentifier);
    }

    public void clear() {
        tenantIdentifierHolder.remove();
    }
}