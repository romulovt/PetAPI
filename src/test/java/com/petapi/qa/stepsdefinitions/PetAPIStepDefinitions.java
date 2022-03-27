package com.petapi.qa.stepsdefinitions;

import com.petapi.qa.models.Category;
import com.petapi.qa.models.Pet;
import com.petapi.qa.models.Tag;
import com.petapi.qa.questions.CodigoRespuesta;
import com.petapi.qa.tasks.ActualizarPet;
import com.petapi.qa.tasks.GetPet;
import com.petapi.qa.tasks.RegistrarPet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetAPIStepDefinitions {

    private static final String restApiUrl="https://petstore.swagger.io/v2";

    private Actor luis = Actor.named("luis");
    private Pet pet = null;
    private Category category = null;
    private Tag tag = null;

    /**
     * Agregar una mascota
     * **/
    @Given("se tiene el endpoind para el POST de Pet")
    public void seTieneElEndpoindParaElPOSTDePet() {
        luis.whoCan(CallAnApi.at(restApiUrl));
    }

    @When("se establece el cuerpo del request")
    public void seEstableceElCuerpoDelRequest() {

        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add("string");

        category = new Category();
        category.setId(0);
        category.setName("string");

        tag = new Tag();
        tag.setId(0);
        tag.setName("string");

        pet = new Pet();
        pet.setId(0);
        pet.setCategory(category);
        pet.setName("TOTA");
        pet.setPhotoUrls(photoUrls);
        pet.setStatus("available");
    }

    @When("se envia una HTTP request POST")
    public void seEnviaUnaHTTPRequestPOST() {
        luis.attemptsTo(
                RegistrarPet.conInformacion(pet)
        );
    }
    @Then("se recibe el codigo {int} de respuesta valida")
    public void seRecibeElCodigoDeRespuestaValida(Integer int1) {
        luis.should(
                seeThat("el codigo de respuesta", CodigoRespuesta.is(), equalTo(int1))
        );
    }

    /**
     * Obtener una mascota existente
     * **/
    @Given("se tiene el endpoind para el GET de Pet")
    public void seTieneElEndpoindParaElGETDePet() {
        luis.whoCan(CallAnApi.at(restApiUrl));
    }
    @When("se envia una HTTP request GET con el id del Pet")
    public void seEnviaUnaHTTPRequestGETConElIdDelPet() {
        long petId = 9223372016854948018L;
        luis.attemptsTo(
                GetPet.fromPet(petId)
        );
    }

    /**
     * Modificar una mascota existente
     * **/
    @Given("se tiene el endpoind para el PUT de Pet")
    public void seTieneElEndpoindParaElPUTDePet() {
        luis.whoCan(CallAnApi.at(restApiUrl));
    }

    @When("se estable el cuerpo del request")
    public void seEstableElCuerpoDelRequest() {
        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add("https://");

        category = new Category();
        category.setId(0);
        category.setName("string");

        tag = new Tag();
        tag.setId(0);
        tag.setName("string");

        pet = new Pet();
        pet.setId(9223372016854948018L);
        pet.setCategory(category);
        pet.setName("TOTA LA GORDOTA");
        pet.setPhotoUrls(photoUrls);
        pet.setStatus("available");
    }
    @When("se envia una HTTP request PUT")
    public void seEnviaUnaHTTPRequestPUT() {
        luis.attemptsTo(
                ActualizarPet.conInformacion(pet)
        );
    }

}
