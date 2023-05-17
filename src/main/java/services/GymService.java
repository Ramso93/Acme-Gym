
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Gym;
import repositories.GymRepository;

@Service
@Transactional
public class GymService {

	@Autowired
	private GymRepository gymRepository;


	public Collection<Gym> findAll() {
		final Collection<Gym> gyms = this.gymRepository.findAll();
		return gyms;
	}
}
