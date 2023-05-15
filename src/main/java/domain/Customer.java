
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor {

	//constructor
	/*
	 * public Customer() {
	 * super();
	 * }
	 */

	//atributos
	private String	holderName;
	private String	brandName;
	private int		number;
	private int		expirationMonth;
	private int		expirationYear;
	private int		cvv;


	@NotBlank
	public String getHolderName() {
		return this.holderName;
	}
	public void setHolderName(final String holderName) {
		this.holderName = holderName;
	}
	@NotBlank
	public String getBrandName() {
		return this.brandName;
	}
	public void setBrandName(final String brandName) {
		this.brandName = brandName;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}
	@Range(min = 1, max = 12)
	public int getExpirationMonth() {
		return this.expirationMonth;
	}
	public void setExpirationMonth(final int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	@Min(2023)
	public int getExpirationYear() {
		return this.expirationYear;
	}
	public void setExpirationYear(final int expirationYear) {
		this.expirationYear = expirationYear;
	}
	@Range(min = 100, max = 999)
	public int getCvv() {
		return this.cvv;
	}
	public void setCvv(final int cvv) {
		this.cvv = cvv;
	}


	//relacion
	private Collection<Gym>			gyms;
	private Collection<Activity>	activities;


	// Relación uno a muchos con register
	//@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	@ManyToMany
	public Collection<Gym> getGyms() {
		return this.gyms;
	}
	public void setGyms(final Collection<Gym> gyms) {
		this.gyms = gyms;
	}
	@ManyToMany
	public Collection<Activity> getActivities() {
		return this.activities;
	}
	public void setActivities(final Collection<Activity> activities) {
		this.activities = activities;
	}

}
