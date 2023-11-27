package com.multiserverservice.transaction.config;

public class RequestContext {
    String currentIdentifier = null;

    private static final ThreadLocal<String> sourceIdentifierHolder = new ThreadLocal<>();

    public String getCurrentSourceIdentifier() {
        System.out.println("currentIdentifier: "+currentIdentifier);
        if (currentIdentifier != null) {
            // If not set, return a default value or handle accordingly
            return currentIdentifier;
        }
        return sourceIdentifierHolder.get();
    }

    public void setCurrentSourceIdentifier(String sourceIdentifier) {
        currentIdentifier = sourceIdentifier;
        sourceIdentifierHolder.set(sourceIdentifier);
    }

    public void clear() {
        sourceIdentifierHolder.remove();
    }

    // IN future two request context should be made to avoid scheduled task/cron internally setting value in currentIdentifier
}