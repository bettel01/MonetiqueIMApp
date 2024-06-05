package entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "instance_interface")
public class InstanceInterface {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instance_interface")
    private Integer idInstanceInterface;

    @ManyToOne
    @JoinColumn(name = "id_interface")
    private InterfaceT interfaceName;

    @ManyToOne
    @JoinColumn(name = "id_instance_traitement")
    private InstanceTraitement instanceTraitement;

    @Column(name = "ordre_lancement")
    private Integer ordreLancement;

    @Column(name="date_debut_lancement")
    private Date dateDebutLancement;

    @Column(name="date_fin_lancement")
    private Date dateFinLancement;
    
    @Column(name = "etat_lancement")
    private String etatLancement;

    

    public Integer getIdInstanceInterface() {
        return idInstanceInterface;
    }

    public void setIdInstanceInterface(Integer idInstanceInterface) {
        this.idInstanceInterface = idInstanceInterface;
    }
    public InstanceTraitement getInstanceTraitement() {
        return instanceTraitement;
    }

    public void setInstanceTraitement(InstanceTraitement instanceTraitement) {
        this.instanceTraitement = instanceTraitement;
    }

    public InterfaceT getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(InterfaceT interfaceName) {
        this.interfaceName = interfaceName;
    }



    public Integer getOrdreLancement() {
        return ordreLancement;
    }

    public void setOrdreLancement(Integer ordreLancement) {
        this.ordreLancement = ordreLancement;
    }

    public Date getDateDebutLancement() {
        return dateDebutLancement;
    }

    public void setDateDebutLancement(Date dateDebutLancement) {
        this.dateDebutLancement = dateDebutLancement;
    }

    public Date getDateFinLancement() {
        return dateFinLancement;
    }

    public void setDateFinLancement(Date dateFinLancement) {
        this.dateFinLancement = dateFinLancement;
    }

    public String getEtatLancement() {
        return etatLancement;
    }

    public void setEtatLancement(String etatLancement) {
        this.etatLancement = etatLancement;
    }
}
