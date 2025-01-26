package com.example.lab1.config;

import com.example.lab1.model.User;
import org.springframework.security.core.userdetails.UserDetails;
// остальное для GrantedAuthority
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

import java.util.Collection;
import java.util.Collections;

public class SecurityUserDetails implements UserDetails {

    private final User user;

    // Исправлено: пишем User (с заглавной буквы), а не user
    public SecurityUserDetails(User user) {
        this.user = user;
    }

    // Имплементируем методы из интерфейса UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Допустим, у нас одна роль
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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