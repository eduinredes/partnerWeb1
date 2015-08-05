package com.asc.dao.interfaces;

import java.util.List;

import org.hibernate.criterion.Order;

import com.asc.entities.abstracts.AbstractEntity;
import com.asc.service.interfaces.FilteredData;

public interface IGenericDao<T extends AbstractEntity> {

	T findOne(final Long id);

	T findOne(final String id);

	List<T> findAll();

	FilteredData<T> findByCriteria(String filter, List<Order> ords, int inic, int top);

	void create(T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final Long id);

	long count();
}
