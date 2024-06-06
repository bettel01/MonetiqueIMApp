package repository;


import entity.InterfaceT;
import entity.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceRepository extends JpaRepository<InterfaceT, Integer> {
    List<InterfaceT> findByTraitement(Traitement traitement);

}
