package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

/**import static jdk.internal.org.jline.utils.Colors.s;*/

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /**
     * 1.	TODO: Find everyone that has firstName: “Erik” using findMany().
     */
    public static void exercise1(String message) {
        System.out.println(message);

        storage.findMany(person -> person.getFirstName().equalsIgnoreCase("Erik"))
                .forEach(System.out::println);


        System.out.println("----------------------");

    }


        /**
         * 2.	TODO: Find all females in the collection using findMany().
         */
        public static void exercise2 (String message){
            System.out.println(message);

            storage.findMany(person -> person.getGender()==Gender.FEMALE)
                            .forEach(System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 3.	TODO: Find all who are born after (and including) 2000-01-01 using findMany().
         */
        public static void exercise3 (String message){
            System.out.println(message);

            storage.findMany(person -> person.getBirthDate().isAfter(LocalDate.of(2000,01,01))
                            || person.getBirthDate().isEqual(LocalDate.of(2000, 01, 01)))
                    .forEach(System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 4.	TODO: Find the Person that has an id of 123 using findOne().
         */
        public static void exercise4 (String message){
            System.out.println(message);

            System.out.println(storage.findOne(person -> person.getId() == 123));

            System.out.println("----------------------");
        }

        /**
         * 5.	TODO: Find the Person that has an id of 456 and convert to String with following content:
         * “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
         */
        public static void exercise5 (String message){
            System.out.println(message);

            System.out.println(storage.findOneAndMapToString(person -> person.getId()==456,
                    person -> person.getFirstName()
                            +" "+person.getLastName()
                    +" "+ "born"
                    +" "+ person.getBirthDate()));

            System.out.println("----------------------");
        }

        /**
         * 6.	TODO: Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
         */
        public static void exercise6 (String message){
            System.out.println(message);

            storage.findManyAndMapEachToString(person -> person.getGender()==Gender.MALE
            && person.getFirstName().startsWith("E"),
                    person -> person.getFirstName()
                            +" "+person.getLastName()
                            +" "+ "born"
                            +" "+ person.getBirthDate())
                            .forEach(System.out::println);


            System.out.println("----------------------");
        }

        /**
         * 7.	TODO: Find all people who are below age of 10 and convert them to a String like this:
         * “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
         */
        public static void exercise7 (String message){
            System.out.println(message);

            storage.findManyAndMapEachToString(person -> Period.between(person.getBirthDate(), LocalDate.now())
                    .getYears() < 10,
                 person -> {
                int age = Period.between(person.getBirthDate(), LocalDate.now()).getYears();
                        return person.getFirstName()+" " +person.getLastName()+" "+ age + " "+"years";})
                            .forEach(System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 8.	TODO: Using findAndDo() print out all people with firstName “Ulf”.
         */
        public static void exercise8 (String message){
            System.out.println(message);

            storage.findAndDo(person -> person.getFirstName().equalsIgnoreCase("Ulf"),
                    System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 9.	TODO: Using findAndDo() print out everyone who have their lastName contain their firstName.
         */
        public static void exercise9 (String message){
            System.out.println(message);

            storage.findAndDo(person -> person.getLastName().contains(person.getFirstName()),
                System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 10.	TODO: Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
         */
        public static void exercise10 (String message){
            System.out.println(message);

            storage.findAndDo(person -> person.getFirstName().equalsIgnoreCase(new StringBuilder(person.getFirstName()).reverse()
                            .toString()),
                    person -> System.out.println(person.getFirstName()+" "
                    + person.getLastName()));

            System.out.println("----------------------");
        }

        /**
         * 11.	TODO: Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
         */
        public static void exercise11 (String message){
            System.out.println(message);

            storage.findAndSort(person -> person.getFirstName().startsWith("A"),
                Comparator.comparing(person -> person.getBirthDate()))
                .forEach(System.out::println);

            System.out.println("----------------------");

        }

        /**
         * 12.	TODO: Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
         */
        public static void exercise12 (String message){
            System.out.println(message);

            storage.findAndSort(person -> person.getBirthDate().getYear()<1950,
                    Comparator.comparing((Person person) -> person.getBirthDate()).reversed())
                    .forEach(System.out::println);

            System.out.println("----------------------");
        }

        /**
         * 13.	TODO: Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
         */
        public static void exercise13 (String message){
            System.out.println(message);

            storage.findAndSort(Comparator.comparing(Person::getLastName)
                    .thenComparing(Person::getFirstName)
                    .thenComparing(Person::getBirthDate))
                    .forEach(System.out::println);

            System.out.println("----------------------");
        }

    }
