package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import petstore.models.StoreOrderModel;

public class StoreEndpoint {


    private RequestSpecification given() {
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }
    @Step
    public ValidatableResponse getStoreInventory() {
        return given()
                .get(Config.GET_STORE_INVENTORY)
                .then()
                .log().all();

    }

    @Step
    public ValidatableResponse createStoreOrder(StoreOrderModel storeOrderModel) {
        return given()
                .body(storeOrderModel)
                .post(Config.CREATE_ORDER)
                .then()
                .log().all();
    }

    @Step
    public ValidatableResponse deleteStoreOrder(int orderId) {
        return  given()

                .delete(Config.DELETE_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }
    @Step
    public ValidatableResponse getStoreOrderById(int orderId) {

        return given()
                .get(Config.GET_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }
}
