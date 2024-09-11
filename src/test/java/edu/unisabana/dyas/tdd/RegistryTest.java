package edu.unisabana.dyas.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;


public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.VALID, result);
    }

    
    // Caso 1: Persona mayor de edad válida
    @Test
    public void testAdultCanRegister() {
        Person adult = new Person("María", 987654, 30, Gender.FEMALE, true);
        Registry registry = new Registry();
        RegisterResult result = registry.registerVoter(adult);
        assertEquals(RegisterResult.VALID, result);
    }

    // caso 2: Persona mayor de edad pero fallecida
    @Test
    public void testDeceasedPersonCannotRegister() {
        Person deceasedPerson = new Person("Miguel", 123789, 65, Gender.MALE, false); // Fallecida
        Registry registry = new Registry();
        RegisterResult result = registry.registerVoter(deceasedPerson);
        assertEquals(RegisterResult.DECEASED, result);
    }

    // caso 3: Persona con género no especificado
    @Test
    public void testPersonWithNoGenderCannotRegister() {
        Person noGenderPerson = new Person("Santiago", 123567, 30, null, true); 
        Registry registry = new Registry();
        RegisterResult result = registry.registerVoter(noGenderPerson);
        assertEquals(RegisterResult.NO_GENDER, result);
    }

    // caso 4: Persona con ID duplicada pero información diferente
    @Test
    public void testDuplicateIdWithDifferentInformationCannotRegister() {
        Person person1 = new Person("Carlos", 999999, 40, Gender.MALE, true);
        Person person2 = new Person("Carla", 999999, 35, Gender.FEMALE, true); 

        Registry registry = new Registry();
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        assertEquals(RegisterResult.DUPLICATE_ID_DIFFERENT_INFO, result);
    }

    // caso 5: Persona registrada y luego fallecida
    @Test
    public void testRegisteredPersonDeceasedCannotRegisterAgain() {
        Person person = new Person("Laura", 555555, 50, Gender.FEMALE, true);
        Registry registry = new Registry();
        registry.registerVoter(person); // Persona registrada

        // La persona fallece
        person.setAlive(false);
        RegisterResult result = registry.registerVoter(person);
        assertEquals(RegisterResult.DECEASED_AFTER_REGISTRATION, result);
    }

    // caso 6: persona con ID válido y edad correcta, pero fallecida después del registro
    @Test
    public void testDeceasedAfterRegistration() {
    Registry registry = new Registry();
    
    // Registrar una persona con ID válido y edad correcta
    Person person9 = new Person("Ricardo", 34567890, 50, Gender.MALE, true);
    RegisterResult result = registry.registerVoter(person9);
    assertEquals(RegisterResult.VALID, result);
    
    // Simular que la persona fallece después del registro
    Person person9AfterDeath = new Person("Ricardo", 34567890, 50, Gender.MALE, false);
    result = registry.registerVoter(person9AfterDeath);
    assertEquals(RegisterResult.DECEASED_AFTER_REGISTRATION, result);
    }
}
