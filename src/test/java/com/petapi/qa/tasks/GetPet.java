package com.petapi.qa.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.math.BigInteger;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPet implements Task {

    public final long petId;

    public GetPet(long petId){
        this.petId = petId;
    }

    public static final Performable fromPet(long petId){
        return instrumented(GetPet.class,petId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/"+petId).with(
                        requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                )
        );
    }
}
