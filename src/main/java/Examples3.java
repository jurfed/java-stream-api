import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * anyMatch, allMatch, noneMatch
 */
public class Examples3 {

    Collection<String> strings = Arrays.asList("a1", "a2", "a3", "a1");

    public void start() {

        Stream<String> stringStream;

        //Найти существуют ли хоть один «a1» элемент в коллекции
        System.out.println("------------------------Найти существуют ли хоть один «a1» элемент в коллекции");
        stringStream = strings.stream();
        boolean result =stringStream.anyMatch("a1"::equals);
        System.out.println(result);

        //Найти существуют ли хоть один «a8» элемент в коллекции
        System.out.println("------------------------Найти существуют ли хоть один «a8» элемент в коллекции");
        stringStream = strings.stream();
        boolean result2 =stringStream.anyMatch("a8"::equals);
        System.out.println(result2);

        //Найти есть ли символ «1» у всех элементов коллекции
        System.out.println("------------------------Найти есть ли символ «1» у всех элементов коллекции");
        stringStream = strings.stream();
        boolean result3 =stringStream.allMatch(s -> s.contains("1"));
        System.out.println(result3);

        //Проверить что не существуют ни одного «a7» элемента в коллекции
        System.out.println("------------------------Проверить что не существуют ни одного «a7» элемента в коллекции");
        stringStream = strings.stream();
        boolean result4 =stringStream.noneMatch("a7"::equals);
        System.out.println(result4);

    }
}
