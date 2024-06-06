package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entity.InstanceInterface;
import java.util.List;

import entity.InstanceTraitement;
@Repository
public interface InstanceInterfaceRepository extends JpaRepository<InstanceInterface, Integer> {
    List<InstanceInterface> findByInstanceTraitement_IdInstanceTraitement(Integer instanceTraitementId);
    InstanceInterface findTopByInstanceTraitementOrderByDateFinLancementDesc(InstanceTraitement instanceTraitement);

}
