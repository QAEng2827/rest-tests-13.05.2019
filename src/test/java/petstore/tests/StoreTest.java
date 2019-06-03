package petstore.tests;

import org.junit.Test;
import petstore.endpoints.StoreEndpoint;
import petstore.models.StoreOrderModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreTest {
    private StoreEndpoint storeEndpoint = new StoreEndpoint();
    Date shipDate = new Date();
    private StoreOrderModel storeOrderModel;

    private int id = 9;
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
                id,
                petId,
                quantity ,
                shipDate.getTime(),
               // new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
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
                .getStoreOrderById(id)
                .statusCode(200);

}

    @Test
    public void deleteStoreOrderTest(){
        storeEndpoint
                .deleteStoreOrder(id)
                .statusCode(200);
    }

}
