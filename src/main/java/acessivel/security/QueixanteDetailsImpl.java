package acessivel.security;

import acessivel.entity.Queixante;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class QueixanteDetailsImpl implements UserDetails {

    private Queixante queixante;

    public QueixanteDetailsImpl(Queixante queixante) {
        this.queixante = queixante;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return queixante.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());
        /*
         Este método converte a lista de papéis (roles) associados ao usuário
         em uma coleção de GrantedAuthorities, que é a forma que o Spring Security
         usa para representar papéis. Isso é feito mapeando cada papel para um
         novo SimpleGrantedAuthority, que é uma implementação simples de
         GrantedAuthority
        */
    }

    @Override
    public String getPassword() {
        return queixante.getSenha();
    } // Pega a senha do Queixante para o Security

    @Override
    public String getUsername() {
        return queixante.getEmail();
    } // Pega o email do Queiante para o Security

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

