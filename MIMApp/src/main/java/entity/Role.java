package entity;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    EXECUTOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }



}
