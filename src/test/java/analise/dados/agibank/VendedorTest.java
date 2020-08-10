package analise.dados.agibank;

import analise.dados.agibank.service.VendedorService;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendedorTest {

    @InjectMocks
    private final VendedorService vendedorService = new VendedorService();

    @Test
    public void testeVendedor() {
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        String linha = "001ç1234567891234çAlessandroç10000";
        vendedorService.separarLinha(linha, conteudoEntrada);

        assertEquals(conteudoEntrada.getListaVendedores().get(0).getId(), Integer.parseInt("001"));
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getCpf(), Long.parseLong("1234567891234"));
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getNome(), "Alessandro");
        assertEquals(conteudoEntrada.getListaVendedores().get(0).getSalario(), 10000);
    }
}
