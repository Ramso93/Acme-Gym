
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Curriculum extends DomainEntity {

	//constructor

	//atributos
	private String	fullName;
	private String	education;
	private String	experience;
	private String	speciality;


	@NotBlank
	public String getFullName() {
		return this.fullName;
	}
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}
	@NotBlank
	public String getEducation() {
		return this.education;
	}
	public void setEducation(final String education) {
		this.education = education;
	}
	@NotBlank
	public String getExperience() {
		return this.experience;
	}
	public void setExperience(final String experience) {
		this.experience = experience;
	}
	@NotBlank
	public String getSpeciality() {
		return this.speciality;
	}
	public void setSpeciality(final String speciality) {
		this.speciality = speciality;
	}

	//relacion


	//se omite esta parte porque un Trainer puede no tener un cv
	/*
	 * private Customer customer;
	 *
	 *
	 * @OneToOne(fetch = FetchType.LAZY)
	 *
	 * @JoinColumn(name = "customer_id")
	 * public Customer getCustomer() {
	 * return this.customer;
	 * }
	 * public void setCustomer(final Customer customer) {
	 * this.customer = customer;
	 * }
	 */
	private SocialIndetity socialidentity;


	@OneToOne(optional = true)
	public SocialIndetity getSocialidentity() {
		return this.socialidentity;
	}
	public void setSocialidentity(final SocialIndetity socialidentity) {
		this.socialidentity = socialidentity;
	}

}
