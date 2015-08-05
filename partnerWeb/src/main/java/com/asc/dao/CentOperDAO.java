package com.asc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.asc.dao.interfaces.AbstractHibernateDao;
import com.asc.entities.CentOper;
import com.asc.service.interfaces.FilteredData;
import com.asc.utils.StringUtil;
import com.google.common.base.Preconditions;

@Repository
public class CentOperDAO extends AbstractHibernateDao<CentOper> {

	public CentOperDAO() {
		setClazz(CentOper.class);
	}

	@Override
	public FilteredData<CentOper> findByCriteria(String filter, List<Order> ords, int inic, int top) {

		List<Disjunction> disj = new ArrayList<Disjunction>();

		Disjunction or = Restrictions.disjunction();
		if (!StringUtil.isEmptyOrNullValue(filter)) {
			or.add(Restrictions.ilike("id", "%" + filter + "%", MatchMode.ANYWHERE));
		}
		if (!StringUtil.isEmptyOrNullValue(filter)) {
			or.add(Restrictions.ilike("cdes", "%" + filter + "%", MatchMode.ANYWHERE));
		}
		disj.add(or);

		return super.findByCriteria(inic, top, null, disj, null, ords, true);
	}

	
}
