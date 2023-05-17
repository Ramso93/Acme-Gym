
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Workout;
import repositories.WorkoutRepository;

@Service
@Transactional
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;


	public Collection<Workout> findAll() {
		// TODO Auto-generated method stub
		Collection<Workout> workouts;

		workouts = this.workoutRepository.findAll();

		return workouts;
	}
}
