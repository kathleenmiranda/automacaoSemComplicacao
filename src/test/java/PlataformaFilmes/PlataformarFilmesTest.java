package PlataformaFilmes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import utils.RestUltils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlataformarFilmesTest {

    static String token;

    @BeforeAll
    public static void validarLoginMap(){
        RestUltils.setBaseURI("http://localhost:8080/");

        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha","123456");

        Response response = RestUltils.post(map, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        token = response.jsonPath().get("token");
    }

    @Test
    public void validarLogin(){
        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@email.com");
        map.put("senha","123456");

        Response response = RestUltils.post(map, ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        token = response.jsonPath().get("token");
    }

    @Test
    public void validarLoginInvalido(){
        Map<String, String> map = new HashMap<>();
        map.put("email", "aluno@aluno.com");
        map.put("senha","123456");

        Response response = RestUltils.post(map, ContentType.JSON, "auth");
        assertEquals(400, response.statusCode());
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " +token);

        Response response = RestUltils.getSemLog(headers, "categorias");

        assertEquals(200, response.statusCode());

        assertEquals("Terror", response.jsonPath().get("tipo[2]"));
        List<String> listTipo = response.jsonPath().getList("tipo");
        assertTrue(listTipo.contains("Terror"));
    }

    public static Stream<Arguments> loginSenhaUsuarios(){
        return Stream.of(
                Arguments.of("aluno@email.com", "123456"),
                Arguments.of("emailInvalido@teste.com", "1234567")
        );
    }






}
