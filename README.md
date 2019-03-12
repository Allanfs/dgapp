# DGApp Backend
Aplicação REST de Pizzaria

## Execução e Configuração do Ambiente

### Lombok
Para utilização do Lombok no Eclipse siga [esta resposta no StackOverflow](https://stackoverflow.com/a/46034044)
* [Java menos verboso com Lombok](http://blog.caelum.com.br/java-menos-verboso-com-lombok/)
* [Uma visão sobre o Projeto Lombok - Devmedia](https://www.devmedia.com.br/uma-visao-sobre-o-projeto-lombok/28321)

### Banco de Dados
**Mysql** em Docker
>  docker run -it -e MYSQL\_ROOT\_PASSWORD=123 mysql

>  mysql> create database db;

## Endpoints

Entidades em [~.modelo](https://github.com/Allanfs/dgapp/tree/master/src/main/java/com/github/allanfs/dgapp/modelo) possuem controllers que atendem as estas requisições.

| Requisição                	| Descrição                      	|
|---------------------------	|--------------------------------	|
| `GET /{entidade}`         	| retorna todos os registros     	|
| `GET /{entidade}/{id}`    	| retorna registro de id {id}    	|
| `POST /{entidade}`        	| cadastra a entidade            	|
| `DELETE /{entidade}/{id}` 	| exclui a entidade de id {id}   	|
| `PUT /{entidade}/{id}`    	| atualiza a entidade de id {id} 	|
