
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Gym;
import domain.Manager;
import repositories.ManagerRepository;
import security.Authority;
import security.UserAccount;

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

	public Manager create() {
		Manager result;
		UserAccount userAccount;
		Authority authority;
		Collection<Gym> gyms;

		authority = new Authority();
		userAccount = new UserAccount();
		gyms = new ArrayList<Gym>();

		authority.setAuthority("MANAGER");
		userAccount.addAuthority(authority);

		result = new Manager();

		result.setUserAccount(userAccount);
		result.setGyms(gyms);

		return result;
	}

}
