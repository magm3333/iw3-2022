package org.magm.backend;

import org.magm.backend.model.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AppApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Value("${spring.profiles.active}")
	private String profile;

	@Autowired
	private ProductRepository productDAO;

	@Override
	public void run(String... args) throws Exception {
		log.info("Perfil Activo: {}", profile);

		log.info("Cantidad de productos de la categoría id=1: {}", productDAO.countProductsByCategory(1));
		log.info("Set stock=true producto id que no existe, resultado={}", productDAO.setStock(true, 333));
		
		

	}

}
