import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanTest {

    @Test
    public void bodyRequest() {
        // Given - When - Then
// Предусловия
        String text = "Hello World!";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(text) // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", Matchers.equalTo(text))
        ;
    }
}
