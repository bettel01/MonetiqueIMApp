package service;

import dto.TraitementDTO;
import entity.InterfaceT;
import entity.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InterfaceRepository;
import repository.TraitementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraitementService {

    @Autowired
    private TraitementRepository traitementRepository;

    @Autowired
    private InterfaceRepository interfaceRepository;

    public List<TraitementDTO> getAllTraitementsWithInterfaces() {
        List<Traitement> traitements = traitementRepository.findAll();
        return traitements.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private TraitementDTO convertToDto(Traitement traitement) {
        TraitementDTO traitementDTO = new TraitementDTO();
        traitementDTO.setIdTraitement(traitement.getIdTraitement());
        traitementDTO.setNomTraitement(traitement.getNomTraitement());
        traitementDTO.setSensFlux(traitement.getSensFlux());
        traitementDTO.setModeLancement(traitement.getModeLancement());

        List<String> interfaceNames = interfaceRepository.findByTraitement(traitement)
                .stream()
                .map(InterfaceT::getNomInterface)
                .collect(Collectors.toList());
        traitementDTO.setInterfaceNames(interfaceNames);

        List<Integer> interfaceIds = interfaceRepository.findByTraitement(traitement)
                .stream()
                .map(InterfaceT::getIdInterface)
                .collect(Collectors.toList());
        traitementDTO.setInterfaceIds(interfaceIds);

        return traitementDTO;
    }
}
