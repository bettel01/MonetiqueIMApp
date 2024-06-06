

package entity;



import com.bcp.monitoring.MIMApp.config.SimpleGrantedAuthorityImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Utilisateur")

public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter

	private Integer idUser;
	private String firstname;
	private String lastname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;

	private Integer tel;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@JsonSerialize(contentAs = SimpleGrantedAuthorityImpl.class)
	@JsonDeserialize(contentAs = SimpleGrantedAuthorityImpl.class)
	private List<GrantedAuthority> authorities;

	// Other fields, constructors, getters, and setters

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}





	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}





	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
