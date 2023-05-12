
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	//@Query("select ua from Administrator ua where ua.id = ?1")
	//Administrator findAllManagers(int actorId);

}
