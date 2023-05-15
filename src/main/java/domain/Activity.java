
package domain;

import java.net.URL;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
/*
 * @Table(indexes = {
 *
 * @Index(columnList = "cancel"), @Index(columnList = "gym_id"), @Index(columnList = "title"), @Index(columnList = "description"), @Index(columnList = "dayWeek"), @Index(columnList = "endTime")
 * })
 */
public class Activity extends DomainEntity {

	//constructor
	public Activity() {
		super();
	}


	//atributos
	private String		title;
	private URL			pictures;
	private String		description;
	private daysEnum	dayWeek;
	//private Date		startTime;
	//private Date		endTime;
	private String		startTime;
	private String		endTime;
	private int			seatsAvailable;
	private boolean		cancel;


	@NotBlank
	public String getTitle() {
		return this.title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}

	public URL getPictures() {
		return this.pictures;
	}
	public void setPictures(final URL pictures) {
		this.pictures = pictures;
	}
	@NotBlank
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	public daysEnum getDayWeek() {
		return this.dayWeek;
	}
	public void setDayWeek(final daysEnum dayWeek) {
		this.dayWeek = dayWeek;
	}

	@Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
	public String getStartTime() {
		return this.startTime;
	}
	public void setStartTime(final String startTime) {
		this.startTime = startTime;
	}

	@Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(final String endTime) {
		this.endTime = endTime;
	}
	@NotNull
	@Min(1)
	public int getSeatsAvailable() {
		return this.seatsAvailable;
	}

	public void setSeatsAvailable(final int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public boolean isCancel() {
		return this.cancel;
	}
	public void setCancel(final boolean cancel) {
		this.cancel = cancel;
	}


	//relacion
	private Collection<Trainer>		trainers;
	private Collection<Customer>	customers;
	private Gym						gym;
	private Collection<Annotation>	annotations;


	@ManyToMany
	public Collection<Trainer> getTrainers() {
		return this.trainers;
	}
	public void setTrainers(final Collection<Trainer> trainers) {
		this.trainers = trainers;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Gym getGym() {
		return this.gym;
	}
	public void setGym(final Gym gym) {
		this.gym = gym;
	}

	@ManyToMany
	public Collection<Customer> getCustomers() {
		return this.customers;
	}
	public void setCustomers(final Collection<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(mappedBy = "activity")
	public Collection<Annotation> getAnnotations() {
		return this.annotations;
	}
	public void setAnnotations(final Collection<Annotation> annotations) {
		this.annotations = annotations;
	}

}
