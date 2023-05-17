
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
