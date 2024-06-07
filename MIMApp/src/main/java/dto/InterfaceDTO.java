package dto;

import entity.Traitement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceDTO {
    private Integer id;
    private String nomInterface;
    private Integer ordreLancement;
    private Integer traitementId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomInterface() {
        return nomInterface;
    }

    public void setNomInterface(String nomInterface) {
        this.nomInterface = nomInterface;
    }

    public Integer getOrdreLancement() {
        return ordreLancement;
    }

    public void setOrdreLancement(Integer ordreLancement) {
        this.ordreLancement = ordreLancement;
    }

    public Integer getTraitementId() {
        return traitementId;
    }

    public void setTraitementId(Integer traitementId) {
        this.traitementId = traitementId;
    }
}
