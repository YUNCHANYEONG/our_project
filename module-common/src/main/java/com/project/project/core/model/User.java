package com.project.project.core.model;

import com.project.project.core.entity.UserEntity;
import com.project.project.security.util.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    private String userid;
    private String email;
    private String password;
    private List<Roles> Roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleKey()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public static User UserEntityToUser(UserEntity userEntity){
        User user = new User();
        user.setUserid(userEntity.getUserid());
        user.setEmail(userEntity.getAuthority());
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
