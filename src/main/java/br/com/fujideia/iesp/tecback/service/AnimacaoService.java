package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Animacao;
import br.com.fujideia.iesp.tecback.model.dto.AnimacaoDTO;
import br.com.fujideia.iesp.tecback.repository.AnimacaoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AnimacaoService {

    @Autowired
    private AnimacaoRepository repository;

    ModelMapper mapper = new ModelMapper();

    public AnimacaoService() {
    }

    public AnimacaoDTO salvar(AnimacaoDTO animacaoDTO) {
        Animacao animacao = mapper.map(animacaoDTO, Animacao.class);
        animacaoDTO = mapper.map(this.repository.save(animacao), AnimacaoDTO.class);
        return animacaoDTO;
    }

    public Animacao alterar(Animacao animacao) {
        if (Objects.nonNull(animacao.getId())) {
            animacao = (Animacao)this.repository.save(animacao);
            return animacao;
        } else {
            throw new NotFoundException();
        }
    }

    public List<Animacao> listar() {
        return this.repository.findAll();
    }

    public Boolean excluir(Integer id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception var3) {
            log.info("Erro ao realizar Exclusão : {}", var3);
            return false;
        }

        return true;
    }

    public Animacao consultarPorId(Integer id) {
        return (Animacao)this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

}
