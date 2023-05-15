
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Customer;
import domain.Gym;
import domain.Workout;
import repositories.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;


	public AdministratorService() {
		super();
	}

	public Collection<Object[]> statistics() {
		final Collection<Object[]> result = this.administratorRepository.findMinMaxAvgStdDevByManager();
		/*
		 * for (final Object[] objects : result)
		 * for (final Object objects2 : objects)
		 * System.out.println("object: " + objects2);
		 */
		return result;
	}
	public Collection<Object[]> statistics2() {
		final Collection<Object[]> result = this.administratorRepository.findMinMaxAvgStdDevByCustomer();

		return result;
	}
	public Collection<Object[]> statistics3() {
		final Collection<Object[]> result = this.administratorRepository.findMinMaxAvgStdDevByGym();

		return result;
	}
	public Collection<Gym> statistics4() {
		final Collection<Gym> result = this.administratorRepository.findGymMasActividades();

		return result;
	}
	public Collection<Customer> statistics5() {
		final Collection<Customer> result = this.administratorRepository.findClientesMasActividades();

		return result;
	}
	public Collection<Object[]> statistics6() {
		final Collection<Object[]> result = this.administratorRepository.findMinAvgMaxEntrenamientos_Gym();

		return result;
	}
	public Collection<Object[]> statistics7() {
		final Collection<Object[]> result = this.administratorRepository.findMinAvgMaxPasos_Entrenamiento();

		return result;
	}
	public Collection<Workout> statistics8() {
		final Collection<Workout> result = this.administratorRepository.findEntrenamientosOrdenDec_estrellas();

		return result;
	}

}
