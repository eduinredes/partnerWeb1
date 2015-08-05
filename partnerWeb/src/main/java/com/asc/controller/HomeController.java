package com.asc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return "hello";
	}

	/*
	 * @RequestMapping(value = "/") public String welcome(HttpServletRequest
	 * request, HttpServletResponse response) { LocaleResolver localeResolver =
	 * RequestContextUtils .getLocaleResolver(request);
	 * localeResolver.setLocale(request, response,
	 * StringUtils.parseLocaleString(""));
	 * 
	 * return ""; }
	 * 
	 * @RequestMapping(value = "/currentLocale") public @ResponseBody String
	 * getCurrentLocale(HttpServletRequest request, HttpServletResponse
	 * response) { Locale locale = RequestContextUtils.getLocale(request);
	 * LocaleResolver localeResolver = RequestContextUtils
	 * .getLocaleResolver(request); if
	 * (locale.getLanguage().equalsIgnoreCase("es")) {
	 * localeResolver.setLocale(request, response,
	 * StringUtils.parseLocaleString("en")); } else {
	 * localeResolver.setLocale(request, response,
	 * StringUtils.parseLocaleString("es")); } locale =
	 * RequestContextUtils.getLocale(request); return locale.getLanguage(); }
	 */
}
