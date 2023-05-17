
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Activity;
import repositories.ActivityRepository;

@Service
@Transactional
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;


	public ActivityService() {
		super();
	}

	public Collection<Activity> findActivitiesNotCancel() {

		Collection<Activity> activities;

		activities = this.activityRepository.findActivitiesNotCancel();
		return activities;
	}

}
