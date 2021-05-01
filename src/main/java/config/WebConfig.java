package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"controller"})
@ComponentScan(basePackages = {"service"})
@ComponentScan(basePackages = {"repository"})
public class WebConfig {

}
