package petstore.tests;

import org.junit.Test;
import petstore.endpoints.StoreEndpoint;
import petstore.models.StoreOrderModel;
import petstore.models.TagModel;

import java.util.Date;

public class StoreTest {
    private StoreEndpoint storeEndpoint = new StoreEndpoint();
    Date shipDate = new Date();

    private int Id = 9;
    private int petId =28;
    private int quantity = 1;
  //  private Date shipDate;
    private String status ;
    private boolean complete;

    @Test
    public void getStoreInventoryTest(){
         storeEndpoint
                  .getStoreInventory()
                 .statusCode(200);

    }

    @Test
    public void createPetTest() {


        StoreOrderModel storeOrderModel = new StoreOrderModel(
                Id,
                petId,
                quantity ,
                shipDate.getTime(),
                "AVALABLE",
                false
        );

        storeEndpoint
                .createStoreOrder(storeOrderModel)
                .statusCode(200);

    }



@Test
    public void getSrireOrderByIDTest(){
        storeEndpoint
                .getStoreOrderById(Id)
                .statusCode(200);

}

    @Test
    public void deleteStoreOrderTest(){
        storeEndpoint
                .deleteStoreOrder(Id)
                .statusCode(200);
    }

}
