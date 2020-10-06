import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 69, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER)
        );
        Stream<Person> stream = persons.stream();
        int a = (int) stream
                .filter((x) -> x.getAge() < 18)
                .count();
        System.out.println("Сисок несовершеннолетних: " + a);
        Stream<Person> stream1 = persons.stream();
        List<String> string = stream1
                .filter((x) -> x.getAge() > 18 && x.getAge() < 27 && x.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список фамилий призывников: " + string);
        Stream<Person> stream2 = persons.stream();
        List<Person> listPerson = stream2
                .filter((x) -> (x.getAge() > 18 && x.getAge() < 65 && x.getSex() == Sex.MAN) || (x.getAge() > 18 && x.getAge() < 60 && x.getSex() == Sex.WOMEN))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
System.out.println("Список отсортированных по Фамилии трудоспособных граждан: ");
        for (Person person : listPerson) {
            System.out.println(person);
        }
    }
}


