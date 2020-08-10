package analise.dados.agibank.arquivo;

import java.io.File;
import java.util.logging.Logger;

public class Diretorio {

    private static final String caminho = System.getProperty("user.home");
    private Logger logger = Logger.getLogger("Diretório");

    public void criaCaminho() {
        logger.info("Criando diretório em " + caminho +  "\\data ...");
        criaPasta(caminho);
        logger.info("Diretório criado com sucesso!");
    }

    private void criaPasta(String nomePasta) {
        new File(nomePasta + "\\data\\in\\").mkdir();
        new File(nomePasta + "\\data\\out\\").mkdir();
    }

    public String getDiretorio() {
        return caminho;
    }
}
