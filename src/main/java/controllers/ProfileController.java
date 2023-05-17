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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Actor;
import domain.Gym;
import domain.Trainer;
import domain.Workout;
import services.ActivityService;
import services.ActorService;
import services.GymService;
import services.TrainerService;
import services.WorkoutService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private ActorService	actorService;
	@Autowired
	private GymService		gymService;
	@Autowired
	private ActivityService	activityService;
	@Autowired
	private WorkoutService	workoutService;

	@Autowired
	private TrainerService	trainerService;


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

	@RequestMapping(value = "/listActivity", method = RequestMethod.GET)
	public ModelAndView cataloguetActivity() {
		ModelAndView result;
		Collection<Activity> activities;

		activities = this.activityService.findActivitiesNotCancel();

		result = new ModelAndView("profile/listActivity");
		result.addObject("activities", activities);
		result.addObject("requestURI", "profile/listActivity.do");

		return result;
	}

	@RequestMapping(value = "/listWorkout", method = RequestMethod.GET)
	public ModelAndView catalogueWorkout() {
		ModelAndView result;
		Collection<Workout> workouts;

		workouts = this.workoutService.findAll();

		result = new ModelAndView("profile/listWorkout");
		result.addObject("workouts", workouts);
		result.addObject("requestURI", "profile/listWorkout.do");

		return result;
	}
	@RequestMapping(value = "/Workout", method = RequestMethod.GET)
	public ModelAndView Workout(@RequestParam final int workoutId) {
		ModelAndView result;
		Workout workout;

		workout = this.workoutService.findById(workoutId);
		System.err.println("\n\ntitle: " + workout.getDescription() + " " + workout.getId() + "\n\n");
		result = new ModelAndView("profile/Workout");
		result.addObject("workout", workout);

		return result;
	}

	@RequestMapping(value = "/listTrainerByActivity", method = RequestMethod.GET)
	public ModelAndView listTrainerByActivity(@RequestParam final int activityId) {
		ModelAndView result;
		Collection<Trainer> trainers;

		trainers = this.trainerService.findAllByIDActivity(activityId);
		result = new ModelAndView("profile/listTrainerByActivity");
		result.addObject("trainers", trainers);

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
