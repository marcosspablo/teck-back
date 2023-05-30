package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.model.dto.SerieDTO;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import br.com.fujideia.iesp.tecback.service.SerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {
    @Autowired
    private SerieService service;

    @PostMapping
    public ResponseEntity<SerieDTO> salvar(@RequestBody @Validated SerieDTO serieDTO){
        serieDTO = service.salvar(serieDTO);
        return ResponseEntity.ok(serieDTO);
    }

    @PutMapping
    public ResponseEntity<Serie> alterar(@RequestBody Serie serie){
        serie = service.alterar(serie);
        return ResponseEntity.ok(serie);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> listar(){

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> consultar(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
