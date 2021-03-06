package weather;

import groovy.json.StringEscapeUtils;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
@Concurrent
@RunWith(SerenityRunner.class)
public class WeatherTest {
 //   @Steps
   @Test
    public void getWeatherPerCityTest() {
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();

        String cityName="Ternopil";
        RestAssured.baseURI = "https://pinformer.sinoptik.ua";
        //RestAssured.basePath = "/search.php";// можно вставить в . basePath или .get
SerenityRest.setDefaultBasePath("/search.php");
        //составляем запрос, парметры берем из строки, котоая была в постмене. используем паттерн-билдер
        ValidatableResponse responseCityIndex = SerenityRest.given()
                .param("lang", "ua")
                .param("return_id", "1")
                .param("q", cityName)
                .log().uri()
                .get()
                .then()
                .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет


        // более компактный способ
        String responseStr = responseCityIndex.extract().asString();
        String cityId = responseStr.substring(responseStr.lastIndexOf("|") + 1);

        System.out.println(cityId);


        /* add second reguest to get Weather in City by it's id
        // https://pinformer.sinoptik.ua/pinformer4.php?type=js&lang=ua&id=303014487
        */

        // RestAssured.basePath = "/pinformer4.php";
        // RestAssured.baseURI = "https://pinformer.sinoptik.ua";
        //составляем запрос, парметры берем из строки, котоая была в постмене
        ValidatableResponse responseCityId = SerenityRest.given()
                .basePath("/pinformer4.php")
                .param("type", "js")
                .param("lang", "en")
                .param("id", cityId)
                // .log().uri()
                .get()
                .then()
                .log().all()
                .statusCode(200)//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет
                .body("'{pcity}'", is(not(1)))//  JSON path wit hamprest matchers, можно проверить, изменился ключ или нет
                .body("any {it.key=='{pcity}'}", is(true)); // Groovy path with  hamprest matchers?  проверяется присутствие ключа в JSON
            System.out.println(responseCityId.extract().path("'{pcity}'"));

    }


}
