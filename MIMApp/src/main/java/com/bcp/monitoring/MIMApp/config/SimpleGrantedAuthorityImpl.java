package com.bcp.monitoring.MIMApp.config;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Setter
public class SimpleGrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public SimpleGrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
