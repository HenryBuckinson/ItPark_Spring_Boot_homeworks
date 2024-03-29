package Application.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Authorities {
    static final String ROLE_PREFIX = "ROLE_";

    public static final String ROLE_ADMIN = ROLE_PREFIX + "ADMIN";
    public static final String ROLE_USER = ROLE_PREFIX + "USER";

    public boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).anyMatch(ROLE_ADMIN::equals);
    }

    public boolean isUser() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).anyMatch(ROLE_USER::equals);
    }

}
