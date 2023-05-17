package com.example.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 */
@Component
@ConfigurationProperties(prefix = "users")
public class UserCluster {
    private List<User> userConfigs;

    public List<User> getUserConfigs() {
        return userConfigs;
    }

    public void setUserConfigs(List<User> userConfigs) {
        this.userConfigs = userConfigs;
    }
}
