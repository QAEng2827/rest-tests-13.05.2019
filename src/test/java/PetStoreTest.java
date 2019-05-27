import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

public class PetStoreTest {
    static {
        RestAssured.baseURI = Config.BASE_URI;
    }

    private enum Status {
        AVALABLE,
        PENDING,
        SOLD
    }

    @Test
    public void getPetIdTest() {

        int petId = 27;

        //составляем запрос, парметры берем из строки, котоая была в постмене. используем паттерн-билдер
        RestAssured.given()

                .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет
    }

    @Test
    public void getPetByStatusTest() {
        for (Status status : Status.values()) {

            RestAssured.given()
                    .log().uri()
                    .param("status", status)
                    .get(Config.GET_PET_BY_STATUSE)
                    .then()
                    .log().all()
                    .statusCode(200);//  пр

        }
    }

    @Test
    public void createPetTest() {
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RestAssured.given()
                .log().uri()
                // .header("Content-Type", "application/json")
                .contentType("application/json")//  равнозначна предыдущей
                .body(requestBody)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deletePetIdTest() {
        int petId = 27;
        RestAssured.given()
                .log().uri()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
    }

}
