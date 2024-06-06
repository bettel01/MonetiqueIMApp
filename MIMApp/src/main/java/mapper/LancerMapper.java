package mapper;

import dto.LancerDTO;
import entity.Lancer;

public class LancerMapper {

    public static LancerDTO toLancerDTO(Lancer lancer) {
        if (lancer == null) {
            return null;
        }
        LancerDTO lancerDTO = new LancerDTO(

                lancer.getInstanceTraitementId(),
                lancer.getInstanceTraitement().getTraitement().getNomTraitement(),
                lancer.getInstanceTraitement().getTraitement().getSensFlux(),
                lancer.getInstanceTraitement().getTraitement().getModeLancement(),
                lancer.getDateDebutLancement(),
                lancer.getDateFinLancement(),
                lancer.getEtatLancement()
    );


        return lancerDTO;
        
        
    }
}
