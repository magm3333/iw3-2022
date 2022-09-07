package org.magm.backend.integration.cli2.model.business;

import java.util.Date;
import java.util.List;

import org.magm.backend.integration.cli2.model.ProductCli2;
import org.magm.backend.integration.cli2.model.ProductCli2SlimView;
import org.magm.backend.model.business.BusinessException;

public interface IProductCli2Business {
	public List<ProductCli2> listExpired(Date date) throws BusinessException;
	public List<ProductCli2SlimView> listSlim() throws BusinessException;
}

