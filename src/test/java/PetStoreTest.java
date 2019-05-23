import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

public class PetStoreTest {
   static {
    RestAssured.baseURI = Config.BASE_URI;
   }
    private enum Status{
       AVALABLE,
        PENDING,
        SOLD
    }

    @Test
    public void getPetIdTest(){

        int petId = 3;

        //составляем запрос, парметры берем из строки, котоая была в постмене. используем паттерн-билдер
     RestAssured.given()

               // .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет
    }

    @Test
    public void getPetByStatus(){

    RestAssured.given()
                .log().uri()
            .param("status",Status.AVALABLE)
                .get(Config.GET_PET_BY_STATUSE)
                .then()
                .log().all()
                .statusCode(200);//  пр

    }

}
