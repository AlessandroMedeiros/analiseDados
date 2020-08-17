package analise.dados.agibank.service;

import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteServiceTest {

    @InjectMocks
    private final ClienteService clienteService = new ClienteService();

    @InjectMocks
    private ConteudoEntrada conteudoEntrada = new ConteudoEntrada();

    private final String linha = "002ç2345675434544345çDeboraçCidade";


    @Test
    public void testeCliente() {
        clienteService.separarLinha(linha, conteudoEntrada);
        assertEquals(conteudoEntrada.getListaClientes().get(0).getId(), Integer.parseInt("002"));
        assertEquals(conteudoEntrada.getListaClientes().get(0).getCnpj(), Long.parseLong("2345675434544345"));
        assertEquals(conteudoEntrada.getListaClientes().get(0).getNome(), "Debora");
        assertEquals(conteudoEntrada.getListaClientes().get(0).getAreaDeNegocio(), "Cidade");
    }

    @Test
    public void testeClienteLinhaVazia() {
        String linha = "";
        clienteService.separarLinha(linha, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaVenda().isEmpty());
    }

    @Test
    public void testeCodigoCliente() {
        clienteService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaClientes().get(0).getId()), "2");
    }

    @Test
    public void testeCnpjCliente() {
        clienteService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaClientes().get(0).getCnpj()).length(), 16);
    }

    @Test
    public void testeNomeCliente() {
        clienteService.separarLinha(linha, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaClientes().get(0).getNome().matches("[a-zA-Z]+"));
    }

    @Test
    public void testeSalarioCliente() {
        clienteService.separarLinha(linha, conteudoEntrada);
        assertTrue(String.valueOf(conteudoEntrada.getListaClientes().get(0).getAreaDeNegocio()).matches("[a-zA-Z]+"));
    }
}
