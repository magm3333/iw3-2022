package org.magm.backend.integration.cli1.model.business;

import java.util.List;

import org.magm.backend.integration.cli1.model.ProductCli1;
import org.magm.backend.model.business.BusinessException;
import org.magm.backend.model.business.FoundException;
import org.magm.backend.model.business.NotFoundException;

public interface IProductCli1Business {

	public ProductCli1 load(String codCli1) throws NotFoundException, BusinessException;
	public List<ProductCli1> list() throws BusinessException;
	public ProductCli1 add(ProductCli1 product) throws FoundException, BusinessException;
	public ProductCli1 addExternal(String json) throws FoundException, BusinessException;
	
}

