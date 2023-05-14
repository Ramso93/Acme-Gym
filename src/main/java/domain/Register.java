
package domain;

import java.sql.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Register extends DomainEntity {

	//constructor
	public Register() {
		super();
	}


	//atributos
	private Date	fechaInicio;
	private Date	fechaFin;
	private float	fee;


	public Date getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	@NotNull
	@Min(0)
	public float getFee() {
		return this.fee;
	}
	public void setFee(final float fee) {
		this.fee = fee;
	}


	//relaciones
	private Customer	customer;
	private Gym			gym;


	// Relación muchos a uno con Customer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// Relación muchos a uno opcional con Gym
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gym_id")
	public Gym getGym() {
		return this.gym;
	}
	public void setGym(final Gym gym) {
		this.gym = gym;
	}
}
