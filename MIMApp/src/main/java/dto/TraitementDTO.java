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

	private Integer id;
    private String nomTraitement;
    private String sensFlux;
    private String modeDeLancement;
    private String etat;
    private String dateDebut;
    private String dateFin;
    private List<InstanceInterfaceDTO> instanceInterfaces;
}
