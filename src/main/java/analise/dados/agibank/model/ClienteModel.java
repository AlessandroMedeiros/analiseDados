package analise.dados.agibank.model;


import lombok.Getter;
import lombok.Setter;

public class ClienteModel {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Long cnpj;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String areaDeNegocio;
}
