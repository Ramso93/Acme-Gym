
package domain;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Annotation extends DomainEntity {

	//constructor

	//atributos
	private Date	date;
	private String	text;
	//@Optional
	private int		rating;


	//@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getDate() {
		return this.date;
	}
	public void setDate(final Date date) {
		this.date = date;
	}
	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}
	@Range(min = 0, max = 3)
	public int getRating() {
		return this.rating;
	}
	public void setRating(final int rating) {
		this.rating = rating;
	}


	//relaciones
	private Actor		actor;
	private Gym			gym;
	private Activity	activity;
	private Workout		workout;


	@Valid
	@ManyToOne(optional = false)
	public Actor getActor() {
		return this.actor;
	}
	public void setActor(final Actor actor) {
		this.actor = actor;
	}

	@Valid
	@ManyToOne(optional = false)
	public Gym getGym() {
		return this.gym;
	}
	public void setGym(final Gym gym) {
		this.gym = gym;
	}

	@Valid
	@ManyToOne(optional = false)
	public Activity getActivity() {
		return this.activity;
	}
	public void setActivity(final Activity activity) {
		this.activity = activity;
	}

	@Valid
	@ManyToOne(optional = false)
	public Workout getWorkout() {
		return this.workout;
	}
	public void setWorkout(final Workout workout) {
		this.workout = workout;
	}

}
