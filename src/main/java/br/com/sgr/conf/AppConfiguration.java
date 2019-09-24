package br.com.sgr.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.sgr.controller.EstabelecimentoController;
import br.com.sgr.repository.EstabelecimentoRepository;

@EnableWebMvc
@ConfigurationProperties
@ComponentScan(basePackageClasses = {EstabelecimentoRepository.class, EstabelecimentoController.class})
public class AppConfiguration {
	
	@Bean
	public MessageSource getMessageSource() {		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

}
