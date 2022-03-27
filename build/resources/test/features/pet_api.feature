#Autor: Verde Trujillo Luis R.

  Feature: Probar los metodos POST, GET y PUT
    para garantizar el correcto funcionamiento de

  Scenario: Agregar una mascota
    Given se tiene el endpoind para el POST de Pet
    When se establece el cuerpo del request
    And se envia una HTTP request POST
    Then se recibe el codigo 200 de respuesta valida

  Scenario: Obtener una mascota existente
    Given se tiene el endpoind para el GET de Pet
    When se envia una HTTP request GET con el id del Pet
    Then se recibe el codigo 200 de respuesta valida

  Scenario: Modificar una mascota existente
    Given se tiene el endpoind para el PUT de Pet
    When se estable el cuerpo del request
    And se envia una HTTP request PUT
    Then se recibe el codigo 200 de respuesta valida