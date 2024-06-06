package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InstanceInterfaceRepository;
import java.util.List;
import java.util.Optional;

import entity.InstanceInterface;

@Service
public class InstanceInterfaceService {
	
	@Autowired
    private InstanceInterfaceRepository instanceInterfaceRepository;

    public List<InstanceInterface> getAllInstanceInterfaces() {
        return instanceInterfaceRepository.findAll();
    }

    public InstanceInterface getInstanceInterfaceById(Integer id) {
        Optional<InstanceInterface> instanceInterfaceOptional = instanceInterfaceRepository.findById(id);
        return instanceInterfaceOptional.orElse(null);
    }
}
