
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {

	//@JoinColumn(name = "accounts_entity_id")
	// Constructors -----------------------------------------------------------
	/*
	 * public Administrator() {
	 * super();
	 * }
	 */

	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------
}
