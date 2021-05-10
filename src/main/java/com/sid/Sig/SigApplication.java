package com.sid.Sig;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.sid.Sig.Repository.VergersRepository;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.vividsolutions.jts.io.ParseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


 @EnableSwagger2
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
 public class SigApplication implements CommandLineRunner {
@Autowired
VergersRepository vergersRepository;
	public static void main(String[] args) {
		SpringApplication.run(SigApplication.class, args);
	}


	@Configuration
	public class CorsConfig {

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurerAdapter() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
							.allowedHeaders("*");
				}
			};
		}
	}
	@Bean
	public JtsModule jtsModule()
	{
		return new JtsModule();
	}
	@Override
	public void run(String... args) throws Exception {



	}
	 private com.vividsolutions.jts.geom.Geometry wktToGeometry(String wellKnownText) throws ParseException {
		 WKTReader fromText = new WKTReader();
		 Geometry geom = null;
		 geom = fromText.read(wellKnownText);
		 return geom;
	 }
	 @Bean
	 public BCryptPasswordEncoder geBCryptPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}
