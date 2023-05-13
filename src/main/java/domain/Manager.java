
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Manager extends Actor {

	//atributos
	private boolean baneado;


	public boolean isBaneado() {
		return this.baneado;
	}
	public void setBaneado(final boolean baneado) {
		this.baneado = baneado;
	}


	//Relationships
	@OneToMany(mappedBy = "manager")
	private Collection<Gym> gyms;


	public Collection<Gym> getGyms() {
		return this.gyms;
	}
	public void setGyms(final Collection<Gym> gyms) {
		this.gyms = gyms;
	}
}
