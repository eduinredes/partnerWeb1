package com.asc.controller.json;

import java.util.List;

import com.asc.entities.abstracts.AbstractEntity;

public class GenericJSonObject4DT<T extends AbstractEntity> {

	private String sEcho;
	private long iTotalRecords;
	private long iTotalDisplayRecords;

	private List<T> aaData;

	public GenericJSonObject4DT(long tota, long disp) {
		setiTotalDisplayRecords(disp);
		setiTotalRecords(tota);
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
}
