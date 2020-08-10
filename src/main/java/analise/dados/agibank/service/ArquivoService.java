package analise.dados.agibank.service;

import analise.dados.agibank.arquivo.Arquivo;
import analise.dados.agibank.arquivo.Diretorio;
import analise.dados.agibank.conteudo.ConteudoEntrada;
import org.springframework.stereotype.Service;

@Service
public class ArquivoService {

    public void inicializarAnalise() {
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        Diretorio diretorio = new Diretorio();
        Arquivo arquivo = new Arquivo();

        diretorio.criaCaminho();
        arquivo.lerArquivo(conteudoEntrada);
        arquivo.gerarArquivoSaida(conteudoEntrada);
    }
}
