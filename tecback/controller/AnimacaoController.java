package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Animacao;
import br.com.fujideia.iesp.tecback.service.AnimacaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animacao")
public class AnimacaoController {

    @Autowired
    private AnimacaoService service;

    @PostMapping
    public ResponseEntity<Animacao> salvar(@RequestBody Animacao animacao){
        animacao = service.salvar(animacao);
        return ResponseEntity.ok(animacao);
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