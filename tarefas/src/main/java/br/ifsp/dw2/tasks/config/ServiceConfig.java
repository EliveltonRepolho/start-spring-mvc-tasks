package br.ifsp.dw2.tasks.config;

import br.ifsp.dw2.tasks.service.TaskService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TaskService.class)
public class ServiceConfig {

}
