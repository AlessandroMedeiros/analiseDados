package analise.dados.agibank.diretorio;

import java.util.Arrays;
import java.util.List;

public class Separador {

    public static List<String> separaOsDadosDaLinha(String linha) {
        if (linha.contains("ç")) {
            return Arrays.asList(linha.split("ç"));
        }
        return null;
    }

    public boolean verificaConteudo(List<String> atributos) {
        if (atributos == null || atributos.isEmpty()) {
            return false;
        }
        return true;
    }
}
