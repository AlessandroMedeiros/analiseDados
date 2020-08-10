package analise.dados.agibank.service;

import analise.dados.agibank.arquivo.Separador;
import analise.dados.agibank.model.VendedorModel;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService extends Separador {

    public void separarLinha(String linha, ConteudoEntrada conteudoEntrada) {
        List<String> atributos = separaOsDadosDaLinha(linha);
        salvaVendedorNaLista(conteudoEntrada, atributos);
    }

    private void salvaVendedorNaLista(ConteudoEntrada conteudoEntrada, List<String> atributos) {
        conteudoEntrada.getListaVendedores().add(salvaVendedor(atributos));
    }

    private VendedorModel salvaVendedor(List<String> atributos) {
        VendedorModel vendedorModel = new VendedorModel();
        vendedorModel.setId(Integer.parseInt(atributos.get(0)));
        vendedorModel.setCpf(Long.parseLong(atributos.get(1)));
        vendedorModel.setNome(atributos.get(2));
        vendedorModel.setSalario(Double.parseDouble(atributos.get(3)));
        return vendedorModel;
    }
}
