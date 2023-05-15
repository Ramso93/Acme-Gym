
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

	public Manager findOne(final int managerId) {
		Assert.notNull(managerId);
		final Manager manager = this.managerRepository.findOne(managerId);

		return manager;
	}
	public void ban(final int managerId) {
		final Manager manager = this.findOne(managerId);
		Assert.notNull(manager);
		if (manager.getUserAccount().isEnabled())
			manager.getUserAccount().setEnabled(false);
		else
			manager.getUserAccount().setEnabled(true);
		this.save(manager);
	}
	public Manager save(final Manager manager) {
		Assert.notNull(manager);
		Assert.notNull(manager.getUserAccount());
		Manager result;
		result = this.managerRepository.save(manager);

		return result;
	}

}
