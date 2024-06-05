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

    public String getNomTraitement() {
        if (instanceTraitement != null && instanceTraitement.getTraitement() != null) {
            return instanceTraitement.getTraitement().getNomTraitement();
        }
        return null;
    }

    public String getSensFlux() {
        if (instanceTraitement != null && instanceTraitement.getTraitement() != null) {
            return instanceTraitement.getTraitement().getSensFlux();
        }
        return null;
    }

    public String getModeLancement() {
        if (instanceTraitement != null && instanceTraitement.getTraitement() != null) {
            return instanceTraitement.getTraitement().getModeLancement();
        }
        return null;
    }
}
