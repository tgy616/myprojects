package com.tgy.sbwebjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@EnableAutoConfiguration(
		exclude = {MultipartAutoConfiguration.class}
)
@SpringBootApplication
public class SbwebjspApplication {
	public SbwebjspApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(SbwebjspApplication.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[]{SbwebjspApplication.class});
	}

	@Bean(
			name = {"multipartResolver"}
	)
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setResolveLazily(true);
		resolver.setMaxInMemorySize(40960);
		resolver.setMaxUploadSize(5242880L);
		return resolver;
	}
}
