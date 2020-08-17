package analise.dados.agibank.service;

import analise.dados.agibank.conteudo.ConteudoEntrada;
import analise.dados.agibank.conteudo.ConteudoSaida;
import analise.dados.agibank.diretorio.Diretorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.logging.Logger;

@Service
public class ArquivoService {

    private static final String EXTENSAO = ".dat";
    private Logger logger = Logger.getLogger("Arquivo");

    private VendedorService vendedorService;
    private ClienteService clienteService;
    private VendaService vendaService;

    @Autowired
    public ArquivoService(VendedorService vendedorService, ClienteService clienteService, VendaService vendaService) {
        this.vendedorService = vendedorService;
        this.clienteService = clienteService;
        this.vendaService = vendaService;
    }

    public ArquivoService() {
    }

    public void inicializaAnalise(String caminhoArquivo) {
        ConteudoEntrada conteudoEntrada = new ConteudoEntrada();
        lerArquivo(conteudoEntrada, caminhoArquivo);
        gerarArquivoSaida(conteudoEntrada, caminhoArquivo);
    }

    public void lerArquivo(ConteudoEntrada conteudoEntrada, String caminhoArquivo) {
        logger.info("Inicializando a leitura de arquivo...");
        try {
            if (validarExtensaoArquivoEntrada(caminhoArquivo)) {
                FileReader arquivo = new FileReader(caminhoArquivo);
                BufferedReader lerArquivo = new BufferedReader(arquivo);
                String linha = lerArquivo.readLine();
                while (linha != null) {
                    armazenarLinha(linha, conteudoEntrada);
                    linha = lerArquivo.readLine();
                }
                lerArquivo.close();
                arquivo.close();
                logger.info("Leitura de arquivo concluída com sucesso!");
            }
        } catch (IOException e) {
            logger.info("Erro na abertura do arquivo: " + e.getMessage());
        }
    }

    private boolean validarExtensaoArquivoEntrada(String diretorioArquivoEntrada) {
        return EXTENSAO.equals(diretorioArquivoEntrada.substring(diretorioArquivoEntrada.length() - 4));
    }

    private String caminhoArquivoSaida() {
        return Diretorio.getDiretorioSaida();
    }

    private void armazenarLinha(String linha, ConteudoEntrada conteudoEntrada) {
        String codigo = linha.substring(0, 3);

        if (codigo.equals("001")) {
            vendedorService.separarLinha(linha, conteudoEntrada);
        } else if (codigo.equals("002")) {
            clienteService.separarLinha(linha, conteudoEntrada);
        } else if (codigo.equals("003")) {
            vendaService.separarLinha(linha, conteudoEntrada);
        }
    }

    public void gerarArquivoSaida(ConteudoEntrada conteudoEntrada, String caminhoArquivo) {
        logger.info("Inicializando a geração do relatório...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivoSaida() + getNomeArquivoSaida(caminhoArquivo)));
            bufferedWriter.write(gerarRelatorio(conteudoEntrada).toString());
            bufferedWriter.close();
            logger.info("Geração do relatório gerado com sucesso!");

        } catch (IOException e) {
            logger.info("Erro ao gerar o arquivo: " + e.getMessage());
        }

    }

    private String getNomeArquivoSaida(String caminhoArquivo) {
        String nomeArquivo = caminhoArquivo.substring(caminhoArquivo.lastIndexOf("\\")).replace("\\", "");
        nomeArquivo = nomeArquivo.replace(".", ".done.");
        return nomeArquivo;
    }

    public ConteudoSaida gerarRelatorio(ConteudoEntrada conteudoEntrada) {
        ConteudoSaida conteudoSaida = new ConteudoSaida();
        conteudoSaida.setQtdClientes(conteudoEntrada.getListaClientes().size());
        conteudoSaida.setQtdVendedores(conteudoEntrada.getListaClientes().size());
        conteudoSaida.setIdVendaMaisCara(conteudoEntrada.getIdVendaMaisCara());
        conteudoSaida.setPiorVendedor(conteudoEntrada.getNomePiorVendedor());
        return conteudoSaida;
    }
}
