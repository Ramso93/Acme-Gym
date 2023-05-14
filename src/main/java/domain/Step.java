
package domain;

import java.net.URL;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
// import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Step extends DomainEntity {

	//constructor

	//atributos
	private URL	description;
	private URL	tutorial;


	//@URL
	public URL getDescription() {
		return this.description;
	}
	public void setDescription(final URL description) {
		this.description = description;
	}

	public URL getTutorial() {
		return this.tutorial;
	}
	public void setTutorial(final URL tutorial) {
		this.tutorial = tutorial;
	}


	//relacion
	private Workout workout;


	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Workout getWorkout() {
		return this.workout;
	}
	public void setWorkout(final Workout workout) {
		this.workout = workout;
	}
}
