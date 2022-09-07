package org.magm.backend.integration.cli2.model.business;

import java.util.Date;
import java.util.List;

import org.magm.backend.integration.cli2.model.ProductCli2;
import org.magm.backend.integration.cli2.model.ProductCli2SlimView;
import org.magm.backend.integration.cli2.model.persistence.ProductCli2Respository;
import org.magm.backend.model.business.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductCli2Business implements IProductCli2Business {

	@Autowired(required = false)
	private ProductCli2Respository productDAO;

	@Override
	public List<ProductCli2> listExpired(Date date) throws BusinessException {
		try {
			return productDAO.findByExpirationDateBeforeOrderByExpirationDateDesc(date);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}
	}

	@Override
	public List<ProductCli2SlimView> listSlim() throws BusinessException {
		try {
			return productDAO.findByOrderByPriceDesc();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw BusinessException.builder().ex(e).build();
		}

	}

}

