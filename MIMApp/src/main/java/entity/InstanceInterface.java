package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instance_interface")
public class InstanceInterface {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instance_interface")
    private Integer idInstanceInterface;

    @ManyToOne
    @JoinColumn(name = "id_interface")
    private InterfaceT interfaceEntity;

    @ManyToOne
    @JoinColumn(name = "id_instance_traitement")
    private InstanceTraitement instanceTraitement;

    @Column(name = "ordre_lancement")
    private Integer ordreLancement;
    
    @Column(name = "etat_lancement")
    private String etatLancement;

    

    public Integer getIdInstanceInterface() {
        return idInstanceInterface;
    }

    public void setIdInstanceInterface(Integer idInstanceInterface) {
        this.idInstanceInterface = idInstanceInterface;
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

    public Integer getOrdreLancement() {
        return ordreLancement;
    }

    public void setOrdreLancement(Integer ordreLancement) {
        this.ordreLancement = ordreLancement;
    }
    
    public String getEtatLancement() {
        return etatLancement;
    }

    public void setEtatLancement(String etatLancement) {
        this.etatLancement = etatLancement;
    }
}
