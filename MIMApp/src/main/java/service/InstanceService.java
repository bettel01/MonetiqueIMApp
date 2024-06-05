package service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InstanceInterfaceRepository;
import repository.InstanceTraitementRepository;
import repository.LancerRepository;
import repository.UtilisateurRepository;
import repository.TraitementRepository;
import entity.InstanceTraitement;
import entity.Traitement;
import entity.InterfaceT;
import entity.InstanceInterface;
import entity.Lancer;
import entity.Utilisateur;

@Service
public class InstanceService {

    @Autowired
    private InstanceTraitementRepository instanceTraitementRepository;

    @Autowired
    private InstanceInterfaceRepository instanceInterfaceRepository;

    @Autowired
    private TraitementRepository traitementRepository;

    @Autowired
    private LancerRepository lancerRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository; // Ajoutez ce repository



    public InstanceTraitement createInstanceTraitement(Integer traitementId) {
        Traitement traitement = traitementRepository.findById(traitementId)
                .orElseThrow(() -> new RuntimeException("Traitement not found"));

        InstanceTraitement instanceTraitement = new InstanceTraitement();
        instanceTraitement.setTraitement(traitement);
        return instanceTraitementRepository.save(instanceTraitement);
    }

    public void createInstanceInterfaces(List<Integer> interfaceIds, Integer instanceTraitementId) {
        InstanceTraitement instanceTraitement = instanceTraitementRepository.findById(instanceTraitementId)
                .orElseThrow(() -> new RuntimeException("InstanceTraitement not found"));

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime lastEndTime = currentDateTime;

        for (int i = 0; i < interfaceIds.size(); i++) {
            Integer interfaceId = interfaceIds.get(i);
            InterfaceT interfaceT = new InterfaceT();
            interfaceT.setIdInterface(interfaceId);

            InstanceInterface instanceInterface = new InstanceInterface();
            instanceInterface.setInterfaceName(interfaceT);
            instanceInterface.setInstanceTraitement(instanceTraitement);

            // Set ordreLancement, dateDebutLancement, dateFinLancement, etatLancement
            instanceInterface.setOrdreLancement(i + 1); // Starting from 1
            instanceInterface.setDateDebutLancement(Date.from(lastEndTime.atZone(ZoneId.systemDefault()).toInstant()));
            lastEndTime = lastEndTime.plusMinutes(5); // Increment the end time by 5 minutes
            instanceInterface.setDateFinLancement(Date.from(lastEndTime.atZone(ZoneId.systemDefault()).toInstant()));
            instanceInterface.setEtatLancement("réussi");

            instanceInterfaceRepository.save(instanceInterface);
        }
    }

    public void createLancer(Integer instanceTraitementId, String nomTraitement, String sensFlux, String modeLancement, LocalDateTime dateDebutLancement, LocalDateTime dateFinLancement) {
        InstanceTraitement instanceTraitement = instanceTraitementRepository.findById(instanceTraitementId)
                .orElseThrow(() -> new RuntimeException("InstanceTraitement not found"));

        Utilisateur utilisateur = utilisateurRepository.findById(1) // Assurez-vous de fournir un ID valide
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        Lancer lancer = new Lancer();
        lancer.setInstanceTraitement(instanceTraitement);
        lancer.setUtilisateur(utilisateur); // Associez l'utilisateur
        lancer.setNomTraitement(nomTraitement);
        lancer.setSensFlux(sensFlux);
        lancer.setModeLancement(modeLancement);
        lancer.setDateDebutLancement(Date.from(dateDebutLancement.atZone(ZoneId.systemDefault()).toInstant()));

        // Fetch the last created InstanceInterface for the given InstanceTraitement
        InstanceInterface lastInstanceInterface = instanceInterfaceRepository.findTopByInstanceTraitementOrderByDateFinLancementDesc(instanceTraitement);
        if (lastInstanceInterface != null) {
            lancer.setDateFinLancement(lastInstanceInterface.getDateFinLancement());
        } else {
            lancer.setDateFinLancement(Date.from(dateFinLancement.atZone(ZoneId.systemDefault()).toInstant()));
        }

        lancer.setEtatLancement("réussi");

        lancerRepository.save(lancer); // Enregistrez l'instance de Lancer
    }

}
