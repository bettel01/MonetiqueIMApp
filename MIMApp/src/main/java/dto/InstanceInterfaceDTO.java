package dto;


import java.util.Date;

public class InstanceInterfaceDTO {

    private Integer instanceTraitementId;
    private String interfaceName;
    private Integer ordre;
    private Date dateDebutLancement;
    private Date dateFinLancement;
    private String etat;

    public InstanceInterfaceDTO(Integer instanceTraitementId, String interfaceName, Integer ordre, Date dateDebutLancement, Date dateFinLancement, String etat) {
        this.instanceTraitementId = instanceTraitementId;
        this.interfaceName = interfaceName;
        this.ordre = ordre;
        this.dateDebutLancement = dateDebutLancement;
        this.dateFinLancement = dateFinLancement;
        this.etat = etat;
    }

    // Getters and Setters

    public Integer getInstanceTraitementId() {
        return instanceTraitementId;
    }

    public void setInstanceTraitementId(Integer instanceTraitementId) {
        this.instanceTraitementId = instanceTraitementId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }


    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;

    }
}
