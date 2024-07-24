package steps;

import groovy.lang.GString;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.RestUltils;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

public class LoginSteps {

    String url = "http://localhost:8080/";

    @Dado("que tenha uma playload valido da API de Login")
    public void queTenhaUmaPlayloadValidoDaAPIDeLogin() {
        LoginMap.initLogin();
        RestUltils.setBaseURI(url);
    }

    @Dado("que tenha um payload da API com as seguintes informacoes")
    public void queTenhaUmPayloadDaAPIComAsSeguintesInformacoes(Map<String, String> map) {
        LoginMap.initLogin();
        RestUltils.setBaseURI(url);
        LoginMap.getLogin().putAll(map);
    }

    @Quando("envio uma requisicao do tipo POST de Login")
    public void envioUmaRequisicaoDoTipoPOSTDeLogin() {
        RestUltils.post(LoginMap.getLogin(), ContentType.JSON,"/auth");

    }

    @Entao("armazeno o token que recebo do response de Login")
    public void armazenoOTokenQueReceboDoResponseDeLogin() {
        LoginMap.token = RestUltils.getResponse().jsonPath().get("token");
    }
}
