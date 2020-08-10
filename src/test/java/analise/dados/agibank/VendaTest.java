package analise.dados.agibank;

import analise.dados.agibank.service.VendaService;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendaTest {

    @InjectMocks
    private final VendaService vendaService = new VendaService();

    @Test
    public void testeVenda(){
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        String linha = "003ç5ç[1-9-13.75,2-3-17.13,3-5-15.15]çLucas";
        vendaService.separarLinha(linha, conteudoEntrada);

        assertEquals(conteudoEntrada.getListaVenda().get(0).getId(), Integer.parseInt("003"));
        assertEquals(conteudoEntrada.getListaVenda().get(0).getIdVenda(), Integer.parseInt("5"));
        assertEquals(conteudoEntrada.getListaVenda().get(0).getVenda(), 250.89);
        assertEquals(conteudoEntrada.getListaVenda().get(0).getNome(), "Lucas");
    }
}
