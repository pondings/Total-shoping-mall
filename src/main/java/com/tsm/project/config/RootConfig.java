package com.tsm.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.tsm.project" })
@Import({ PersistenceConfig.class, SecurityConfig.class })
public class RootConfig {
	
}