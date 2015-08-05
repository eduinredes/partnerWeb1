package com.asc.controller.abstracts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.asc.exceptions.MyWebException;
import com.asc.utils.StringUtil;

public class MyAbstractController {

	public static final int SIZE_STR_CODE = 6;
	public static final int SIZE_SMALL_DESC = 70;
	
	
	public static final int SIZE_DEF_STR = 45;
	public static final int SIZE_BIG_DESC = 255;

	protected int iSortingCols;
	protected List<Boolean> bSortable;
	protected List<Integer> iSortCol;
	protected List<String> sSortDir;
	protected List<Order> orderColumns;

	// == error handling == //

	@ExceptionHandler(MyWebException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView myWebExceptionHandler(MyWebException ex) {
		ModelAndView mav = new ModelAndView("/errors/errors.html");
		mav.addObject("error", ex.getMessage());
		return mav;
	}

	public void setValuesFromRequest_DT(HttpServletRequest rq) {
		int i, col;

		this.iSortingCols = parseIntegerFromRequest("iSortingCols", rq);

		this.bSortable = parseBooleanListFromRequest(iSortingCols,
				"bSortable_", rq);

		this.iSortCol = parseIntegerListFromRequest(iSortingCols, "iSortCol_",
				rq);

		this.sSortDir = parseStringListFromRequest(iSortingCols, "sSortDir_",
				rq);

		orderColumns = new ArrayList<Order>();

		for (i = 0; i < iSortingCols; i++) {
			if (bSortable.get(i)) {
				col = iSortCol.get(i);
				String colName = getColumnNameByNumber(col);
				if (!StringUtil.isEmptyOrNullValue(colName)) {
					if (sSortDir.get(i).equalsIgnoreCase("asc")) {
						orderColumns.add(Order.asc(colName));
					} else {
						orderColumns.add(Order.desc(colName));
					}
				}
			}
		}
	}

	public String parseStringFromRequest(String attribute, HttpServletRequest rq) {
		return (String) rq.getParameter(attribute);
	}

	public List<String> parseStringListFromRequest(int nCols, String string,
			HttpServletRequest rq) {
		List<String> strings = new ArrayList<String>();
		for (int i = 0; i < nCols; i++) {
			strings.add(parseStringFromRequest(string + i, rq));

		}
		return strings;
	}

	public List<Integer> parseIntegerListFromRequest(int nCols, String string,
			HttpServletRequest rq) {
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < nCols; i++) {
			ints.add(parseIntegerFromRequest(string + i, rq));

		}
		return ints;
	}

	public int parseIntegerFromRequest(String attribute, HttpServletRequest rq) {
		String value = (String) rq.getParameter(attribute);
		int number = 0;
		try {
			number = Integer.parseInt(value);
		} catch (Exception e) {
			number = 0;
		}
		return number;
	}

	public List<Boolean> parseBooleanListFromRequest(int nCols, String string,
			HttpServletRequest rq) {
		List<Boolean> bools = new ArrayList<Boolean>();
		for (int i = 0; i < nCols; i++) {
			bools.add(parseBoolFromRequest(string + i, rq));

		}
		return bools;
	}

	public boolean parseBoolFromRequest(String attribute, HttpServletRequest rq) {
		String value = (String) rq.getParameter(attribute);
		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			return false;
		}
	}

	public String getColumnNameByNumber(int col) {
		return "";
	}
}
