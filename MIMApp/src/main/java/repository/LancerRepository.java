package repository;

import entity.Lancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancerRepository extends JpaRepository<Lancer, Integer> {
	
}
