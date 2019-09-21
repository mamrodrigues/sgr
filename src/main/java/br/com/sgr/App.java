package br.com.sgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.sgr.conf.YAMLConfig;

@EnableConfigurationProperties
@SpringBootApplication
public class App {
	
	@Autowired
	public YAMLConfig config;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
