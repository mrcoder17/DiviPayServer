package ru.nsu.boxberger.DiviPay;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ru.nsu.boxberger.DiviPay.repository")
public class ApplicationConfig {
}
