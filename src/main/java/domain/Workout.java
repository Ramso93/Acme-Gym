
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Table(indexes = {
	@Index(columnList = "gym_id"), @Index(columnList = "title"), @Index(columnList = "description")
})
public class Workout extends DomainEntity {

	//constructor

	//atributos
	private String	title;
	private String	description;


	@NotBlank
	public String getTitle() {
		return this.title;
	}
	public void setTitle(final String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	//relacion
	private Collection<Step>		steps;
	private Gym						gym;
	private Collection<Annotation>	annotations;
	
	@OneToMany(mappedBy = "workout")
	public Collection<Step> getSteps() {
		return steps;
	}
	public void setSteps(Collection<Step> steps) {
		this.steps = steps;
	}

	@Valid
	@ManyToOne(optional = false)
	public Gym getGym() {
		return gym;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}

	@OneToMany(mappedBy = "workout")
	public Collection<Annotation> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Collection<Annotation> annotations) {
		this.annotations = annotations;
	}
}
