package entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lancer")
@IdClass(LancerId.class)
public class Lancer {

    @Id
    @Column(name = "id_user")
    private Integer userId;

    @Id
    @Column(name = "id_instance_traitement")
    private Integer instanceTraitementId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("instanceTraitementId")
    @JoinColumn(name = "id_instance_traitement", insertable = false, updatable = false)
    private InstanceTraitement instanceTraitement;

    @Column(name = "date_debut_lancement")
    private Date dateDebutLancement;

    @Column(name = "date_fin_lancement")
    private Date dateFinLancement;

    @Column(name = "etat_lancement")
    private String etatLancement;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInstanceTraitementId() {
        return instanceTraitementId;
    }

    public void setInstanceTraitementId(Integer instanceTraitementId) {
        this.instanceTraitementId = instanceTraitementId;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public InstanceTraitement getInstanceTraitement() {
        return instanceTraitement;
    }

    public void setInstanceTraitement(InstanceTraitement instanceTraitement) {
        this.instanceTraitement = instanceTraitement;
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
    public void setNomTraitement(String nomTraitement) {
        if (this.instanceTraitement != null) {
            this.instanceTraitement.getTraitement().setNomTraitement(nomTraitement);
        }
    }

    public void setSensFlux(String sensFlux) {
        if (this.instanceTraitement != null) {
            this.instanceTraitement.getTraitement().setSensFlux(sensFlux);
        }
    }

    public void setModeLancement(String modeLancement) {
        if (this.instanceTraitement != null) {
            this.instanceTraitement.getTraitement().setModeLancement(modeLancement);
        }
    }
}