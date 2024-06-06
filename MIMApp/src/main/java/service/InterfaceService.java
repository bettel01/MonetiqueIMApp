package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InterfaceRepository;
import java.util.List;
import java.util.Optional;

import entity.InterfaceT;

@Service
public class InterfaceService {

	 @Autowired
	    private InterfaceRepository interfaceRepository;

	    public List<InterfaceT> getAllInterfaces() {
	        return interfaceRepository.findAll();
	    }
	    
	    public InterfaceT getInterfaceById(Integer id) {
	        Optional<InterfaceT> interfaceOptional = interfaceRepository.findById(id);
	        return interfaceOptional.orElse(null);
	    }
}
