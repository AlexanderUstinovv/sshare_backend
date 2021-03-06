package com.sshare.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "spring.sshare")
@Validated
@Data
public class SshareProperties {

    @Valid
    public FileStore fileStore = new FileStore();

    @Valid
    public JwtConfig jwtConfig = new JwtConfig();

    @Data
    public class FileStore {
        @NotNull
        private String path;
    }

    @Data
    public class JwtConfig {
        @NotNull
        private String jwtSecret;
        @NotNull
        private int jwtExpirationInMs;
    }
}
