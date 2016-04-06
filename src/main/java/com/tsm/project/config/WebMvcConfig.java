package com.tsm.project.config;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tsm.project.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
	private static final String VIEWS = "/";

	private static final String RESOURCES_LOCATION = "/assets/";
	private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/employee").setViewName("app/emp/emp.view");
		registry.addViewController("/product").setViewName("app/prod/prod.view");
		registry.addViewController("/user").setViewName("app/user/user.view");
		registry.addViewController("/product_type").setViewName("app/product_type/product_type.view");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/customer").setViewName("app/customer/customer.view");
		registry.addViewController("/403").setViewName("/403");
		registry.addViewController("/logins").setViewName("/login");
		registry.addViewController("/trade").setViewName("app/trade/trade_system.view");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(VIEWS);
		resolver.setSuffix(".html");
		return resolver;
	}

	// fuc{
	// var dup = false ;
	// for(var i = 0 ; i < usser ; i++){
	// if(user[i].name == name){
	// dup = true ;
	// dasdasd
	// break ;
	// }
	// }
	// if(dup == false){
	//
	// }
	// }

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setCacheSeconds(5);
		return messageSource;
	}

	// @Override
	// public Validator getValidator() {
	// LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	// validator.setValidationMessageSource(messageSource());
	// return validator;
	// }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(ObjectMapperFactory.create());
		converters.add(converter);
	}

}