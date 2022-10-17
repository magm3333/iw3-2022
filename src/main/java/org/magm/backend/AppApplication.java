package org.magm.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

@SecurityScheme(
		  name = "Bearer Authentication",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer",
		  paramName = "bearer"
		)

@SpringBootApplication
@Slf4j
public class AppApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Value("${spring.profiles.active}")
	private String profile;

	//@Autowired
	//private ProductRepository productDAO;
	
	//@Autowired
	//private EmailBusiness emailBusiness;

	
	@Override
	public void run(String... args) throws Exception {
		log.info("Perfil Activo: {}", profile);

		//emailBusiness.sendSimpleMessage("magm@iua.edu.ar", "Mail de prueba", "Prueba de mail, perfil activo="+profile);
		
		//log.info("Cantidad de productos de la categoría id=1: {}",productDAO.countProductsByCategory(1));
		
		//log.info("Set stock=true producto id que no existe, resultado={}", productDAO.setStock(true, 3333));
		
		//log.info("Set stock=true producto id que existe, resultado={}", productDAO.setStock(true, 1));

	}

}
