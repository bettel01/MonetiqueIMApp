package dto;

import entity.InstanceTraitement;
import entity.InterfaceT;

public class InstanceInterfaceDTO {

    private Integer idInstanceInterface;
    private String etat;
    private Integer ordre;
    private InterfaceT interfaceEntity;
    private InstanceTraitement instanceTraitement;


    public InstanceInterfaceDTO(Integer idInstanceInterface, String etat, Integer ordre, InterfaceT interfaceEntity, InstanceTraitement instanceTraitement) {
        this.idInstanceInterface = idInstanceInterface;
        this.etat = etat;
        this.ordre = ordre;
        this.interfaceEntity = interfaceEntity;
        this.instanceTraitement = instanceTraitement;
    }

    // Getters et Setters
    public Integer getIdInstanceInterface() {
        return idInstanceInterface;
    }

    public void setIdInstanceInterface(Integer idInstanceInterface) {
        this.idInstanceInterface = idInstanceInterface;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public InterfaceT getInterfaceEntity() {
        return interfaceEntity;
    }

    public void setInterfaceEntity(InterfaceT interfaceEntity) {
        this.interfaceEntity = interfaceEntity;
    }

    public InstanceTraitement getInstanceTraitement() {
        return instanceTraitement;
    }

    public void setInstanceTraitement(InstanceTraitement instanceTraitement) {
        this.instanceTraitement = instanceTraitement;
    }
}
