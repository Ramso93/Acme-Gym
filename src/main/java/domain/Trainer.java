
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Trainer extends Actor {

	//constructor
	/*
	 * public Trainer() {
	 * super();
	 * }
	 */
	//atributos

	//relacion
	private Gym						gym;
	private Collection<Activity>	activities;
	private Curriculum				curriculum;


	@Valid
	@ManyToOne(optional = true)
	public Gym getGym() {
		return this.gym;
	}

	public void setGym(final Gym gym) {
		this.gym = gym;
	}

	@ManyToMany
	public Collection<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(final Collection<Activity> activities) {
		this.activities = activities;
	}

	//@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	@OneToOne(optional = true)
	public Curriculum getCurriculum() {
		return this.curriculum;
	}
	public void setCurriculum(final Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}
