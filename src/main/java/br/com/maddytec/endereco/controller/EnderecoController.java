package br.com.maddytec.endereco.controller;

import br.com.maddytec.endereco.dto.EnderecoResponseDTO;
import br.com.maddytec.endereco.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("/endereco/{cep}")
    public EnderecoResponseDTO getEndereco(@PathVariable String cep) {
        return enderecoService.getEndereco(cep);
    }
    @GetMapping("/endereco/{uf}/{cidade}/{bairro}")
    public List<EnderecoResponseDTO> getEnderecoList(@PathVariable String uf,
                                                     @PathVariable String cidade,
                                                     @PathVariable String bairro) {

        return enderecoService.getEnderecoList(uf, cidade, bairro);
    }


}
