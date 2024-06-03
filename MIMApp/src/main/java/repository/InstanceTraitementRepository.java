package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.InstanceTraitement;

import java.util.List;

@Repository
public interface InstanceTraitementRepository extends JpaRepository<InstanceTraitement, Integer> {

    List<InstanceTraitement> findByTraitement_IdTraitement(Integer idTraitement);
}
