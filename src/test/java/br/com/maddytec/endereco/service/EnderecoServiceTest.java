package br.com.maddytec.endereco.service;

import br.com.maddytec.endereco.client.ViaCepClient;
import br.com.maddytec.endereco.controller.EnderecoController;
import br.com.maddytec.endereco.dto.EnderecoResponseDTO;
import br.com.maddytec.endereco.dto.EnderecoViaCepResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private ViaCepClient viaCepClient;

    private EnderecoResponseDTO enderecoResponseDTO;

    private EnderecoViaCepResponseDTO enderecoViaCepResponseDTO;

    private static final String CEP = "87456123";

    @BeforeEach
    private void init() {

        enderecoViaCepResponseDTO = EnderecoViaCepResponseDTO.builder()
                .cep("87456123")
                .bairro("Ondina")
                .localidade("Salvador")
                .complemento("Casa")
                .uf("BA")
                .logradouro("Travessa Jardim Botânico")
                .build();
    }

    @Test
    void buscarPorCep() {

        when(viaCepClient.getEndereco(CEP)).thenReturn(this.enderecoViaCepResponseDTO);
        EnderecoResponseDTO enderecoResponseDTO = enderecoService.getEndereco(CEP);

        Assertions.assertNotNull(enderecoResponseDTO);
        Assertions.assertEquals(CEP, enderecoResponseDTO.getCep());
        Assertions.assertEquals("Salvador", enderecoResponseDTO.getCidade());

    }

}
