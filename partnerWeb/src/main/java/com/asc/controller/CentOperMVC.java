package com.asc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asc.controller.abstracts.MyAbstractController;
import com.asc.controller.json.GenericJSonObject4DT;
import com.asc.entities.CentOper;
import com.asc.service.CentOperService;
import com.asc.service.interfaces.FilteredData;
import com.asc.service.interfaces.IGenericService;
import com.asc.utils.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class CentOperMVC extends MyAbstractController {

	@Autowired
	private IGenericService<CentOper> centOperServ;

	@RequestMapping(value = "/centOper")
	public String listCentOper(Model model) {
		
		CentOper cp = centOperServ.getById("5001");
		System.out.println(cp);
		cp.setCdes("otra desc " + cp.getId());
		centOperServ.update(cp);
		return "centOper";
	}

	@RequestMapping(value = "/centOperDT", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String accountDT(@RequestParam int iDisplayStart, @RequestParam int iDisplayLength,
			@RequestParam int iColumns, @RequestParam String sEcho, @RequestParam String sSearch,
			HttpServletRequest request, Model model) throws IOException {

		long totaRegs = centOperServ.countRegs();

		setValuesFromRequest_DT(request);

		FilteredData<CentOper> fd = centOperServ.listByCriteria(sSearch, orderColumns, iDisplayStart, iDisplayLength);

		List<CentOper> tt = fd.getMyList();
		GenericJSonObject4DT<CentOper> gene = new GenericJSonObject4DT<CentOper>(totaRegs, fd.getTotaRegs());
		gene.setAaData(tt);
		gene.setsEcho(sEcho);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(gene);
	}

	@Override
	public String getColumnNameByNumber(int col) {
		String colName = "id";
		switch (col) {
		case 1:
			colName = "cdes";
			break;
		}
		return (colName);
	}
}
