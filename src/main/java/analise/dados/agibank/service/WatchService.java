package analise.dados.agibank.service;

import analise.dados.agibank.diretorio.Diretorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.WatchKey;

import static java.nio.file.StandardWatchEventKinds.*;

@Service
public class WatchService {

    @Autowired
    private ArquivoService arquivoService;


    public void iniciaAnalisaDeDados() throws IOException, InterruptedException {
        java.nio.file.WatchService watchService = FileSystems.getDefault().newWatchService();
        Paths.get(Diretorio.getDiretorioEntrada()).register(watchService, ENTRY_CREATE, ENTRY_MODIFY, OVERFLOW);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            inicializaDiretorio();
            inicializaAnalise(Diretorio.getDiretorioEntrada() + "\\" + key.pollEvents().stream().findFirst().get().context().toString());
            key.reset();
        }
    }

    private void inicializaDiretorio() {
        Diretorio.inicializaDiretorio();
    }

    private void inicializaAnalise(String arquivo) {
        arquivoService.inicializaAnalise(arquivo);
    }
}
