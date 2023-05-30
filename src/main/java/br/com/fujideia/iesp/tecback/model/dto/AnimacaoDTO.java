package br.com.fujideia.iesp.tecback.model.dto;

import br.com.fujideia.iesp.tecback.model.Animacao;
import br.com.fujideia.iesp.tecback.model.Genero;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimacaoDTO {
    private Integer id;
    private String titulo;
    private String sinopse;
    private Genero genero;

}
