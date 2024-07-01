package acessivel.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity(name = "Queixante")
@Table(name = "queixante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter                                // USER DETAILS É DO SPRING SECURITY
public class Queixante extends Usuario implements UserDetails {
    @Id
    @Column(name = "id_queixante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQueixante;

    @Column(name = "cad_pcd")
    private String cadPcd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_id_endereco")
    private Endereco endereco;

    // Implementando UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername(){
        return getEmail();
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