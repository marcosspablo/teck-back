package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.model.dto.SerieDTO;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;

    ModelMapper mapper = new ModelMapper();

    public SerieService() {
    }

    public SerieDTO salvar(SerieDTO serieDTO) {
        Serie serie = mapper.map(serieDTO, Serie.class);
        serieDTO = mapper.map(this.repository.save(serie), SerieDTO.class);
        return serieDTO;
    }

    public Serie alterar(Serie serie) {
        if (Objects.nonNull(serie.getId())) {
            serie = (Serie)this.repository.save(serie);
            return serie;
        } else {
            throw new NotFoundException();
        }
    }

    public List<Serie> listar() {
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

    public Serie consultarPorId(Integer id) {
        return (Serie)this.repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
