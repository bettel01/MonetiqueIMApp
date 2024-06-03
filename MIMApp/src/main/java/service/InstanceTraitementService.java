package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InstanceTraitementRepository;
import java.util.List;
import java.util.Optional;

import entity.InstanceTraitement;

@Service
public class InstanceTraitementService {

	@Autowired
    private InstanceTraitementRepository instanceTraitementRepository;

    public List<InstanceTraitement> getAllInstanceTraitements() {
        return instanceTraitementRepository.findAll();
    }
    
    public InstanceTraitement getInstanceTraitementById(Integer id) {
        Optional<InstanceTraitement> instanceTraitementOptional = instanceTraitementRepository.findById(id);
        return instanceTraitementOptional.orElse(null);
    }
}
