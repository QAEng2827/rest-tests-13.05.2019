package petstore.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import petstore.endpoints.StoreEndpoint;
import petstore.models.StoreOrderModel;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class StoreOrderTest {
    private StoreEndpoint storeEndpoint = new StoreEndpoint();
    private Date shipDate = new Date();
    private StoreOrderModel storeOrderModel;

    //private int id = 9;
   // private int petId = 28;
  //  private int quantity = 1;
    //  private Date shipDate;
  //  private String status;
   private boolean complete;

    @Before
    public void preCondition() {
        StoreOrderModel storeOrderModel = new StoreOrderModel(
                9,
                28,
                1,
                shipDate.getTime(),
                "AVALABLE",
                false

        );
        storeEndpoint
                .createStoreOrder(storeOrderModel)
                .statusCode(200);
    }

    @After
    public void postCondition() {
        storeEndpoint
                .deleteStoreOrder(storeOrderModel.getId())
                .statusCode(200);
    }

    @Test
    public void storeOrderTest() {
        storeEndpoint
                .getStoreOrderById(storeOrderModel.getId())
                .statusCode(200)
                .assertThat()
                .body("petId", equalTo(storeOrderModel.getPetId())

                .body("quantity", equalTo(storeOrderModel.getQuantity())
                .body("shipDate", equalTo(storeOrderModel.getShipDate())
                .body("status", equalTo(storeOrderModel.getStatus())
                .body("complete", equalTo(complete))
        ;


    }

}
