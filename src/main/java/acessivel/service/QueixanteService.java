package acessivel.service;

import acessivel.dto.queixante.CriarQueixanteDTO;
import acessivel.entity.Queixante;
import acessivel.repository.QueixanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueixanteService {

    @Autowired
    private QueixanteRepository repository;

    //Validação de CPF.
    public Boolean validarCpf(String cpfQueixante) {

        //Retira os caracteres não numéricos.
        cpfQueixante = cpfQueixante.replaceAll("[^0-9]", "");

        //Confere o tamanho do CPF.
        if (cpfQueixante.length() != 11) {
            return false;
        }
        if (cpfQueixante.matches("(\\d)\\1{10}")) {
            return false;
        }
        try{
            int soma = 0;
            int peso = 10;

            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cpfQueixante.substring(i, i + 1));
                soma += digito * peso--;
            }

            int primeiroDigitoCheck = 11 - (soma % 11);
            if (primeiroDigitoCheck >= 10) {
                primeiroDigitoCheck = 0;
            }

            int segundoDigitoCheck = 11 - (soma % 11);
            if (segundoDigitoCheck >= 10) {
                segundoDigitoCheck = 0;
            }

            return cpfQueixante.endsWith("" + primeiroDigitoCheck + segundoDigitoCheck);
        } catch (NumberFormatException e) {
        return false;
    }

    }

    //Retornar todos os usuários.
    public List<Queixante> getQueixantes(){
        return repository.findAll();
    }

    //Criar um usuário.
    public Queixante criarQueixante(CriarQueixanteDTO data) {
        Queixante queixante = new Queixante();

        queixante.setSenha(data.getSenha());
        queixante.setNome(data.getNome());
        queixante.setSobrenome(data.getSobrenome());
        queixante.setEmail(data.getEmail());
        queixante.setCpf(data.getCpf());
        queixante.setCadPcd(data.getCadPcd());
        queixante.setDataNascimento(data.getDataNascimento());

        repository.save(queixante);
        return queixante;
    }
}
