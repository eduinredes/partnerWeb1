package com.asc.service.interfaces;

import java.util.List;

import com.asc.entities.abstracts.AbstractEntity;

public class FilteredData<T extends AbstractEntity> {
	
	private List<T> myList;
	private long totaRegs;

	public List<T> getMyList() {
		return myList;
	}

	public void setMyList(List<T> myList) {
		this.myList = myList;
	}

	public long getTotaRegs() {
		return totaRegs;
	}

	public void setTotaRegs(long totaRegs) {
		this.totaRegs = totaRegs;
	}
}
