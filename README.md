# 7daysofcode - Api de Filmes

## Como Rodar o Projeto:
 - Primeiramente, será necessário criar o arquivo `application-dev.properties` no pacote `src/main/resources`. O conteúdo esperado deste arquivo é:
```properties
movies.integration.base.url=<URL_DA_API>
movies.integration.api.token=<TOKEN_DA_API>
```

 - Após isso, basta compilar o APP com o comando `mvn clean install` e `mvn spring-boot:run`

## Documentação de API
 - É possível acessar o Swagger por meio da rota `/swagger-ui.html`