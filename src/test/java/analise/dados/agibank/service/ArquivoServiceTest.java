package analise.dados.agibank.service;

import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArquivoServiceTest {

    @InjectMocks
    private ClienteService clienteService = new ClienteService();
    @InjectMocks
    private VendaService vendaService = new VendaService();
    @InjectMocks
    private VendedorService vendedorService = new VendedorService();
    @InjectMocks
    ArquivoService arquivoService = new ArquivoService();
    @InjectMocks
    private ConteudoEntrada conteudoEntrada = new ConteudoEntrada();

    @Test
    public void testaSaidaArquivo() {
        vendedorService.separarLinha("001ç1234567891234çAlessandroç30000", conteudoEntrada);
        vendedorService.separarLinha("001ç1234567891234çLeonardoç20000", conteudoEntrada);
        clienteService.separarLinha("002ç2345675434544345çAlineçCidade", conteudoEntrada);
        clienteService.separarLinha("002ç2345675434544345çDéboraçCidade", conteudoEntrada);
        vendaService.separarLinha("003ç01ç[1-4-35.73,2-7-17.13,3-5-27.90]çWilson", conteudoEntrada);
        vendaService.separarLinha("003ç01ç[1-2-35.73,2-3-17.13,3-2-27.90]çEnio", conteudoEntrada);

        arquivoService.gerarRelatorio(conteudoEntrada);

        assertEquals(2, conteudoEntrada.getListaClientes().size());
        assertEquals(2, conteudoEntrada.getListaVendedores().size());
        assertEquals(1, conteudoEntrada.getIdVendaMaisCara());
        assertEquals("Leonardo", conteudoEntrada.getNomePiorVendedor());
    }
}