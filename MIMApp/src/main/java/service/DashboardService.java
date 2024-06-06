package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto.DashboardDTO;
import dto.InstanceInterfaceDTO;
import dto.LancerDTO;
import entity.InstanceInterface;
import entity.InstanceTraitement;
import entity.Lancer;
import mapper.InstanceInterfaceMapper;
import mapper.LancerMapper;
import repository.InstanceInterfaceRepository;
import repository.InstanceTraitementRepository;
import repository.LancerRepository;

@Service
public class DashboardService {

    private final LancerRepository lancerRepository;
    private final InstanceTraitementRepository instanceTraitementRepository;
    private final InstanceInterfaceRepository instanceInterfaceRepository;
    
    @Autowired
    public DashboardService(
            LancerRepository lancerRepository,
            InstanceTraitementRepository instanceTraitementRepository,
            InstanceInterfaceRepository instanceInterfaceRepository) {
        this.lancerRepository = lancerRepository;
        this.instanceTraitementRepository = instanceTraitementRepository;
        this.instanceInterfaceRepository = instanceInterfaceRepository;
    }

    public DashboardDTO getDashboardData() {

        List<LancerDTO> lancers = lancerRepository.findAll().stream()
                                    .map(LancerMapper::toLancerDTO)
                                    .collect(Collectors.toList());

        return new DashboardDTO(lancers);
    }

    public List<InstanceInterfaceDTO> getInstanceInterfacesByTraitementId(Integer traitementId) {
       
        List<InstanceTraitement> instanceTraitements = instanceTraitementRepository.findByTraitement_IdTraitement(traitementId);

        List<InstanceInterfaceDTO> instanceInterfaceDTOs = new ArrayList<>();

        for (InstanceTraitement instanceTraitement : instanceTraitements) {
            List<InstanceInterface> instanceInterfaces = instanceInterfaceRepository.findByInstanceTraitement_IdInstanceTraitement(instanceTraitement.getIdInstanceTraitement());

            for (InstanceInterface instanceInterface : instanceInterfaces) {
                instanceInterfaceDTOs.add(InstanceInterfaceMapper.toInstanceInterfaceDTO(instanceInterface));
            }
        }

        return instanceInterfaceDTOs;
    }
}
