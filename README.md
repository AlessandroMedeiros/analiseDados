<b>Bem-vindo ao sistema de simulação analise de dados!</b>
<br>

Esse sistema resumidamente trata-se de ler dados de um arquivo e gerar um relatório em um arquivo .dat.
<br><br>

<p>
  Arquivo de entrada:<br><br>
	<img src="https://imgur.com/oxCC676.jpg">
</p>

<p>
  Arquivo de saída:<br><br>
	<img src="https://i.imgur.com/WrWXTYw.jpg">
</p>


<br><br>
Segue um breve relato do sistema...
<br><br>
Para realizar a construção desse sistema, foi dividido em 5 etapas:
<br><br>
1 - Criação do projeto e montar a estrutura da arquitetura.<br>
2 - Ler o arquivo e salvar os dados nos objetos.<br>
3 - Gerar o arquivo de saída.<br>
4 - Focar nos criterios de avaliação (Clean Code, Simplicity, Logic, SOC, Flexibility/Extensibility, Scalability/Performance).<br>
5 - Testes unitários.<br>

<br>

Apesar Spring Boot ser mais usado para sistemas web, uso esse framework para facilitar o desenvolvimento do projeto
e fazer com que eu me preocupe mais com a aplicação e menos com a configuração.
Como tinha pouco tempo para realizar o projeto, pois trabalho o dia todo, preferi focar nas funcionalidades e com qualidade,
também fica fácil outro desenvolvedor dar manutenção ao projeto e permite escalar com mais naturalidade.

<br>

Dividi o software em 4 módulos:<br>
1 - arquivo<br>
2 - conteudo<br>
3 - model<br>
4 - service<br>
<br>

O SpringApplication roda o arquivo de analise de dados que chama a classe ArquivoService e inicializa a analise de dados.
<br>Dentro do método inicializarAnalise() é criado o diretório de saída e chamado o método lerArquivo() passando o objeto ConteudoEntrada para armazenar esse arquivo.
O sistema valida a extensão do arquivo de entrada, pois só pode ser .dat a extensão mesmo.
Esse método além de ler o arquivo in.dat começar a salvar os objetos nas listas, chamando o método separarLinha() dos arquivos de service.
<br><br>
Depois de salvar os dados nos respectivos objetos, o sistema começa a gerar arquivo de saída passando os objetos por parâmetro com o método gerarArquivoSaida().
E consequentemente chamando o método gerarRelatorio() para escrever nesse arquivo out.dat.done
<br><br>
Por fim, é executado uma bateria de testes para validar o projeto.
