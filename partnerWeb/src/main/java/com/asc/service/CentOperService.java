package com.asc.service;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asc.dao.interfaces.IGenericDao;
import com.asc.entities.CentOper;
import com.asc.service.interfaces.FilteredData;
import com.asc.service.interfaces.IGenericService;

@Service
public class CentOperService implements IGenericService<CentOper> {

	@Autowired
	private IGenericDao<CentOper> centOperDAO;

	@Transactional
	public void add(CentOper a) {
		this.centOperDAO.create(a);
	}

	@Transactional
	public void update(CentOper a) {
		this.centOperDAO.update(a);
	}

	@Transactional
	public List<CentOper> list() {
		return this.centOperDAO.findAll();
	}

	@Transactional
	public CentOper getById(Long id) {
		return this.centOperDAO.findOne(id);
	}

	@Transactional
	public void removeById(Long id) {
		this.centOperDAO.deleteById(id);
	}

	@Transactional
	public void remove(CentOper a) {
		this.centOperDAO.delete(a);
	}

	@Transactional
	public long countRegs() {
		return this.centOperDAO.count();
	}

	@Transactional
	public FilteredData<CentOper> listByCriteria(String filter, List<Order> ords, int inic, int top) {
		return this.centOperDAO.findByCriteria(filter, ords, inic, top);
	}

	@Transactional
	public CentOper getById(String id) {
		return this.centOperDAO.findOne(id);
	}

}
