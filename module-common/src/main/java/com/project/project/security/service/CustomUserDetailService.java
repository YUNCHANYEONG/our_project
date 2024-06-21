package com.project.project.security.service;

import com.project.project.core.entity.UserEntity;
import com.project.project.core.model.User;
import com.project.project.core.repository.UserRepository;
import com.project.project.security.util.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        if(userEntity.isPresent()){
            User user = User.UserEntityToUser(userEntity.get());

            List<Roles> roles = new ArrayList<>();
            roles.add(Roles.findByRoleValue(userEntity.get().getAuthority()));
            user.setRoles(roles);

            return user;
        }else{
            throw new UsernameNotFoundException("User is not Auth");
        }
    }

}
