package br.com.fujideia.iesp.tecback.service;



import br.com.fujideia.iesp.tecback.model.Animacao;
import br.com.fujideia.iesp.tecback.repository.AnimacaoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AnimacaoService {
    @Autowired
    private AnimacaoRepository repository;

    public Animacao salvar(Animacao animacao){
        animacao = repository.save(animacao);
        return animacao;
    }

    public Animacao alterar(Animacao animacao){
        if(Objects.nonNull(animacao.getId())){
            animacao = repository.save(animacao);
        }else{
            throw new NotFoundException();
        }
        return animacao;
    }

    public List<Animacao> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Animacao consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

}