package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstanceTraitementDTO {
    private Integer id;
    private String nomInstance;
    private String etat;
    private String dateDebut;
    private String dateFin;
    private TraitementDTO traitement;
    private List<InstanceInterfaceDTO> instanceInterfaces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomInstance() {
        return nomInstance;
    }

    public void setNomInstance(String nomInstance) {
        this.nomInstance = nomInstance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public TraitementDTO getTraitement() {
        return traitement;
    }

    public void setTraitement(TraitementDTO traitement) {
        this.traitement = traitement;
    }

    public List<InstanceInterfaceDTO> getInstanceInterfaces() {
        return instanceInterfaces;
    }

    public void setInstanceInterfaces(List<InstanceInterfaceDTO> instanceInterfaces) {
        this.instanceInterfaces = instanceInterfaces;
    }
}
