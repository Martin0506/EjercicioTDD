package edu.unisabana.dyas.tdd;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    // Simulación de una base de datos de personas registradas
    private Map<Integer, Person> registeredVoters = new HashMap<>();

    public RegisterResult registerVoter(Person person) {
        // Verificar si la persona está fallecida
        if (!person.isAlive()) {
            if (registeredVoters.containsKey(person.getId())) {
                return RegisterResult.DECEASED_AFTER_REGISTRATION;
            } else {
                return RegisterResult.DEAD;
            }
        }

        // Verificar si la persona es menor de edad
        if (person.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si el género está especificado
        if (person.getGender() == null) {
            return RegisterResult.NO_GENDER;
        }

        // Verificar si ya está registrada
        if (registeredVoters.containsKey(person.getId())) {
            Person registeredPerson = registeredVoters.get(person.getId());

            // Comparar los datos de la persona registrada con la nueva persona
            if (!registeredPerson.equals(person)) {
                return RegisterResult.DUPLICATE_ID_DIFFERENT_INFO; // Mismo ID pero diferente información
            }

            return RegisterResult.DUPLICATED; // Mismo ID y misma información
        }

        // Si pasa todas las validaciones, la registramos
        registeredVoters.put( person.getId(), person);
        return RegisterResult.VALID;
    }
}


