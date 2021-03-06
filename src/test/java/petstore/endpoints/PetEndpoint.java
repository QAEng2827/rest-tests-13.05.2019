package petstore.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import petstore.endpoints.Config;
import petstore.models.PetModel;

import java.io.File;


public class PetEndpoint {
Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private RequestSpecification given() {
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();// включить логирование, если что-то не сработало
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .contentType("application/json")
               // .log().uri()
        ;
    }


   @Step
   public ValidatableResponse getPetById(int petId) {
        log.info("Execoting: getPetById");
        return given()
                .get(Config.GET_PET_BY_ID, petId)
                .then();
                //.log().all();
    }

    public enum Status {
        AVALABLE,
        PENDING,
        SOLD
    }
    @Step
    public ValidatableResponse getPetByStatus( Status status) {

            return   given()
                    .param("status", status)
                    .get(Config.GET_PET_BY_STATUSE)
                    .then();
                  //.log().all();
        }
    @Step
    public ValidatableResponse createPet(PetModel petModel){
                return  given()
                        .body(petModel)
                        .post(Config.CREATE_PET)
                        .then();
                      //  .log().all();


    }
    @Step
    public ValidatableResponse deletePet(int petId){
        return given()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then();
                //.log().all();
    }
    @Step
    public ValidatableResponse updatePet(PetModel petModel){
        return  given()
                .body(petModel)
                .post(Config.UPDATE_PET)
                .then();
               // .log().all();


    }
    @Step
    public ValidatableResponse uploadPetImage(int petId, File file){
        return  given()
                .contentType("multipart/form-data")
                .multiPart(file)
                .post(Config.UPLOAD_IMAGE_PET, petId)
                .then();// , нужен, чтоб потом получить responce

    }

}
