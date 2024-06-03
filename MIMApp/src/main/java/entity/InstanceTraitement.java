package entity;

import jakarta.persistence.*;


@Entity
@Table(name = "instance_traitement")
public class InstanceTraitement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instance_traitement")
    private Integer idInstanceTraitement;

    @ManyToOne
    @JoinColumn(name = "id_traitement")
    private Traitement traitement;

    // Getters and Setters

    public Integer getIdInstanceTraitement() {
        return idInstanceTraitement;
    }

    public void setIdInstanceTraitement(Integer idInstanceTraitement) {
        this.idInstanceTraitement = idInstanceTraitement;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }
}
