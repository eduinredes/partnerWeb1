package com.asc.service.interfaces;

import java.util.List;

import org.hibernate.criterion.Order;

import com.asc.entities.abstracts.AbstractEntity;

public interface IGenericService<T extends AbstractEntity> {
	public void add(T entity);

	public void update(T entity);

	public List<T> list();

	public FilteredData<T> listByCriteria(String filter, List<Order> ords,
			int inic, int top);

	public T getById(Long id);
	
	public T getById(String id);

	public void removeById(Long id);

	public void remove(T entity);

	public long countRegs();
}
