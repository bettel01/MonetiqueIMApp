package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interface")
public class InterfaceT {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interface")
    private Long idInterface;

    @Column(name = "nom_interface")
    private String nomInterface;
}
