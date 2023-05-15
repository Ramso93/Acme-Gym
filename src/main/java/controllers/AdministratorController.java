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

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Customer;
import domain.Gym;
import domain.Manager;
import domain.Workout;
import services.AdministratorService;
import services.ManagerService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private ManagerService			managerService;
	@Autowired
	private AdministratorService	administratorService;


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
		for (final Manager manager : managers)
			System.out.println("manager: " + manager.getUserAccount().getEnabled());
		result = new ModelAndView("administrator/listManagers");
		result.addObject("requestURI", "administrator/listManagers.do");
		result.addObject("managers", managers);

		return result;
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public ModelAndView statistics() {
		ModelAndView result;
		Collection<Object[]> statistics1 = new ArrayList<>();
		Collection<Object[]> statistics2 = new ArrayList<Object[]>();
		Collection<Object[]> statistics3 = new ArrayList<Object[]>();
		Collection<Gym> statistics4 = new ArrayList<Gym>();
		Collection<Customer> statistics5 = new ArrayList<Customer>();
		Collection<Object[]> statistics6 = new ArrayList<Object[]>();
		Collection<Object[]> statistics7 = new ArrayList<Object[]>();
		Collection<Workout> statistics8 = new ArrayList<Workout>();

		statistics1 = this.administratorService.statistics();
		statistics2 = this.administratorService.statistics2();
		statistics3 = this.administratorService.statistics3();
		statistics4 = this.administratorService.statistics4();
		statistics5 = this.administratorService.statistics5();
		statistics6 = this.administratorService.statistics6();
		statistics7 = this.administratorService.statistics7();
		statistics8 = this.administratorService.statistics8();

		result = new ModelAndView("administrator/statistics");
		result.addObject("requestURI", "administrator/statistics.do");
		result.addObject("statistics1", statistics1);
		result.addObject("statistics2", statistics2);
		result.addObject("statistics3", statistics3);
		result.addObject("statistics4", statistics4);
		result.addObject("statistics5", statistics5);
		result.addObject("statistics6", statistics6);
		result.addObject("statistics7", statistics7);
		result.addObject("statistics8", statistics8);

		return result;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.GET)
	public ModelAndView banear(@RequestParam final int managerId) {
		ModelAndView result;
		try {
			this.managerService.ban(managerId);
			result = new ModelAndView("redirect:/administrator/listManagers.do");
		} catch (final Throwable ex) {
			result = new ModelAndView("redirect:/administrator/listManagers.do");
		}

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
