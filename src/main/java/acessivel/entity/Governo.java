package acessivel.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "Governo")
@Table(name = "governo")
@EqualsAndHashCode(of = "id_governo")
@NoArgsConstructor
@AllArgsConstructor
public class Governo extends Usuario {

    @Id
    @Column(name = "id_governo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGoverno;

    @Column(name = "matricula")
    private String matricula;

    @Column(name="ativo")
    private Boolean ativo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_GOVERNO"));
    }
}
