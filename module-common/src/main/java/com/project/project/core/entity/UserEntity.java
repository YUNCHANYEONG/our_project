package com.project.project.core.entity;

import jakarta.persistence.*;

import lombok.*;

import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@Table(name = "TBL_USERINFO")
public class UserEntity{

    @Id
    @Column(name="u_userid")
    private String userid;

    @Column(name="u_email")
    private String email;

    @Column(name="u_password")
    private String password;

    @Column(name="u_authority")
    private String authority;

    public UserEntity encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }

}
