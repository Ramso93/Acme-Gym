/*
 * AdministratorController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Manager;
import services.ManagerService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private ManagerService managerService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/listManagers", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		final Collection<Manager> managers;

		managers = this.managerService.findAll();
		result = new ModelAndView("administrator/listManagers");
		result.addObject("requestURI", "administrator/listManagers.do");
		result.addObject("managers", managers);
		return result;
	}
	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		//request.
		ModelAndView result;
		result = new ModelAndView("administrator/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

}
