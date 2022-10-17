package com.tworuszka.accounts.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */
@Configuration
@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountsServiceConfig {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

    @Override
    public String toString() {
        return "AccountsServiceConfig{" +
                "msg='" + msg + '\'' +
                ", buildVersion='" + buildVersion + '\'' +
                ", mailDetails=" + mailDetails +
                ", activeBranches=" + activeBranches +
                '}';
    }
}
