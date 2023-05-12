
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Manager;
import repositories.ManagerRepository;

@Service
@Transactional
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;


	public Collection<Manager> findAll() {
		Collection<Manager> result;
		Assert.notNull(this.managerRepository);
		result = this.managerRepository.findAll();
		Assert.notNull(result);

		return result;
	}

}
