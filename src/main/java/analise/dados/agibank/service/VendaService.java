package analise.dados.agibank.service;

import analise.dados.agibank.arquivo.Separador;
import analise.dados.agibank.model.VendaModel;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService extends Separador {

    public void separarLinha(String linha, ConteudoEntrada conteudoEntrada) {
        List<String> atributos = separaOsDadosDaLinha(linha);
        salvaVendaNaLista(conteudoEntrada, atributos);
    }

    private void salvaVendaNaLista(ConteudoEntrada conteudoEntrada, List<String> atributos) {
        conteudoEntrada.getListaVenda().add(salvaVenda(atributos));
    }

    private VendaModel salvaVenda(List<String> atributos) {
        VendaModel vendaModel = new VendaModel();
        vendaModel.setId(Integer.parseInt(atributos.get(0)));
        vendaModel.setIdVenda(Integer.parseInt(atributos.get(1)));
        vendaModel.setVenda(vendaModel.getVendaMaisCara(atributos.get(2)));
        vendaModel.setNome(atributos.get(3));
        return vendaModel;
    }
}
