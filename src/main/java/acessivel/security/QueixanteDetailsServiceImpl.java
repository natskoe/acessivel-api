package acessivel.security;

import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class QueixanteDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private QueixanteRepository queixanteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Queixante queixante = queixanteRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new QueixanteDetailsImpl(queixante);
    }
}
