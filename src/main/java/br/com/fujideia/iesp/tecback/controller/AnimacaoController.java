package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Animacao;
import br.com.fujideia.iesp.tecback.model.dto.AnimacaoDTO;
import br.com.fujideia.iesp.tecback.service.AnimacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animacao")
public class AnimacaoController {

    @Autowired
    private AnimacaoService service;

    @PostMapping
    public ResponseEntity<AnimacaoDTO> salvar(@RequestBody @Validated AnimacaoDTO animacaoDTO){
        animacaoDTO = service.salvar(animacaoDTO);
        return ResponseEntity.ok(animacaoDTO);
    }

    @PutMapping
    public ResponseEntity<Animacao> alterar(@RequestBody Animacao animacao){
        animacao = service.alterar(animacao);
        return ResponseEntity.ok(animacao);
    }

    @GetMapping
    public ResponseEntity<List<Animacao>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animacao> consultar(@PathVariable("id") Integer id){
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
