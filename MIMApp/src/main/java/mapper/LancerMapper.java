package mapper;

import dto.LancerDTO;
import entity.Lancer;

public class LancerMapper {

    public static LancerDTO toLancerDTO(Lancer lancer) {
        if (lancer == null) {
            return null;
        }
        LancerDTO lancerDTO = new LancerDTO(
        lancer.getUserId(),
        lancer.getInstanceTraitement().getTraitement().getNomTraitement(),
        lancer.getInstanceTraitement().getTraitement().getSensFlux(),
        lancer.getModeLancement(),
        lancer.getDateDebutLancement(),
        lancer.getDateFinLancement(),
        lancer.getEtatLancement()
    );
        System.out.println( lancerDTO.getUserId());
        return lancerDTO;
        
        
    }
}
