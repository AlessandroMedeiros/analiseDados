package analise.dados.agibank.arquivo;

import analise.dados.agibank.conteudo.ConteudoSaida;
import analise.dados.agibank.service.ClienteService;
import analise.dados.agibank.service.VendaService;
import analise.dados.agibank.service.VendedorService;
import analise.dados.agibank.conteudo.ConteudoEntrada;

import java.io.*;
import java.util.logging.Logger;

public class Arquivo {

    private static final String EXTENSAO = ".dat";
    private Logger logger = Logger.getLogger("Arquivo");

    public void lerArquivo(ConteudoEntrada conteudoEntrada) {
        logger.info("Inicializando a leitura de arquivo...");
        try {
            if (validarExtensaoArquivoEntrada(caminhoArquivoEntrada())) {
                FileReader arquivo = new FileReader(caminhoArquivoEntrada());
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

    private String caminhoArquivoEntrada() {
        return new Diretorio().getDiretorio() + "\\data\\in\\" + "in.dat";
    }

    private String caminhoArquivoSaida() {
        return new Diretorio().getDiretorio() + "\\data\\out\\out.done.dat";
    }

    private void armazenarLinha(String linha, ConteudoEntrada conteudoEntrada) {
        String codigo = linha.substring(0, 3);

        if (codigo.equals("001")) {
            VendedorService vendedorService = new VendedorService();
            vendedorService.separarLinha(linha, conteudoEntrada);
        } else if (codigo.equals("002")) {
            ClienteService clienteService = new ClienteService();
            clienteService.separarLinha(linha, conteudoEntrada);
        } else if (codigo.equals("003")) {
            VendaService vendaService = new VendaService();
            vendaService.separarLinha(linha, conteudoEntrada);
        }
    }

    public void gerarArquivoSaida(ConteudoEntrada conteudoEntrada) {
        logger.info("Inicializando a geração do relatório...");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivoSaida()));
            bufferedWriter.write(gerarRelatorio(conteudoEntrada).toString());
            bufferedWriter.close();
            logger.info("Geração do relatório gerado com sucesso!");

        } catch (IOException e) {
            logger.info("Erro ao gerar o arquivo: " + e.getMessage());
        }

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
