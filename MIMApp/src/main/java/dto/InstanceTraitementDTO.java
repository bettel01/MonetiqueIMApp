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
public class InstanceTraitementDTO {
    private Integer id;
    private String nomInstance;
    private String etat;
    private String dateDebut;
    private String dateFin;
    private TraitementDTO traitement;
    private List<InstanceInterfaceDTO> instanceInterfaces;
}
