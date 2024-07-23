#language:pt


  Funcionalidade: Realizar Login
    Testes da API de login

    Cenario: Realizar login com sucesso
      Dado que tenha uma playload valido da API de Login
      Quando envio uma requisicao do tipo POST de Login
      Entao valido que recebo status 200 no response
      E armazeno o token que recebo do response de Login

      Cenario: Realizar Login com ususario invalido
        Dado que tenha um payload da API com as seguintes informacoes
          | email | invalido@emai.com |
          | senha | 123456            |
        Quando envio uma requisicao do tipo POST de Login
        Entao valido que recebo status 400 no response