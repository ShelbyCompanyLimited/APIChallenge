package bots.pets;

import helpers.ReadFromPom;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;


import static helpers.endpointsPath.PET_SERVICE_DELETE;

public class DeletePets {

    public Response DeletePet(int id) throws IOException {

        ReadFromPom readFromPom = new ReadFromPom();
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("pet", id)
                .when()
                .delete(PET_SERVICE_DELETE).then().extract().response();

    }

}
