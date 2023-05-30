package br.com.fujideia.iesp.tecback.model.dto;

import br.com.fujideia.iesp.tecback.model.Genero;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private Integer id;
    private String titulo;
    private String sinopse;
    private Genero genero;

}
