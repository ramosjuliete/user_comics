# API UserComics

#### Requisitos
* Java 11
* Spring Tools
* Postman
#### Como executar e realizar testes no Postman
* Adicionar o projeto no Spring  Tools
* Executar o arquivo JulieteUserComicsAplication.java como Spring Boot App
* O arquivo TestConfig.java fará um carregamento inicial do banco de dados de teste H2
* Acessar o App Postman e testar requições:
  * GET
    * http://localhost:8080/users  para retornar todos os usuários cadastrados
    * http://localhost:8080/users/1 para retornar os dados do usuário de código 1 com os quadrinhos associados
    * http://localhost:8080/comics para retornar todos os quadrinhos cadastrados
    * http://localhost:8080/comics/1/SEG para retornar o quadrinho com desconto da segunda-feira (regras de negócios específicas)
  * POST
    * http://localhost:8080/users para cadastrar um usuário
    * http://localhost:8080/comics para cadastrar um quadrinho
   
