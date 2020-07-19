package br.org.takeo.jokenpo.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@PropertySource("classpath:JokenPoResources.properties")
public class MessageResourcesConfiguration {

	@Bean
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("classpath:JokenPoResources");
		return bundle;
	}
	
	@Bean
	public LocalValidatorFactoryBean validatorFactory() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(getMessageSource());
		
		return factory;
	}
	
}
