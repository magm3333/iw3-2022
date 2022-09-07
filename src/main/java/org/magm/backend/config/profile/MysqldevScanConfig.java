package org.magm.backend.config.profile;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.magm.backend", 
excludeFilters = {
})


//Entidades
@EntityScan(basePackages = { 
		"org.magm.backend.model", 
		"org.magm.backend.auth", 
		"org.magm.backend.integration.cli1.model", 
		"org.magm.backend.integration.cli2.model" 
})

@Profile("mysqldev")
public class MysqldevScanConfig {

}

