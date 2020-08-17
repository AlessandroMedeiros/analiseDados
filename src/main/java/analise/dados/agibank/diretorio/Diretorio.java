package analise.dados.agibank.diretorio;

import java.io.File;
import java.util.logging.Logger;

public class Diretorio {

    private static final String caminhoEntrada = System.getProperty("user.home") + "\\data\\in";
    private static final String caminhoSaida = System.getProperty("user.home") + "\\data\\out\\";

    public static void inicializaDiretorio() {
        Logger logger = Logger.getLogger("Diretório");
        logger.info("Criando diretório em " + caminhoEntrada + "\\data ...");
        criaPasta(caminhoEntrada);
        criaPasta(caminhoSaida);
        logger.info("Diretório criado com sucesso!");
    }

    private static void criaPasta(String nomePasta) {
        new File(nomePasta).mkdir();
        new File(nomePasta).mkdir();
    }

    public static String getDiretorioEntrada() {
        return caminhoEntrada;
    }

    public static String getDiretorioSaida() {
        return caminhoSaida;
    }
}
