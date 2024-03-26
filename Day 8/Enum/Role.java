package com.java.agrofund.Enum;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.java.agrofund.Enum.Permission.ADMIN_CREATE;
import static com.java.agrofund.Enum.Permission.ADMIN_DELETE;
import static com.java.agrofund.Enum.Permission.ADMIN_READ;
import static com.java.agrofund.Enum.Permission.ADMIN_UPDATE;
import static com.java.agrofund.Enum.Permission.USER_CREATE;
import static com.java.agrofund.Enum.Permission.USER_DELETE;
import static com.java.agrofund.Enum.Permission.USER_READ;
import static com.java.agrofund.Enum.Permission.USER_UPDATE;

//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    admin(
        Set.of( 
            ADMIN_CREATE,
           ADMIN_UPDATE,
           ADMIN_DELETE,
           ADMIN_READ
            )),

            USER(
            Set.of(
            USER_READ,
            USER_UPDATE,
            USER_DELETE,
            USER_CREATE));

            @Getter
            private final Set<Permission> permissions;
public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
}         
    
}
