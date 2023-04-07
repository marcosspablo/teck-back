package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Animacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimacaoRepository extends JpaRepository<Animacao,Integer> {
}
