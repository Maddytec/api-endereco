package br.com.maddytec.endereco.exceptions;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException() {
        super("Cep não encontrado.");
    }

    public EnderecoNotFoundException(String cep) {
        super("Cep: " + cep + " não encontrado ou Inválido");
    }

    public EnderecoNotFoundException(String uf, String cidade, String bairro) {
        super("Endereço inválido.");
    }


}
