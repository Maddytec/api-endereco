package br.com.maddytec.endereco.exceptions;

public class EnderecoBadRequestException extends RuntimeException {

    public EnderecoBadRequestException() {
        super("Cep não encontrado.");
    }

    public EnderecoBadRequestException(String cep) {
        super("Cep: " + cep + " não encontrado ou Inválido");
    }

    public EnderecoBadRequestException(String uf, String cidade, String bairro) {
        super("Endereço Inválido.");
    }

}
