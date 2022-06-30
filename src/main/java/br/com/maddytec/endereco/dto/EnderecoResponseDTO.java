package br.com.maddytec.endereco.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnderecoResponseDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String uf;
    private String cidade;

}
