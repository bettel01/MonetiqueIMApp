package entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "traitement")
public class Traitement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_traitement")
    private Integer idTraitement;

    @Column(name = "nom_traitement", nullable = false)
    private String nomTraitement;

    @Column(name = "sens_flux")
    private String sensFlux;


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
}
