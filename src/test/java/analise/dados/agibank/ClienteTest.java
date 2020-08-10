package analise.dados.agibank;

import analise.dados.agibank.service.ClienteService;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @InjectMocks
    private final ClienteService clienteService = new ClienteService();

    @Test
    public void testeCliente() {
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        String linha = "002ç2345675434544345çDéboraçCidade";
        clienteService.separarLinha(linha, conteudoEntrada);

        assertEquals(conteudoEntrada.getListaClientes().get(0).getId(), Integer.parseInt("002"));
        assertEquals(conteudoEntrada.getListaClientes().get(0).getCnpj(), Long.parseLong("2345675434544345"));
        assertEquals(conteudoEntrada.getListaClientes().get(0).getNome(), "Débora");
        assertEquals(conteudoEntrada.getListaClientes().get(0).getAreaDeNegocio(), "Cidade");
    }
}
