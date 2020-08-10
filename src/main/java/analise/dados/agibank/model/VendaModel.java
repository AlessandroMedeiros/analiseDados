package analise.dados.agibank.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class VendaModel {

    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Integer idVenda;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private double venda;

    public double getVendaMaisCara(String linha) {
        linha = linha.replace("[", "").replace("]", "");
        String[] vendas = linha.split(",");
        return Arrays.stream(vendas).
                map(v -> v.split("-")).
                mapToDouble(venda -> Double.parseDouble(venda[1]) * Double.parseDouble(venda[2])).
                sum();
    }
}
