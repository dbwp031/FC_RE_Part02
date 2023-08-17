package com.example.fc_re_part02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
/*
* AuditorAware
* `@createdBy`, `LastModifiedBy`를 사용하면 어떻게든 auditing infrastructure를 사용한다.
* 그래서 사용해야 한다.
* */
@EnableJpaAuditing
@Configuration
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("uno");
    }
}
