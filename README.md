# Trabalho 1 de API e Web Services - Delegacia Eletrônica

Desenvolva uma Web API REST, preferencialmente em Java com Spring Boot, para gerenciar o ciclo de vida de informações de boletins de ocorrência policial. O
sistema deve ser capaz de gerenciar dados de furtos de veículos, vítimas e demais
informações pertinentes ao registro e ocorrências policias.

### As funcionalidades esperadas são:

* Cadastro de boletim de ocorrência de furto de veículos
* Exclusão de boletins previamente cadastrados
* Alteração de boletins previamente cadastrados
* Listagem de boletins previamente cadastrados através dos seguintes filtros:
    * identificador do boletim de ocorrência
    * nome da cidade onde ocorreu o furto
    * período da ocorrência (Manhã, Tarde, Noite, Madrugada, etc)
* Listagem de veículos furtados através dos seguintes filtros:
    * placa
    * cor
    * tipo do veículo (Carro, Motocicleta, Caminhão, etc)

### Persistência e Regras de Negócio:

As funcionalidades esperadas podem realizar a persistência em memória principal.
Ou seja, não é necessário utilizar nenhum mecanismo de persistência de dados ou
banco de dados.

O sistema deve realizar validações das informações cadastrais. Eu seja, deve-se
avaliar se os dados informados pelo usuário são válidos para realizar o cadastro de
boletins de ocorrência. O conjunto de regras deve ser elaborado pelo desenvolvedor
do sistema. Exemplos de regras são:

* formato de e-mail
* validade de datas
* dados obrigatórios
* etc...

Além disso, para adequar a Web API a LGPD (A Lei Geral de Proteção de Dados) os
dados das pessoas envolvidas (vítimas) devem ser omitidos.

### Interface:

O sistema deve disponibilizar uma interface REST para manipulação das
funcionalidades disponibilizadas. A interface REST pode ser implementada via JAX-
RS e executada no contexto de uma aplicação Spring Boot. O Projeto deve seguir as
normas de modelagem e desenvolvimento de Web Services discutidas em aula.

### Publicação de dados reais:

Uma das motivações para o desenvolvimento de Web APIs REST é a publicação de dados
para que outros sistemas possam utilizá-los. Sendo assim, deve-se implementar o
carregamento de dados disponibilizados pelo portal da transparência do governo de São
Paulo. A Secretaria de Segurança Pública (SSP) disponibiliza arquivos XLS (planilhas Excel)
sobre boletins de ocorrências policias. A Web API deve ser capaz de ler os registros e
incorporá-los ao conjunto de dados gerenciados.

Em anexo a este documento descritivo, encontra-se o arquivo de registro que deve ser
utilizado como carga de dados de boletins de ocorrência publicado pela SSP*.

*SSP: http://www.ssp.sp.gov.br/transparenciassp/Consulta.aspx
