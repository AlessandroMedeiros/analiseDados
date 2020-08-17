package analise.dados.agibank.service;

import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendaServiceTest {

    @InjectMocks
    private final VendaService vendaService = new VendaService();

    @InjectMocks
    private ConteudoEntrada conteudoEntrada = new ConteudoEntrada();

    private final String linha = "003ç5ç[1-9-13.75,2-3-17.13,3-5-15.15]çLucas";

    @Test
    public void testeVenda() {
        vendaService.separarLinha(linha, conteudoEntrada);

        assertEquals(conteudoEntrada.getListaVenda().get(0).getId(), Integer.parseInt("003"));
        assertEquals(conteudoEntrada.getListaVenda().get(0).getIdVenda(), Integer.parseInt("5"));
        assertEquals(conteudoEntrada.getListaVenda().get(0).getVenda(), 250.89);
        assertEquals(conteudoEntrada.getListaVenda().get(0).getNome(), "Lucas");
    }

    @Test
    public void testeVendaLinhaVazia() {
        String linha = "";
        vendaService.separarLinha(linha, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaClientes().isEmpty());
    }

    @Test
    public void testeCodigoVenda() {
        vendaService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaVenda().get(0).getId()), "3");
    }

    @Test
    public void testeIdVenda() {
        vendaService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaVenda().get(0).getIdVenda()), "5");
    }

    @Test
    public void testeNomeVendedor() {
        vendaService.separarLinha(linha, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaVenda().get(0).getNome().matches("[a-zA-Z]+"));
    }

    @Test
    public void testeSalarioVendedor() {
        vendaService.separarLinha(linha, conteudoEntrada);
        assertTrue(String.valueOf(conteudoEntrada.getListaVenda().get(0).getVenda()).matches("[0-9.]+"));
    }
}
