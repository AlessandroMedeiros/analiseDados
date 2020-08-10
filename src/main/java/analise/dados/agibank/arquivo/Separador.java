package analise.dados.agibank.arquivo;

import java.util.Arrays;
import java.util.List;

public class Separador {

    public static List<String> separaOsDadosDaLinha(String linha) {
        return Arrays.asList(linha.split("ç"));
    }
}
