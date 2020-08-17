package analise.dados.agibank.conteudo;

import analise.dados.agibank.model.ClienteModel;
import analise.dados.agibank.model.VendaModel;
import analise.dados.agibank.model.VendedorModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

public class ConteudoEntrada {

    @Getter
    @Setter
    private List<VendedorModel> listaVendedores = new ArrayList<>();
    @Getter
    @Setter
    private List<ClienteModel> listaClientes = new ArrayList<>();
    @Getter
    @Setter
    private List<VendaModel> listaVenda = new ArrayList<>();

    public int getIdVendaMaisCara() {
        int idVendaMaisCara = (int) MIN_VALUE;
        double vendaMaisCara = 0;
        for (VendaModel vendaModel : listaVenda) {
            if (vendaModel.getVenda() > vendaMaisCara) {
                vendaMaisCara = vendaModel.getVenda();
                idVendaMaisCara = vendaModel.getIdVenda();
            }
        }
        return idVendaMaisCara;
    }

    public String getNomePiorVendedor() {
        double menorSalario = MAX_VALUE;
        String nomeVendedor = "";
        for (VendedorModel listaVendedor : listaVendedores) {
            if (listaVendedor.getSalario() < menorSalario) {
                menorSalario = listaVendedor.getSalario();
                nomeVendedor = listaVendedor.getNome();
            }
        }
        return nomeVendedor;
    }
}
