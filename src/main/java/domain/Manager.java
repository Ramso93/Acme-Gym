
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

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
}
