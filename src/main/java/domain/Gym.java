
package domain;

import java.net.URL;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Gym extends DomainEntity {

	//constructor
	public Gym() {
		super();
	}


	//atributos
	private URL		logo;
	private String	name;
	private String	address;
	private float	fee;
	private boolean	active;


	public URL getLogo() {
		return this.logo;
	}

	public void setLogo(final URL logo) {
		this.logo = logo;
	}
	@NotBlank
	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	@NotBlank
	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}
	@NotNull
	@Min(0)
	public float getFee() {
		return this.fee;
	}

	public void setFee(final float fee) {
		this.fee = fee;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}


	// relation

	private Manager manager;


	@ManyToOne(optional = false)
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(final Manager manager) {
		this.manager = manager;
	}
}
