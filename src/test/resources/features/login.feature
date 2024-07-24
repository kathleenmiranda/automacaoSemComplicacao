#language:pt

  @login
  Funcionalidade: Realizar Login
    Testes da API de login

    Cenario: Realizar login com sucesso
      Dado que tenha uma playload valido da API de Login
      Quando envio uma requisicao do tipo POST de Login
      Entao valido que recebo status 200 no response
      E armazeno o token que recebo do response de Login

      Esquema do Cenario: : Realizar Login com <cenario>
        Dado que tenha um payload da API com as seguintes informacoes
          | email | <email> |
          | senha | <senha> |
        Quando envio uma requisicao do tipo POST de Login
        Entao valido que recebo status 400 no response

        Exemplos:
        |Cenario| email | senha|
        |Usuario invalido|invalido@email.com|123456|
        |Senha invalida |aluna@email.com   |555555|
        |Sem email preenchido|     null             |123456|
        |Sem senha preenchida|aluno@email.com   |  null    |