package analise.dados.agibank.model;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendaModelTest {

    private final String linha = "[1-9-13.75,2-3-17.13,3-5-15.15]";

    @InjectMocks
    private VendaModel vendaModel = new VendaModel();

    @Test
    public void testeGetVendaMaisCara() {
        assertEquals(vendaModel.getVendaMaisCara(linha), 250.89);
    }
}
