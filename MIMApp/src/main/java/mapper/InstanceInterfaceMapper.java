package mapper;

import dto.InstanceInterfaceDTO;
import entity.InstanceInterface;

public class InstanceInterfaceMapper {

    public static InstanceInterfaceDTO toInstanceInterfaceDTO(InstanceInterface instanceInterface) {
        return new InstanceInterfaceDTO(
            instanceInterface.getIdInstanceInterface(),
            instanceInterface.getEtatLancement(),
            instanceInterface.getOrdreLancement(), 
            instanceInterface.getInterfaceEntity(),
            instanceInterface.getInstanceTraitement()
        );
    }
}
