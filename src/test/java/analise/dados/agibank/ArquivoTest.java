package analise.dados.agibank;

import analise.dados.agibank.arquivo.Arquivo;
import analise.dados.agibank.service.ClienteService;
import analise.dados.agibank.service.VendaService;
import analise.dados.agibank.service.VendedorService;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArquivoTest {

    @InjectMocks
    private ClienteService clienteService = new ClienteService();
    @InjectMocks
    private VendaService vendaService = new VendaService();
    @InjectMocks
    private VendedorService vendedorService = new VendedorService();

    @Test
    public void testaSaidaArquivo() {
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        vendedorService.separarLinha("001ç1234567891234çAlessandroç30000", conteudoEntrada);
        vendedorService.separarLinha("001ç1234567891234çLeonardoç20000", conteudoEntrada);
        clienteService.separarLinha("002ç2345675434544345çAlineçCidade", conteudoEntrada);
        clienteService.separarLinha("002ç2345675434544345çDéboraçCidade", conteudoEntrada);
        vendaService.separarLinha("003ç01ç[1-4-35.73,2-7-17.13,3-5-27.90]çWilson", conteudoEntrada);
        vendaService.separarLinha("003ç01ç[1-2-35.73,2-3-17.13,3-2-27.90]çEnio", conteudoEntrada);

        Arquivo arquivo = new Arquivo();
        arquivo.gerarRelatorio(conteudoEntrada);

        assertEquals(2, conteudoEntrada.getListaClientes().size());
        assertEquals(2, conteudoEntrada.getListaVendedores().size());
        assertEquals(1, conteudoEntrada.getIdVendaMaisCara());
        assertEquals("Leonardo", conteudoEntrada.getNomePiorVendedor());
    }
}
