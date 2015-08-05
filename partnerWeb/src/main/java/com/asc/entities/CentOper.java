package com.asc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.asc.controller.abstracts.MyAbstractController;
import com.asc.entities.abstracts.AbstractEntityIDStr;

/**
 * CentOper - Centro Operativo
 */

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "centOper")
public class CentOper extends AbstractEntityIDStr {

	private static final long serialVersionUID = 1L;

	private String cdes;

	public CentOper() {
	}

	public CentOper(String cdes) {
		this();
		this.setCdes(cdes);
	}

	@Id
	@Column(name = "code", unique = true, nullable = false, length = MyAbstractController.SIZE_STR_CODE)
	@Override
	public String getId() {
		return this.id;
	}

	public void setCode(String c) {
		setId(c);
	}

	@Column(name = "cdes", unique = true, nullable = false, length = MyAbstractController.SIZE_SMALL_DESC)
	public String getCdes() {
		return cdes;
	}

	public void setCdes(String cdes) {
		this.cdes = cdes;
	}

	@Override
	public String toString() {
		return "CentOper [code = " + id + " - cdes=" + cdes + "]";
	}

}