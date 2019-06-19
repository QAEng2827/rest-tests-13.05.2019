package petstore.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.core.Is.is;

public class PetImageEndpoint {

    private RequestSpecification given() {

        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();// включить логирование, если что-то не сработало
        return SerenityRest.given()
                .baseUri(Config.BASE_URI)
                .accept("application/json")
                .contentType("multipart/form-data");

                // .log().uri()                ;
    }

//    @Step
//    public ValidatableResponse uploadImagePet(int petId, String fileImageName, String metadata) {
//        File file = new File("./"+fileImageName);
//
//        String message = "additionalMetadata: " + metadata + "\n" +
//                "File uploaded to ./" + fileImageName + ", " + file.length() + " bytes";
//
//    //    log.info("Execoting: getPetById");
//        return given()
//                .multiPart(file)
//                .multiPart("additionalMetadata", metadata)
//                .get(Config.UPLOAD_IMAGE_PET, petId)
//                .then()
//                .log().all()
//                .body("message", is(message));
//    }
@Step
    public ValidatableResponse uploadImagePet(int petId, String fileName) {

        File file = new File("./" + fileName);
        String checkMessage = "additionalMetadata: null" + "\n" +
                "File uploaded to ./" + fileName + ", " + file.length() + " bytes";


        return given()
                .multiPart(file)
                .multiPart("additionalMetadata", "null")
                .post(Config.UPLOAD_IMAGE_PET, petId)
                .then().log().all()
                .body("message", is(checkMessage))
                .statusCode(200);


    }

}
