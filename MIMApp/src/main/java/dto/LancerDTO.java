package dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class LancerDTO {

   // private Integer userId;
	private Integer instanceTraitementId;
    private String nomTraitement;
    private String sensFlux;
    private String modeLancement;
    private Date dateDebutLancement;
    private Date dateFinLancement;
    private String etatLancement;


	public Integer getInstanceTraitementId() {
		return instanceTraitementId;
	}

	public void setInstanceTraitementId(Integer instanceTraitementId) {
		this.instanceTraitementId = instanceTraitementId;
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



	public LancerDTO(Integer instanceTraitementId, String nomTraitement, String sensFlux, String modeLancement, Date dateDebutLancement, Date dateFinLancement, String etatLancement) {
        this.instanceTraitementId = instanceTraitementId;
		this.nomTraitement = nomTraitement;
        this.sensFlux = sensFlux;
        this.modeLancement = modeLancement;
        this.dateDebutLancement = dateDebutLancement;
        this.dateFinLancement = dateFinLancement;
        this.etatLancement = etatLancement;
    }

	@Override
	public String toString() {
		return "LancerDTO{" +
				"nomTraitement='" + nomTraitement + '\'' +
				", sensFlux='" + sensFlux + '\'' +
				", modeLancement='" + modeLancement + '\'' +
				", dateDebutLancement=" + dateDebutLancement +
				", dateFinLancement=" + dateFinLancement +
				", etatLancement='" + etatLancement + '\'' +
				'}';
	}



}
