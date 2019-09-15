import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter, findFirst, findAny, skip, limit и count
 */
public class Examples1 {

    List<String> strings = Arrays.asList("a1", "a2", "a3", "a1");

    public void start() {
        String element;

        //Вернуть количество вхождений объекта «a1»
        System.out.println("------------------------Вернуть количество вхождений объекта «a1»");
        Stream<String> stringStream = strings.stream();
        long countA = stringStream.filter("a1"::equals).count();
        System.out.println("countA = " + countA);

        //Вернуть первый элемент коллекции или 0, если коллекция пуста
        System.out.println("------------------------Вернуть первый элемент коллекции или 0, если коллекция пуста");
        stringStream = strings.stream();
        element = stringStream.findFirst().orElse("0");
        System.out.println("element = " + element);

        //Вернуть последний элемент коллекции или «empty», если коллекция пуста
        System.out.println("------------------------Вернуть последний элемент коллекции или «empty», если коллекция пуста");
        stringStream = strings.stream();
        element = stringStream.skip(strings.size() - 1).findAny().orElse("empty");
        System.out.println("element = " + element);

        //Найти элемент в коллекции равный «a3» или кинуть ошибку
        System.out.println("------------------------Найти элемент в коллекции равный «a3» или кинуть ошибку");
        stringStream = strings.stream();
        element = stringStream.filter("a3"::equals).findAny().orElseThrow(() -> new RuntimeException());
        System.out.println("element = " + element);

        //Вернуть третий элемент коллекции по порядку
        System.out.println("------------------------Вернуть третий элемент коллекции по порядку");
        stringStream = strings.stream();
        element = stringStream.skip(2).findFirst().get();
        System.out.println("element = " + element);

        //Вернуть два элемента начиная со второго
        System.out.println("------------------------Вернуть два элемента начиная со второго");
        stringStream = strings.stream();
        String[] stringList = stringStream.skip(1).limit(2).toArray(String[] ::new);
        System.out.println(Arrays.asList(stringList));

        //ВВыбрать все элементы по шаблону
        System.out.println("------------------------Выбрать все элементы по шаблону");
        stringStream = strings.stream();
        List<String> stringList1 = stringStream.filter(s -> s.contains("1")).collect(Collectors.toList());
        System.out.println(stringList1);

    }
}
