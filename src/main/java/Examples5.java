import people.People;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sorted
 * Max и Min
 */
public class Examples5 {


    Collection<String> strings = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
    List<People> peopleList;

    Collection<String> stringsCollection = Arrays.asList("a1", "a2", "a3", "a1");

    Examples5() {
        peopleList = Arrays.asList(new
                People("Вася", 16, People.Sex.MAN), new
                People("Петя", 23, People.Sex.MAN), new
                People("Елена", 42, People.Sex.WOMEN), new
                People("Иван Иванович", 69, People.Sex.MAN));
    }


    public void start() {
        Stream<People> peopleStream;
        List<People> peopleresult;

        Stream<String> stringStream;

        //Отсортировать коллекцию строк по алфавиту
        System.out.println("------------------------Отсортировать коллекцию строк по алфавиту");
        stringStream = strings.stream();
        List<String> stringList = stringStream.sorted().collect(Collectors.toList());
        System.out.println(stringList);

        //Отсортировать коллекцию строк по алфавиту в обратном порядке
        System.out.println("------------------------Отсортировать коллекцию строк по алфавиту в обратном порядке");
        stringStream = strings.stream();
        stringList = stringStream.sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(stringList);

        //Отсортировать коллекцию строк по алфавиту и убрать дубликаты
        System.out.println("------------------------Отсортировать коллекцию строк по алфавиту и убрать дубликаты");
        stringStream = strings.stream();
        stringList = stringStream.sorted((o1, o2) -> o1.compareTo(o2)).distinct().collect(Collectors.toList());
        System.out.println(stringList);

        //Отсортировать коллекцию строк по алфавиту в обратном порядке и убрать дубликаты
        System.out.println("------------------------Отсортировать коллекцию строк по алфавиту в обратном порядке и убрать дубликаты");
        stringStream = strings.stream();
        stringList = stringStream.sorted((o1, o2) -> o2.compareTo(o1)).distinct().collect(Collectors.toList());
        System.out.println(stringList);

        //Отсортировать коллекцию людей по имени в обратном алфавитном порядке
        System.out.println("------------------------Отсортировать коллекцию людей по имени в обратном алфавитном порядке");
        peopleStream = peopleList.stream();
        peopleresult = peopleStream.sorted((o1, o2) -> o2.name.compareTo(o1.name)).collect(Collectors.toList());
        System.out.println(peopleresult);

        //Отсортировать коллекцию людей сначала по полу, а потом по возрасту
        System.out.println("------------------------Отсортировать коллекцию людей сначала по полу, а потом по возрасту");
        peopleStream = peopleList.stream();
        peopleresult = peopleStream.sorted((o1, o2) -> o1.sex != o2.sex ? o1.sex.compareTo(o2.sex) : o1.year.compareTo(o2.year)).collect(Collectors.toList());
        System.out.println(peopleresult);

//MIN MAX------------------------------------------------------------------------------------------------
        System.out.println("MIN MAX");
        String result;
        Stream<String> stringStream1;

        //Найти максимальное значение среди коллекции строк "a1", "a2", "a3", "a1"
        System.out.println("------------------------Найти максимальное значение среди коллекции строк");
        stringStream1 = stringsCollection.stream();
        result = stringStream1.max(String::compareTo).get();
        System.out.println(result);

        //Найти минимальное значение среди коллекции строк "a1", "a2", "a3", "a1"
        System.out.println("------------------------Найти минимальное значение среди коллекции строк");
        stringStream1 = stringsCollection.stream();
        result = stringStream1.min(String::compareTo).get();
        System.out.println(result);

        //Найдем человека с максимальным возрастом
        System.out.println("------------------------Найдем человека с максимальным возрастом");
        peopleStream = peopleList.stream();
        People people = peopleStream.max((o1, o2) -> o1.year.compareTo(o2.year)).get();
        System.out.println(people);

        //Найдем человека с минимальным возрастом
        System.out.println("------------------------Найдем человека с минимальным возрастом");
        peopleStream = peopleList.stream();
        People people2 = peopleStream.max((o1, o2) -> o2.year.compareTo(o1.year)).get();
        System.out.println(people2);

    }
}
