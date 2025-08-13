package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /**
     * 1.	TODO: Find everyone that has firstName: “Erik” using findMany().
     */
    public static void exercise1(String message) {
        System.out.println("----------- Exercises class -> Exercise 1 -----------");

        System.out.println(message);
        //Write your code here

        Predicate<Person> pred = p -> p.getFirstName().equals("Erik");
        List<Person> people = storage.findMany(pred);

        people.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 1 -----------");
    }

    /**
     * 2.	TODO: Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        //Write your code here

        System.out.println("----------- Exercises class -> Exercise 2 -----------");

        Predicate<Person> genderFilter = s -> s.getGender() == Gender.FEMALE;

        List<Person> list = storage.findMany(genderFilter);

        list.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 2 -----------");

    }

    /**
     * 3.	TODO: Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println("----------- Exercises class -> Exercise 3 -----------");

        Predicate<Person> youngsters = s -> s.getBirthDate().isAfter(LocalDate.parse("2000-01-01"));

        List<Person> list = storage.findMany(youngsters);

        list.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 3 -----------");
    }

    /**
     * 4.	TODO: Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println("----------- Exercises class -> Exercise 4 -----------");

        Predicate<Person> p = s -> s.getId() == 123;

        Person person = storage.findOne(p);

        System.out.println(person);

        System.out.println("----------- END Exercises class -> Exercise 4 -----------");

    }

    /**
     * 5.	TODO: Find the Person that has an id of 456 and convert to String with following content:
     * “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println("----------- Exercises class -> Exercise 5 -----------");

        Predicate<Person> p = s -> s.getId() == 457;
        Function<Person, String> personToString = person -> "Name: " + person.getFirstName()+" " +person.getLastName() +
                " born " + person.getBirthDate();


        System.out.println(storage.findOneAndMapToString(p, personToString));

        System.out.println("----------- END Exercises class -> Exercise 5 -----------");
    }

    /**
     * 6.	TODO: Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println("----------- Exercises class -> Exercise 6 -----------");

        Predicate<Person> nameStartsWithPredicate = p -> p.getGender() == Gender.MALE && p.getFirstName().startsWith("E");
        Function<Person, String> personToStringFunc = person -> "Name: " + person.getFirstName()+" " +person.getLastName() +
                " born " + person.getBirthDate();

        List<String> list = storage.findManyAndMapEachToString(nameStartsWithPredicate, personToStringFunc);

        list.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 6 -----------");

    }

    /**
     * 7.	TODO: Find all people who are below age of 10 and convert them to a String like this:
     * “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println("----------- Exercises class -> Exercise 7 -----------");

        Predicate<Person> peopleUnderAge10 = s -> Period.between(s.getBirthDate(), LocalDate.now()).getYears() < 10;

        Function<Person, String> personToStringFunc = person -> person.getFirstName()+" " +person.getLastName() +
                " " +Period.between(person.getBirthDate(), LocalDate.now()).getYears() + " years old";

        List<String> list = storage.findManyAndMapEachToString(peopleUnderAge10, personToStringFunc);
        list.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 7 -----------");

    }

    /**
     * 8.	TODO: Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println("----------- Exercises class -> Exercise 8 -----------");

        Predicate<Person> firstNamePredicate = p -> p.getFirstName().equals("Ulf");
        Consumer<Person> personConsumer = person -> System.out.println(person);
        storage.findAndDo(firstNamePredicate, personConsumer);

        System.out.println("----------- END Exercises class -> Exercise 8 -----------");

    }

    /**
     * 9.	TODO: Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println("----------- Exercises class -> Exercise 9 -----------");

        Predicate<Person> pred  = p -> p.getLastName().toLowerCase().contains(p.getFirstName().toLowerCase());
        Consumer<Person> personConsumer = s -> System.out.println(s);

        storage.findAndDo(pred, personConsumer);

        System.out.println("----------- END Exercises class -> Exercise 9 -----------");
    }

    /**
     * 10.	TODO: Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println("----------- Exercises class -> Exercise 10 -----------");

        Predicate<Person> pred = p -> p.getFirstName().equalsIgnoreCase(String.valueOf(new StringBuilder(p.getFirstName()).reverse()));
        Consumer<Person> personConsumer = s -> System.out.println(s.getFirstName() + " " +s.getLastName());

        storage.findAndDo(pred, personConsumer);

        System.out.println("----------- END Exercises class -> Exercise 10 -----------");

    }

    /**
     * 11.	TODO: Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println("----------- Exercises class -> Exercise 11 -----------");

        Predicate<Person> namePredicate = s -> s.getFirstName().startsWith("A");

        Comparator<Person> bdayComparator = Comparator.comparing(Person::getBirthDate);

        List<Person> list = storage.findAndSort(namePredicate, bdayComparator);

        list.forEach(System.out::println);


        System.out.println("----------- END Exercises class -> Exercise 11 -----------");
    }

    /**
     * 12.	TODO: Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println("----------- Exercises class -> Exercise 12 -----------");

        Predicate<Person> pred = s -> s.getBirthDate().isBefore(LocalDate.ofYearDay(1950, 1));

        Comparator<Person> comparator = (p1, p2) -> p2.getBirthDate().compareTo(p1.getBirthDate());

        List<Person> list = storage.findAndSort(pred, comparator);

        list.forEach(System.out::println);

        System.out.println("----------- END Exercises class -> Exercise 12 -----------");
    }

    /**
     * 13.	TODO: Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println("----------- Exercises class -> Exercise 13 -----------");

        Comparator<Person> comparator = (p1, p2) -> {
            if (p1.getLastName().equalsIgnoreCase(p2.getLastName())) {
                if (p1.getFirstName().equalsIgnoreCase(p2.getFirstName())) {
                    return p1.getBirthDate().compareTo(p2.getBirthDate());
                } else {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
            }
            return p1.getLastName().compareTo(p2.getLastName());
        };

        List<Person> list = storage.findAndSort(comparator);

        list.forEach(System.out::println);
        System.out.println("----------- END Exercises class -> Exercise 13 -----------");
    }

}