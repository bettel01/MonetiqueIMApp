package service;

import dto.InterfaceDTO;
import entity.InterfaceT;
import entity.Traitement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.InterfaceRepository;
import repository.TraitementRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterfaceService {

	private final InterfaceRepository interfaceRepository;
	private final TraitementRepository traitementRepository;

	public List<InterfaceT> getAllInterfaces() {
		return interfaceRepository.findAll();
	}

	public InterfaceT getInterfaceById(Integer id) {
		Optional<InterfaceT> interfaceOptional = interfaceRepository.findById(id);
		return interfaceOptional.orElse(null);
	}

	public InterfaceT createInterface(InterfaceDTO interfaceDTO) {
		InterfaceT interfaceT = convertToEntity(interfaceDTO);
		return interfaceRepository.save(interfaceT);
	}

	public InterfaceT updateInterface(Integer id, InterfaceDTO interfaceDTO) {
		InterfaceT existingInterface = getInterfaceById(id);
		if (existingInterface != null) {
			existingInterface.setNomInterface(interfaceDTO.getNomInterface());
			existingInterface.setOrdreLancement(interfaceDTO.getOrdreLancement());
			if (interfaceDTO.getTraitementId() != null) {
				Optional<Traitement> traitementOptional = traitementRepository.findById(interfaceDTO.getTraitementId());
				traitementOptional.ifPresent(existingInterface::setTraitement);
			}
			return interfaceRepository.save(existingInterface);
		}
		return null;
	}

	public void deleteInterface(Integer id) {
		interfaceRepository.deleteById(id);
	}

	private InterfaceT convertToEntity(InterfaceDTO interfaceDTO) {
		InterfaceT interfaceT = new InterfaceT();
		interfaceT.setNomInterface(interfaceDTO.getNomInterface());
		interfaceT.setOrdreLancement(interfaceDTO.getOrdreLancement());
		if (interfaceDTO.getTraitementId() != null) {
			Optional<Traitement> traitementOptional = traitementRepository.findById(interfaceDTO.getTraitementId());
			traitementOptional.ifPresent(interfaceT::setTraitement);
		}
		return interfaceT;
	}
}
