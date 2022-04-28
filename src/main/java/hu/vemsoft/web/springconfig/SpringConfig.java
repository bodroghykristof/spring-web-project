package hu.vemsoft.web.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Base configuration for Spring framework
 */
@ComponentScan(basePackages = "hu.vemsoft.web")
@Configuration
public class SpringConfig {
}
