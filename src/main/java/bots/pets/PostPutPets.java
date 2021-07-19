package bots.pets;

import helpers.ReadFromPom;
import io.restassured.RestAssured;
import mapper.postRegister.Category;
import mapper.postRegister.PetsRequestResponse;
import mapper.postRegister.Tags;

import static helpers.endpointsPath.PET_SERVICE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostPutPets {

    public PetsRequestResponse petsRequestResponse(int id, int categoryId, String categoryName, String name, String photoUrls,
                                               int tagsId, String tagsName, String status) {

        List<String> photoUrlsList = new ArrayList<String>();
        photoUrlsList.add(photoUrls);

        List<Tags> tagsList = new ArrayList<Tags>();
        tagsList.add(Tags.builder().withName(tagsName).withId(tagsId).createInstance());


        return PetsRequestResponse.builder().withId(id).withCategory(Category.builder().withId(categoryId).withName(categoryName)
                .createInstance()).withName(name).withPhotoUrls(photoUrlsList).withTags(tagsList).withStatus(status
        ).createInstance();
    }

    public PetsRequestResponse PostRets(int id, int categoryId, String categoryName, String name, String photoUrls,
                                             int tagsId, String tagsName, String status) throws IOException {

        ReadFromPom readFromPom = new ReadFromPom();
        final PetsRequestResponse request = petsRequestResponse(id, categoryId,categoryName,name, photoUrls, tagsId, tagsName, status);
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post(PET_SERVICE).then().extract().as(PetsRequestResponse.class);

    }

    public PetsRequestResponse PutPets(int id, int categoryId, String categoryName, String name, String photoUrls,
                                        int tagsId, String tagsName, String status) throws IOException {

        ReadFromPom readFromPom = new ReadFromPom();
        final PetsRequestResponse request = petsRequestResponse(id, categoryId,categoryName,name, photoUrls, tagsId, tagsName, status);
        RestAssured.baseURI = readFromPom.getPropertyFomPom("BaseURL");
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .put(PET_SERVICE).then().extract().as(PetsRequestResponse.class);

    }

}
