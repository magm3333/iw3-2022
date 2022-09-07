package org.magm.backend.integration.cli1.model.business;

import java.util.List;
import java.util.Optional;

import org.magm.backend.integration.cli1.model.ProductCli1;
import org.magm.backend.integration.cli1.model.ProductCli1JsonDeserializer;
import org.magm.backend.integration.cli1.model.persistence.ProductCli1Respository;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.ICategoryBusiness;
import org.magm.backend.model.business.IProductBusiness;
import org.magm.backend.model.business.NotFoundException;
import org.magm.backend.util.JsonUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductCli1Business implements IProductCli1Business {

	@Autowired(required = false)
	private ProductCli1Respository productDAO;

	@Override
	public ProductCli1 load(String codCli1) throws NotFoundException, BusinessException {
		Optional<ProductCli1> r;
		try {
			r = productDAO.findOneByCodCli1(codCli1);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
		if (r.isEmpty()) {
			throw NotFoundException.builder().message("No se encuentra el Producto codCli1=" + codCli1).build();
		}
		return r.get();
	}

	@Override
	public List<ProductCli1> list() throws BusinessException {
		try {
			return productDAO.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	@Autowired(required = false)
	private IProductBusiness productBaseBusiness;

	@Override
	public ProductCli1 add(ProductCli1 product) throws FoundException, BusinessException {

		try {
			productBaseBusiness.load(product.getId());
			throw FoundException.builder().message("Se encontró el Producto id=" + product.getId()).build();
		} catch (NotFoundException e) {
		}

		if (productDAO.findOneByCodCli1(product.getCodCli1()).isPresent()) {
			throw FoundException.builder().message("Se encontró el Producto código=" + product.getCodCli1()).build();
		}


		try {
			return productDAO.save(product);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	@Autowired
	private ICategoryBusiness categoryBusiness;

	@Override
	public ProductCli1 addExternal(String json) throws FoundException, BusinessException {
		ObjectMapper mapper = JsonUtiles.getObjectMapper(ProductCli1.class,
				new ProductCli1JsonDeserializer(ProductCli1.class, categoryBusiness));
		ProductCli1 product = null;
		try {
			product = mapper.readValue(json, ProductCli1.class);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}

		return add(product);

	}


}
