
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Trainer;
import repositories.TrainerRepository;

@Service
@Transactional
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;


	public Collection<Trainer> findAllByIDActivity(final int activityId) {
		final Collection<Trainer> result = this.trainerRepository.findAllByIDActivity(activityId);
		return result;
	}
}
