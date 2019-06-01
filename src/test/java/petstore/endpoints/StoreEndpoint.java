package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import petstore.models.StoreOrderModel;

public class StoreEndpoint {


    private RequestSpecification given() {
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
                .log().uri();
    }

    public ValidatableResponse getStoreInventory() {
        return given()
                .get(Config.GET_STORE_INVENTORY)
                .then()
                .log().all();

    }


    public ValidatableResponse createStoreOrder(StoreOrderModel storeOrderModel) {
        return given()
                .body(storeOrderModel)
                .post(Config.CREATE_ORDER)
                .then()
                .log().all();
    }


    public ValidatableResponse deleteStoreOrder(int orderId) {
        return  given()

                .delete(Config.DELETE_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }

    public ValidatableResponse getStoreOrderById(int orderId) {

        return given()
                .get(Config.GET_ORDER_BY_ID, orderId)
                .then()
                .log().all();
    }
}
