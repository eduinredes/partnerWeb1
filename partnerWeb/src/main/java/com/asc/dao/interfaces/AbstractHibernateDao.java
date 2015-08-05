package com.asc.dao.interfaces;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asc.entities.abstracts.AbstractEntity;
import com.asc.service.interfaces.FilteredData;
import com.google.common.base.Preconditions;

@Repository
public abstract class AbstractHibernateDao<T extends AbstractEntity> implements IGenericDao<T> {

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getById(final Long id) {
		Preconditions.checkArgument(id != null);
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	public void delete(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().delete(entity);
	}

	public void deleteById(final Long entityId) {
		final T entity = this.getById(entityId);
		Preconditions.checkState(entity != null);
		this.delete(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		Preconditions.checkNotNull(entity);
		return (T) getCurrentSession().merge(entity);
	}

	public void create(T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().save(entity);
	}

	public long count() {
		return (long) getCurrentSession().createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findOne(final Long id) {
		Preconditions.checkArgument(id != null);
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public T findOne(final String id) {
		Preconditions.checkArgument(id != null);
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	@SuppressWarnings("unchecked")
	public FilteredData<T> findByCriteria(int inic, int maxr, List<Criterion> rest, List<Disjunction> disj,
			Projection proj, List<Order> ords, boolean count) {
		FilteredData<T> tmp = new FilteredData<T>();
		Criteria crt = getCurrentSession().createCriteria(clazz);
		if (rest != null) {
			for (Criterion tmp_rest : rest) {
				crt.add(tmp_rest);
			}
		}

		if (disj != null) {
			for (Disjunction tmp_dist : disj) {
				crt.add(tmp_dist);
			}
		}

		if (proj != null) {
			crt.setProjection(proj);
		}

		if (ords != null) {
			for (Order tmp_ords : ords) {
				crt.addOrder(tmp_ords);
			}
		}

		if (count) {
			crt.setProjection(Projections.rowCount());
			tmp.setTotaRegs((Long) crt.uniqueResult());
		}

		crt.setProjection(null);

		if (inic >= 0) {
			crt.setFirstResult(inic);
		}

		if (maxr >= 0) {
			crt.setMaxResults(maxr);
		}
		tmp.setMyList(crt.list());
		return (tmp);
	}
}
