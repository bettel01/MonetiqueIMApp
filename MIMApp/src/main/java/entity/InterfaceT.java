package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interface")
public class InterfaceT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interface")
    private Integer idInterface;

    @Column(name = "nom_interface")
    private String nomInterface;

    @Column( name = "ordre_lancement")
    private Integer ordreLancement;

    @ManyToOne
    @JoinColumn(name = "id_traitement", nullable = false)
    private Traitement traitement;



    public Integer getIdInterface() {
        return idInterface;
    }

    public void setIdInterface(Integer idInterface) {
        this.idInterface = idInterface;
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

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }
}
