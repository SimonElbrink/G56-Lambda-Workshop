package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Create implementations for all methods.
 * I have already provided an implementation for the first method.
 */
public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }


    static DataStorage getInstance() {
        return INSTANCE; // Returning the singleton instance
    }

    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        System.out.println("--------- DataStorageImpl class, findMany Method ---------");
        List<Person> result = new ArrayList<>(); // Creating a list to store filtered Person objects
        for (Person person : personList) { // Iterating over each Person object in personList
            if (filter.test(person)) { // Testing if the Person object satisfies the filter predicate
                result.add(person); // Adding the Person object to the result list if it satisfies the predicate
            }
        }

        System.out.println("--------- END DataStorageImpl class, findMany Method ---------");
        return result; // Returning the list of filtered Person objects
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        // TODO: just like this???
        for(Person p : personList){
            if(filter.test(p)){
                return p;
            }
        }
        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        // TODO: just like this??? map to string like this?

        for(Person p : personList){
            if(filter.test(p)){
                return personToString.apply(p);
            }
        }
        return null;
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        // TODO: needs testing
        List<String> people = new ArrayList<>();

        personList.forEach(s -> {
            filter.test(s);
            people.add(personToString.apply(s));
        });

        /*
        for(Person p : personList){
            if(filter.test(p)){
                people.add(personToString.apply(p));
            }
        }
         */

        return people;

    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
        // TODO: needs testing
        personList.forEach(s -> {
            filter.test(s);
            consumer.accept(s);
        });

    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        // TODO: needs completion

        List<Person> list = new ArrayList<>();

        return list;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
        // TODO: needs completion

        List<Person> list = new ArrayList<>();

        personList.forEach(s -> {
            filter.test(s);
            list.add(s);
        });


        return list;
    }
}
