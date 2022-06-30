package br.com.maddytec.endereco.service;

import br.com.maddytec.endereco.client.ViaCepClient;
import br.com.maddytec.endereco.dto.EnderecoResponseDTO;
import br.com.maddytec.endereco.dto.EnderecoViaCepResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final ViaCepClient viaCepClient;

    public EnderecoResponseDTO getEndereco(String cep) {
        final EnderecoViaCepResponseDTO enderecoViaCepResponseDTO = viaCepClient.getEndereco(cep);
        return enderecoViaCepResponseDTO.to();
    }

}
