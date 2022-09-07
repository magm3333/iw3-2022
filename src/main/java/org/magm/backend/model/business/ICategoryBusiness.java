package org.magm.backend.model.business;

import java.util.List;

import org.magm.backend.model.Category;

public interface ICategoryBusiness {

	public Category load(long id) throws NotFoundException, BusinessException;

	public Category load(String category) throws NotFoundException, BusinessException;

	public List<Category> list() throws BusinessException;

	public Category add(Category category) throws FoundException, BusinessException;

	public Category update(Category category) throws NotFoundException, BusinessException;

	public void delete(long id) throws NotFoundException, BusinessException;

}
