package analise.dados.agibank.service;

import analise.dados.agibank.arquivo.Separador;
import analise.dados.agibank.model.ClienteModel;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends Separador {

    public void separarLinha(String linha, ConteudoEntrada conteudoEntrada) {
        List<String> atributos = separaOsDadosDaLinha(linha);
        salvaClienteNaLista(conteudoEntrada, atributos);
    }

    private void salvaClienteNaLista(ConteudoEntrada conteudoEntrada, List<String> atributos) {
        conteudoEntrada.getListaClientes().add(salvaCliente(atributos));
    }

    private ClienteModel salvaCliente(List<String> atributos) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(Integer.parseInt(atributos.get(0)));
        clienteModel.setCnpj(Long.parseLong(atributos.get(1)));
        clienteModel.setNome(atributos.get(2));
        clienteModel.setAreaDeNegocio(atributos.get(3));
        return clienteModel;
    }
}
