package com.project.project.security.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Roles {
    ADMIN("ROLE_ADMIN", "슈퍼 관리자", "10"),
    MANAGER("ROLE_MANAGER", "관리자", "20"),
    USER("ROLE_USER", "사용자", "30"),
    ;

    private String roleKey;
    private String roleName;
    private String roleValue;

    public static Roles findByRoleValue(String value) {
        return Arrays.stream(Roles.values())
                .filter(role -> role.getRoleValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
