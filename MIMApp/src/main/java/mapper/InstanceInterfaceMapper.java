package mapper;

import dto.InstanceInterfaceDTO;
import entity.InstanceInterface;

public class InstanceInterfaceMapper {

    public static InstanceInterfaceDTO toInstanceInterfaceDTO(InstanceInterface instanceInterface) {
        return new InstanceInterfaceDTO(

                instanceInterface.getInstanceTraitement().getIdInstanceTraitement(),
                instanceInterface.getInterfaceName().getNomInterface(),
                instanceInterface.getOrdreLancement(),
                instanceInterface.getDateDebutLancement(),
                instanceInterface.getDateFinLancement(),
                instanceInterface.getEtatLancement()

        );
    }
}
