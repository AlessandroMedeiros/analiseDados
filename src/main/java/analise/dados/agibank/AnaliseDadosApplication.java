package analise.dados.agibank;

import analise.dados.agibank.service.WatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class AnaliseDadosApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(AnaliseDadosApplication.class, args);
        WatchService watchService = context.getBean(WatchService.class);
        watchService.iniciaAnalisaDeDados();
    }
}
