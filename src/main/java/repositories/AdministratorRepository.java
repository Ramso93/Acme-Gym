
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;
import domain.Customer;
import domain.Gym;
import domain.Workout;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	//estadisticas
	@Query("select min(m.gyms.size), avg(m.gyms.size), max(m.gyms.size), stddev(m.gyms.size) from Manager m")
	Collection<Object[]> findMinMaxAvgStdDevByManager();

	@Query("select min(c.gyms.size), avg(c.gyms.size), max(c.gyms.size), stddev(c.gyms.size) from Customer c")
	Collection<Object[]> findMinMaxAvgStdDevByCustomer();

	@Query("select min(g.customers.size),  avg(g.customers.size), max(g.customers.size), stddev(g.customers.size) from Gym g")
	Collection<Object[]> findMinMaxAvgStdDevByGym();

	@Query("select g1 from Gym g1 where (select count(a1) from Gym g join g.activities a1 where a1.cancel=false and g1=g) >= All(select count(a2) from Gym g2 join g2.activities a2 where a2.cancel=false group by g2)")
	Collection<Gym> findGymMasActividades();

	@Query("select c1 from Customer c1 where (select count(a1) from Customer c join c.activities a1 where c1=c) >= All(select count(a2) from Customer c2 join c2.activities a2 group by c2)")
	Collection<Customer> findClientesMasActividades();

	@Query("select min(g.workouts.size), avg(g.workouts.size), max(g.workouts.size) from Gym g")
	Collection<Object[]> findMinAvgMaxEntrenamientos_Gym();

	@Query("select min(w.steps.size), avg(w.steps.size), max(w.steps.size) from Workout w")
	Collection<Object[]> findMinAvgMaxPasos_Entrenamiento();

	@Query("select w from Workout w order by w.steps.size DESC")
	Collection<Workout> findEntrenamientosOrdenDec_estrellas();
}
