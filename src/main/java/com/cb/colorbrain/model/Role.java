package com.cb.colorbrain.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, LEADER;

    @Override
    public String getAuthority() {
        return name();
    }
}
