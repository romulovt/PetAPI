package com.petapi.qa.tasks;

import com.petapi.qa.models.Pet;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrarPet implements Task {

    private final Pet pet;

    public RegistrarPet(Pet pet){
        this.pet = pet;
    }

    public static Performable conInformacion(Pet pet){
        return instrumented(RegistrarPet.class,pet);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/pet").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(pet)
                )
        );
    }
}
