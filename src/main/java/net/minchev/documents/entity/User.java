package net.minchev.documents.entity;

import io.jmix.core.HasTimeZone;
import io.jmix.core.annotation.Secret;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.SystemLevel;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.security.authentication.JmixUserDetails;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "USERS", indexes = {
        @Index(name = "IDX_USER__ON_USERNAME", columnList = "USERNAME", unique = true)
})
public class User implements JmixUserDetails {

    @Id
    @Column(name = "ID")
    @JmixGeneratedValue
    private Long id;

    @InstanceName
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Secret
    @SystemLevel
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE")
    private Boolean active = true;

    @Column(name = "USER_TYPE")
    private String userType;


    @Column(name = "PERSON_ID")
    private String person;


    @Column(name = "KFN_EMPLOYEE_ID")
    private String kfnEmployee;
    @Transient
    protected Collection<? extends GrantedAuthority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities != null ? authorities : Collections.emptyList();
    }

    @Override
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
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
        return Boolean.TRUE.equals(active);
    }


}