package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "É necessário informar o título da série")
    private String titulo;
    @NotNull(message = "O campo sinpose é obrigatório")
    @Column(name = "ds_sinopse",length = 500)
    private @NotBlank String sinopse;
    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
}
