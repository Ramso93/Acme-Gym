
package services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import domain.Actor;
import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;

@Service
@Transactional
public class ActorService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private ActorRepository		actorRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private UserAccountService	userAccountService;


	// Constructors -----------------------------------------------------------

	public ActorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public List<Actor> findAll() {
		List<Actor> result;

		result = this.actorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Actor findOne(final int actorId) {
		Assert.isTrue(actorId != 0);

		Actor result;

		result = this.actorRepository.findOne(actorId);
		Assert.notNull(result);

		return result;
	}

	public Actor save(final Actor actor) {
		Assert.notNull(actor);

		Actor result;

		result = this.actorRepository.save(actor);

		return result;
	}

	public void delete(final Actor actor) {
		Assert.notNull(actor);
		Assert.isTrue(actor.getId() != 0);
		Assert.isTrue(this.actorRepository.exists(actor.getId()));

		this.actorRepository.delete(actor);
	}

	// Other business methods -------------------------------------------------

	public UserAccount findUserAccount(final Actor actor) {
		Assert.notNull(actor);

		UserAccount result;

		result = this.userAccountService.findByActor(actor);

		return result;
	}
	public Actor findByPrincipal() {
		Actor result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);

		result = this.findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
	public Actor findByUserAccount(final UserAccount userAccount) {
		Assert.notNull(userAccount);
		Actor result;

		result = this.actorRepository.findByUserAccountId(userAccount.getId());

		return result;
	}

	public Actor comprobarPA(final Actor myprofile, final BindingResult binding) {
		final Actor result = this.findByPrincipal();
		this.comprobarpostalAddres(myprofile.getPostalAddres(), binding);

		return result;
	}
	public Actor comprobarPA2(final Actor myprofile, final BindingResult binding) {
		final Actor result = this.findByPrincipal();
		result.setName(myprofile.getName());
		result.setSurname(myprofile.getSurname());
		result.setPhoneNumber(myprofile.getPhoneNumber());
		result.setEmail(myprofile.getEmail());
		result.setPostalAddres(myprofile.getPostalAddres());
		result.setCity(myprofile.getCity());
		result.setCountry(myprofile.getCountry());

		this.comprobarpostalAddres(myprofile.getPostalAddres(), binding);

		return result;
	}
	private boolean comprobarpostalAddres(final String postalAddres, final BindingResult binding) {
		FieldError error;
		String[] codigos;
		boolean result;

		if (postalAddres == null || postalAddres.isEmpty())
			result = true;
		else
			result = false;

		if (!result)
			if (postalAddres.matches("^[0-9]{5}$"))
				result = true;
			else {
				codigos = new String[1];
				codigos[0] = "actor.postalAddress.error";
				error = new FieldError("actorForm", "postalAddres", postalAddres, false, codigos, null, "");
				binding.addError(error);
			}

		return result;
	}
	// ADMIN -----

	/*
	 * public Administrator findByID(final int actorId) {
	 * Assert.isTrue(actorId != 0);
	 *
	 * Administrator result;
	 *
	 * result = this.administratorRepository.findByID(actorId);
	 * Assert.notNull(result);
	 *
	 * return result;
	 * }
	 */
}
