package tests;

import bots.pets.DeletePets;
import bots.pets.PostPutPets;
import com.aventstack.extentreports.Status;
import helpers.ReadFromPropertiesFile;
import helpers.testExtender;
import io.restassured.response.Response;
import mapper.postRegister.PetsRequestResponse;
import mapper.postRegister.Tags;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class ExampleTestPets extends testExtender {

    static PostPutPets postPutPets = new PostPutPets();
    static DeletePets deletePet = new DeletePets();

    @Test
    public void PostPutDeletePets() throws IOException {
        test = extent.createTest("PostPutDeletePets");
        logger.info("PostPutDeletePets");
        test.log(Status.INFO, "PostPutDeletePets");
        ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();

        //Read all parameters from property file
        int id = readFromPropertiesFile.getId();
        String name = readFromPropertiesFile.getName();
        int categoryId = readFromPropertiesFile.getCategoryId();
        String categoryName = readFromPropertiesFile.getCategoryName();
        String photoUrl = readFromPropertiesFile.getPhotoUrl();
        int tagId = readFromPropertiesFile.getTagId();
        String tagName = readFromPropertiesFile.getTagName();
        String status = readFromPropertiesFile.getStatus();


        //POST Pets and verify the response
        PetsRequestResponse petsPostResponse = postPutPets.PostRets(id, categoryId, categoryName, name, photoUrl,
                tagId, tagName, status);


        Assert.assertEquals(String.format("Name is %s, but should be %s ",
                petsPostResponse.getName(), name),
                name,
                petsPostResponse.getName());

        Assert.assertEquals(String.format("Id is %s, but should be %s ",
                petsPostResponse.getId(), id),
                id,
                petsPostResponse.getId());

        Assert.assertEquals(String.format("PhotoUrl is %s, but should be %s ",
                petsPostResponse.getPhotoUrls().get(0), photoUrl),
                photoUrl,
                petsPostResponse.getPhotoUrls().get(0));

        Assert.assertEquals(String.format("TagName is %s, but should be %s ",
                petsPostResponse.getTags().get(0).getName(), tagName),
                tagName,
                petsPostResponse.getTags().get(0).getName());

        Assert.assertEquals(String.format("TagId is %s, but should be %s ",
                petsPostResponse.getTags().get(0).getId(), tagId),
                tagId,
                petsPostResponse.getTags().get(0).getId());

        Assert.assertEquals(String.format("Status is %s, but should be %s ",
                petsPostResponse.getStatus(), status),
                status,
                petsPostResponse.getStatus());


        logger.info("POST Pets Succesfully passed");
        test.log(Status.INFO, "POST Pets Succesfully passed");

        //Prepare values for PUT Pets Request (For this example we will edit only 3 parameters)
        String nameEdited = readFromPropertiesFile.getName() + "Edited";
        String categoryNameEdited = readFromPropertiesFile.getCategoryName() + "Edited";
        String tagNameEdited = readFromPropertiesFile.getTagName() + "Edited";


        // Call PUT Pets and verify the response
        PetsRequestResponse petsPutResponse = postPutPets.PutPets(id, categoryId, categoryNameEdited, nameEdited, photoUrl,
                tagId, tagNameEdited, status);



        Assert.assertEquals(String.format("Name is %s, but should be %s ",
                petsPutResponse.getName(), nameEdited),
                nameEdited,
                petsPutResponse.getName());

        logger.info("PUT Pets Succesfully passed");
        test.log(Status.INFO, "PUT Pets Succesfully passed");

        Set<String> collect = petsPutResponse.getTags().stream().map(Tags::getName).collect(Collectors.toSet());
        Assert.assertTrue("Specified Tag Name is not found in the response !!!", collect.contains(tagNameEdited));


        //Delete created Pet and assert the response
        Response deletePetResponse = deletePet.DeletePet(id);

        System.out.println(deletePetResponse.getStatusCode());

        Assert.assertEquals(String.format("Status code from Delete Pets is not 200. The returned staus is %s", deletePetResponse.getStatusCode())
                , deletePetResponse.getStatusCode(), 200);

        Assert.assertEquals(String.format("Response message is not correct: The message response is : %s", deletePetResponse.getBody().print())
                , deletePetResponse.getBody().print(), "Pet deleted");

        logger.info("DELETE Pets Succesfully passed");
        test.log(Status.INFO, "DELETE Pets Succesfully passed");
    }


}
