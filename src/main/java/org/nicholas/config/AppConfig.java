package org.nicholas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.nicholas.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
