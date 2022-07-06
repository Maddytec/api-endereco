package br.com.maddytec.endereco;

import br.com.maddytec.endereco.controller.EnderecoController;
import br.com.maddytec.endereco.dto.EnderecoResponseDTO;
import br.com.maddytec.endereco.dto.EnderecoViaCepResponseDTO;
import br.com.maddytec.endereco.service.EnderecoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EnderecoControllerTest{

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoService enderecoService;

    private EnderecoResponseDTO enderecoResponseDTO;

    private EnderecoViaCepResponseDTO enderecoViaCepResponseDTO;

    private static final String CEP = "87456123";

   @BeforeEach
   private void init(){

    enderecoResponseDTO = EnderecoResponseDTO.builder()
            .cep("87456123")
            .bairro("Ondina")
            .cidade("Salvador")
            .complemento("Casa")
            .uf("BA")
            .logradouro("Travessa Jardim Botânico")
            .build();

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
    void buscarPorCep(){

        when(enderecoService.getEndereco(CEP)).thenReturn(enderecoViaCepResponseDTO.to());

        Assertions.assertEquals(CEP, enderecoViaCepResponseDTO.to().getCep());


}

}
