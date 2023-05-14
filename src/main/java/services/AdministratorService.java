
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		for (final Object[] objects : result)
			for (final Object objects2 : objects)
				System.out.println("object: " + objects2);
		return result;
	}

}
