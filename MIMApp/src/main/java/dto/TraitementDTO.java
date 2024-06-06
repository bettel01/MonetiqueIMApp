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
public class TraitementDTO {


	private Integer idTraitement;
    private String nomTraitement;
    private String sensFlux;
    private String modeLancement;
    private List<String> interfaceNames;
    private List<Integer> interfaceIds;


    public Integer getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(Integer idTraitement) {
        this.idTraitement = idTraitement;
    }

    public String getNomTraitement() {
        return nomTraitement;
    }

    public void setNomTraitement(String nomTraitement) {
        this.nomTraitement = nomTraitement;
    }

    public String getSensFlux() {
        return sensFlux;
    }

    public void setSensFlux(String sensFlux) {
        this.sensFlux = sensFlux;
    }

    public String getModeLancement() {
        return modeLancement;
    }

    public void setModeLancement(String modeLancement) {
        this.modeLancement = modeLancement;
    }

    public List<String> getInterfaceNames() {
        return interfaceNames;
    }

    public void setInterfaceNames(List<String> interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public List<Integer> getInterfaceIds() {
        return interfaceIds;
    }

    public void setInterfaceIds(List<Integer> interfaceIds) {
        this.interfaceIds = interfaceIds;
    }
}


