
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {

	@Query("select a.gym from Activity a where a.gym.active=false and a.id = ?1")
	Gym listGymByActivity(int activityId);
}
