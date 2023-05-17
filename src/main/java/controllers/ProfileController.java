/*
 * ProfileController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Actor;
import domain.Gym;
import services.ActorService;
import services.GymService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private ActorService	actorService;
	@Autowired
	private GymService		gymService;
	//@Autowired
	//private LoginService	loginService;


	// MY profile ---------------------------------------------------------------
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public ModelAndView myprofile() {
		ModelAndView result;
		Actor perfil;
		perfil = this.actorService.findByPrincipal();
		final Actor actor = this.actorService.findOne(perfil.getId());

		result = new ModelAndView("profile/myprofile");
		result.addObject("perfil", perfil);
		result.addObject("actor", actor);
		System.out.println("name: " + perfil.getName());
		System.out.println("nameactor: " + actor.getName());
		return result;
	}

	@RequestMapping(value = "/myprofile/edit", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView result;
		final Actor myprofile = this.actorService.findByPrincipal();
		result = new ModelAndView("profile/myprofile/edit");
		result.addObject("myprofile", myprofile);

		return result;
	}

	@RequestMapping(value = "/myprofile/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Actor myprofile, final BindingResult binding) {
		ModelAndView result;
		Actor myprofile2;
		try {
			myprofile2 = this.actorService.comprobarPA(myprofile, binding);
			if (binding.hasErrors())
				result = this.createEditModelAndView(myprofile, "actor.save.error");
			else {
				myprofile2 = this.actorService.comprobarPA2(myprofile, binding);
				//result = new ModelAndView("redirect:/profile/myprofile.do");
				result = new ModelAndView("redirect:/profile/myprofile");
				myprofile2 = this.actorService.save(myprofile);
			}
		} catch (final Throwable exc) {
			result = this.createEditModelAndView(myprofile, "actor.save.error");
		}

		return result;
	}

	@RequestMapping(value = "/gym", method = RequestMethod.GET)
	public ModelAndView catalogueGyms() {
		ModelAndView result;
		final Collection<Gym> gyms = this.gymService.findAll();
		result = new ModelAndView("profile/gym");
		result.addObject("requestURI", "profile/gym.do");
		result.addObject("gyms", gyms);
		return result;
	}
	/*
	 * private ModelAndView createEditModelAndView(final Actor myprofile) {
	 * final ModelAndView result = this.createEditModelAndView(myprofile, null);
	 *
	 * return result;
	 * }
	 */
	private ModelAndView createEditModelAndView(final Actor myprofile, final String msg) {
		final ModelAndView result = new ModelAndView("profile/myprofile/edit");
		result.addObject("myprofile", myprofile);
		result.addObject("msg", msg);

		return result;
	}
	// Profile foreign
	/**
	 * @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	 *                       public ModelAndView myprofile(@RequestParam(required = false) final Integer actorId) {
	 *                       ModelAndView result;
	 *                       Actor perfil;
	 *                       if (actorId != null) {
	 *                       Actor actor = this.actorService.findOne(actorId);
	 *                       if (actor == null)
	 *                       result = new ModelAndView("redirect:/panic/misc.do");
	 *                       else {
	 *                       perfil = this.actorService.findByPrincipal();
	 *                       result = new ModelAndView("profile/myprofile");
	 *                       result.addObject("perfil", perfil);
	 *                       result.addObject("actor", actor);
	 *                       }
	 *                       } else {
	 *                       perfil = this.actorService.findByPrincipal();
	 *                       result = new ModelAndView("redirect:/profile/myprofile.do?actoId=" + perfil.getId());
	 *                       }
	 *                       return result;
	 *                       }
	 */
	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("profile/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("profile/action-2");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-3")
	public ModelAndView action3() {
		throw new RuntimeException("Oops! An *expected* exception was thrown. This is normal behaviour.");
	}

}
