
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	@Query("SELECT g.manager.id as idGerente, COUNT(g.id) as cantidadGyms, MIN(COUNT(g.id)) as minimo, MAX(COUNT(g.id)) as maximo, AVG(COUNT(g.id)) as promedio, STDDEV(COUNT(g.id)) as desviacionEstandar FROM Gym g GROUP BY g.manager.id")
	Collection<Object[]> findMinMaxAvgStdDevByManager();

	/*
	 * SELECT MIN(monto) AS minimo, MAX(monto) AS maximo, STDEV(monto) AS desviacion_estandar
	 * FROM ventas;
	 *
	 * @Query()
	 */
	//@Query("select ua from Administrator ua where ua.useraccount_id = ?1")
	//@Query("select ua from Administrator ua where ua.id = ?1")
	//Administrator findByID(int actorId);

	/*
	 * @Query("select a.userAccount from Actor a where a.id = ?1")
	 * UserAccount findByActorId(int actorId);
	 */
}
