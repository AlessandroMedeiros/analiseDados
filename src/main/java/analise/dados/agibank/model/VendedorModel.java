package analise.dados.agibank.model;

import lombok.Getter;
import lombok.Setter;

public class VendedorModel {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Long cpf;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private double salario;
}
