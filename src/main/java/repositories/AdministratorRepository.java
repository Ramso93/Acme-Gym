
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	@Query("select min(m.gyms.size), avg(m.gyms.size), max(m.gyms.size), stddev(m.gyms.size) from Manager m")
	Collection<Object[]> findMinMaxAvgStdDevByManager();

}
