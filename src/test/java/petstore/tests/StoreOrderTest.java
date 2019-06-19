package petstore.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.StoreEndpoint;
import petstore.models.StoreOrderModel;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

//@Concurrent
@RunWith(SerenityRunner.class)
public class StoreOrderTest {
    @Steps
    private StoreEndpoint storeEndpoint;
    private Date shipDate = new Date();
    private StoreOrderModel storeOrderModel;



    @Before
    public void preCondition() {
        storeOrderModel = new StoreOrderModel(
                9,
                28,
                1,
                shipDate.getTime(),
                "AVALABLE",
                false

        );


    }

    @After
    public void postCondition() {
        storeEndpoint
                .deleteStoreOrder(storeOrderModel.getId())
                .statusCode(200);
    }

    @Test
    public void storeOrderTest() throws InterruptedException {

            Thread.sleep(5000);

//        storeOrderModel = new StoreOrderModel(
//                19,
//                289,
//                1,
//                shipDate.getTime(),
//                "AVALABLE",
//                false
//
//        );

        storeEndpoint
                .createStoreOrder(storeOrderModel)
                .statusCode(200);
    }

    @Test
    public void getStoreOrderByIdTest() throws InterruptedException {

            Thread.sleep(5000);


//        storeOrderModel = new StoreOrderModel(
//                19,
//                29,
//                1,
//                shipDate.getTime(),
//                "AVALABLE",
//                false
//
//        );
//        storeEndpoint
//
//                .createStoreOrder(storeOrderModel)
//                .statusCode(200);

        storeEndpoint
                .getStoreOrderById(storeOrderModel.getId())
                .statusCode(200)
                .assertThat()
                .body("petId", equalTo(storeOrderModel.getPetId()))

                .body("quantity", equalTo(storeOrderModel.getQuantity()))
               // .body("shipDate", equalTo(storeOrderModel.getShipDate()))
                .body("status", equalTo(storeOrderModel.getStatus()))
                .body("complete", equalTo(storeOrderModel.isComplete()))
        ;


    }

}
