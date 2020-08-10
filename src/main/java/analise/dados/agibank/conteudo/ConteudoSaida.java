package analise.dados.agibank.conteudo;

public class ConteudoSaida {

    /**
     * O conteúdo do arquivo de saída deve resumir os seguintes dados:
     * <p>
     * ● Quantidade de clientes no arquivo de entrada
     * ● Quantidade de vendedor no arquivo de entrada
     * ● ID da venda mais cara
     * ● O pior vendedor
     */

    private int qtdClientes;
    private int qtdVendedores;
    private int idVendaMaisCara;
    private String piorVendedor;


    public int getQtdClientes() {
        return qtdClientes;
    }

    public void setQtdClientes(int qtdClientes) {
        this.qtdClientes = qtdClientes;
    }

    public int getQtdVendedores() {
        return qtdVendedores;
    }

    public void setQtdVendedores(int qtdVendedores) {
        this.qtdVendedores = qtdVendedores;
    }

    public int getIdVendaMaisCara() {
        return idVendaMaisCara;
    }

    public void setIdVendaMaisCara(int idVendaMaisCara) {
        this.idVendaMaisCara = idVendaMaisCara;
    }

    public String getPiorVendedor() {
        return piorVendedor;
    }

    public void setPiorVendedor(String piorVendedor) {
        this.piorVendedor = piorVendedor;
    }

    @Override
    public String toString() {
        return "ConteudoSaida{" +
                "\nQuantidade de clientes: " + qtdClientes +
                "\nQuantidade de vendedores: " + qtdVendedores +
                "\nID da venda mais cara: " + idVendaMaisCara +
                "\nO pior vendedor: " + piorVendedor +
                "\n}";
    }
}
