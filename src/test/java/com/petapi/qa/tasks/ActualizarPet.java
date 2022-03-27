package com.petapi.qa.tasks;

import com.petapi.qa.models.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarPet implements Task {

    private final Pet pet;

    public ActualizarPet(Pet pet){
        this.pet = pet;
    }

    public static Performable conInformacion(Pet pet){
        return instrumented(ActualizarPet.class,pet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/pet").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(pet)
                )
        );
    }
}
