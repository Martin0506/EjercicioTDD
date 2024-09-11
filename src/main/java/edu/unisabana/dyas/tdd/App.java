package edu.unisabana.dyas.tdd;

public class App {
    public static void main(String[] args) {
        // Crear una instancia de Registry
        Registry registry = new Registry();
        
        // Crear y registrar una serie de personas para probar
        testPersonRegistration(registry);
    }
    
    private static void testPersonRegistration(Registry registry) {
        // Crear varias personas con diferentes características
        Person person1 = new Person("Mario", 12345678, 35, Gender.MALE, false);
        System.out.println("Registering Mario: " + registry.registerVoter(person1));

        Person person2 = new Person("Lucia", 23456789, 17, Gender.FEMALE, true);
        System.out.println("Registering Lucia: " + registry.registerVoter(person2));

        Person person3 = new Person("Carlos", 34567890, 22, null, true);
        System.out.println("Registering Carlos: " + registry.registerVoter(person3));

        Person person4 = new Person("Ana", 45678901, 40, Gender.FEMALE, true);
        System.out.println("Registering Ana: " + registry.registerVoter(person4));
        
        // Registrar la misma persona con información diferente
        Person person4Duplicate = new Person("Ana", 45678901, 41, Gender.FEMALE, true);
        System.out.println("Registering Ana again with different info: " + registry.registerVoter(person4Duplicate));
        
        Person person5 = new Person("Jorge", 56789012, 28, Gender.MALE, true);
        System.out.println("Registering Jorge: " + registry.registerVoter(person5));
        
        Person person5Duplicate = new Person("Jorge", 56789012, 28, Gender.MALE, true);
        System.out.println("Registering Jorge again with the same info: " + registry.registerVoter(person5Duplicate));
        
        // Registrar una persona con ID inválido (demasiado corto)
        Person person6 = new Person("Sandra", 12345, 30, Gender.FEMALE, true);
        System.out.println("Registering Sandra with short ID: " + registry.registerVoter(person6));
        
        // Registrar una persona con ID inválido (demasiado largo)
       // Person person7 = new Person("Pedro", 12345678910, 45, Gender.MALE, true);
        //System.out.println("Registering Pedro with long ID: " + registry.registerVoter(person7));
        
        // Registrar una persona con edad inválida
        Person person8 = new Person("Elena", 23456789, -5, Gender.FEMALE, false);
        System.out.println("Registering Elena with invalid age: " + registry.registerVoter(person8));
        
        // Registrar una persona que fallece después del registro
        Person person9 = new Person("Ricardo", 34567890, 50, Gender.MALE, true);
        System.out.println("Registering Ricardo: " + registry.registerVoter(person9));
        
        Person person9AfterDeath = new Person("Ricardo", 34567890, 50, Gender.MALE, false);
        System.out.println("Registering Ricardo again after death: " + registry.registerVoter(person9AfterDeath));
    }
}

