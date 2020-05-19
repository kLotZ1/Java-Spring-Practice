package com.example.backend6;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;

public class ThymleafConfiguration {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
