package analise.dados.agibank.service;

import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendedorServiceTest {

    @InjectMocks
    private final VendedorService vendedorService = new VendedorService();

    @InjectMocks
    private ConteudoEntrada conteudoEntrada = new ConteudoEntrada();

    private final String linha = "001ç1234567891234çAlessandroç10000";

    @Test
    public void testeVendedor() {
        vendedorService.separarLinha(linha, conteudoEntrada);
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getId(), Integer.parseInt("001"));
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getCpf(), Long.parseLong("1234567891234"));
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getNome(), "Alessandro");
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getSalario(), 10000);
    }

    @Test
    public void testeVendedorLinhaVazia() {
        String linhaVazia = "";
        vendedorService.separarLinha(linhaVazia, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaVendedores().isEmpty());
    }

    @Test
    public void testeCodigoVendedor() {
        vendedorService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaVendedores().get(0).getId()), "1");
    }

    @Test
    public void testeCpfVendedor() {
        vendedorService.separarLinha(linha, conteudoEntrada);
        assertEquals(String.valueOf(conteudoEntrada.getListaVendedores().get(0).getCpf()).length(), 13);
    }

    @Test
    public void testeNomeVendedor() {
        vendedorService.separarLinha(linha, conteudoEntrada);
        assertTrue(conteudoEntrada.getListaVendedores().get(0).getNome().matches("[a-zA-Z]+"));
    }

    @Test
    public void testeSalarioVendedor() {
        vendedorService.separarLinha(linha, conteudoEntrada);
        assertTrue(String.valueOf(conteudoEntrada.getListaVendedores().get(0).getSalario()).matches("[0-9.]+"));
    }
}
