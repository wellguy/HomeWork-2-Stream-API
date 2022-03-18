import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minor =  persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество призывников " + minor);

        List<String> sold = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println(sold);

        List<Person> Professor = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> (person.getSex().equals(Sex.WOMAN) && person.getAge() <= 60) ||
                        (person.getSex().equals(Sex.MAN) && person.getAge() <= 65))
                .collect(Collectors.toList());
        System.out.println("работоспособных c высшим образованием:");
        System.out.println(Professor);

    }
}
