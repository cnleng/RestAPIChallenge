package com.cnleng.configuration;


//@Configuration
//@ConfigurationProperties(prefix = "appConfiguration")
public class AppConfiguration {
    private String backEndUrl;
    private boolean enableSwagger = true;

    public AppConfiguration() {
    }

    public final String getBackEndUrl() {
        return backEndUrl;
    }

    public final void setBackEndUrl(String backEndUrl) {
        this.backEndUrl = backEndUrl;
    }

    public final boolean isEnableSwagger() {
        return enableSwagger;
    }

    public final void setEnableSwagger(boolean enableSwagger) {
        this.enableSwagger = enableSwagger;
    }
}
