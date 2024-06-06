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
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_instance_traitement", insertable = false, updatable = false)
    private InstanceTraitement instanceTraitement;

    @Column(name = "date_debut_lancement")
    private Date dateDebutLancement;

    @Column(name = "date_fin_lancement")
    private Date dateFinLancement;

    @Column(name = "mode_lancement")
    private String modeLancement;

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

    public String getModeLancement() {
        return modeLancement;
    }

    public void setModeLancement(String modeLancement) {
        this.modeLancement = modeLancement;
    }

    public String getEtatLancement() {
        return etatLancement;
    }

    public void setEtatLancement(String etatLancement) {
        this.etatLancement = etatLancement;
    }
}