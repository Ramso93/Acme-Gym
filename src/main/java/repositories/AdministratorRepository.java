
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	//@Query("select ua from Administrator ua where ua.useraccount_id = ?1")
	@Query("select ua from Administrator ua where ua.id = ?1")
	Administrator findByID(int actorId);

	/*
	 * @Query("select a.userAccount from Actor a where a.id = ?1")
	 * UserAccount findByActorId(int actorId);
	 */
}
