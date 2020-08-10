package analise.dados.agibank;

import analise.dados.agibank.service.ArquivoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnaliseDadosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnaliseDadosApplication.class, args);
        ArquivoService arquivoService = new ArquivoService();
        arquivoService.inicializarAnalise();
    }
}
