package mapper;

import dto.utilisateurDTO;
import entity.utilisateur;

public class utilisateurMapper {
	
	public static utilisateurDTO mapToUtilisateurDTO(utilisateur user) {
		return new utilisateurDTO(
				user.getIdUser(),
				user.getNom(),
				user.getPrenom(),
				user.getRole(),
				user.getEmail(),
				user.getTel()
				
		);
	}

}
