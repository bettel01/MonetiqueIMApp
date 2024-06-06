package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LancerRepository;
import java.util.List;
import entity.Lancer;

@Service
public class LancerService {

	@Autowired
    private LancerRepository lancerRepository;

    public List<Lancer> getAllLancers() {
        return lancerRepository.findAll();
    }
}
