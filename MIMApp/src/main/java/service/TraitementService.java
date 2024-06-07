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

    public TraitementDTO addTraitement(TraitementDTO traitementDTO) {
        Traitement traitement = convertToEntity(traitementDTO);
        Traitement savedTraitement = traitementRepository.save(traitement);
        return convertToDto(savedTraitement);
    }

    public TraitementDTO updateTraitement(Integer id, TraitementDTO traitementDTO) {
        Traitement existingTraitement = traitementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Traitement not found with id: " + id));

        existingTraitement.setNomTraitement(traitementDTO.getNomTraitement());
        existingTraitement.setSensFlux(traitementDTO.getSensFlux());
        existingTraitement.setModeLancement(traitementDTO.getModeLancement());

        Traitement updatedTraitement = traitementRepository.save(existingTraitement);
        return convertToDto(updatedTraitement);
    }

    public void deleteTraitement(Integer id) {
        Traitement traitement = traitementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Traitement not found with id: " + id));
        traitementRepository.delete(traitement);
    }

    private Traitement convertToEntity(TraitementDTO traitementDTO) {
        Traitement traitement = new Traitement();
        traitement.setNomTraitement(traitementDTO.getNomTraitement());
        traitement.setSensFlux(traitementDTO.getSensFlux());
        traitement.setModeLancement(traitementDTO.getModeLancement());
        // Autres attributs à initialiser si nécessaire
        return traitement;
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
