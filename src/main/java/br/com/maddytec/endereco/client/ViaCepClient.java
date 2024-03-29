package br.com.maddytec.endereco.client;

import br.com.maddytec.endereco.dto.EnderecoViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    EnderecoViaCepResponseDTO getEndereco(@PathVariable String cep);

    @GetMapping("/{uf}/{cidade}/{bairro}/json")
    List<EnderecoViaCepResponseDTO> getEnderecoList(@PathVariable String uf,
                                                    @PathVariable String cidade,
                                                    @PathVariable String bairro);

}
