package org.magm.backend.integration.cli2.model;

//https://docs.spring.io/spring-data/commons/docs/current/reference/html/#projections
public interface ProductCli2SlimView {
	Long getId();

	String getProduct();

	Double getPrice();

	Category getCategory();

	interface Category {
		String getCategory();
	}
}
