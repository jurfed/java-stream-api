import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map, mapToInt, FlatMap, FlatMapToInt
 */
public class Examples4 {


    Collection<String> strings = Arrays.asList("a1", "a2", "a3", "a1");
    Collection<String> strings2 = Arrays.asList("1,2,0", "4,5");


    public void start() {

        Stream<String> stringStream;
        Stream<String> resultStream;
        List<String> resultList;

        //Добавить "_1" к каждому элементу первой коллекции
        System.out.println("------------------------Добавить _1 к каждому элементу первой коллекции");
        stringStream = strings.stream();
        resultList = stringStream.map(s -> s+"_1").collect(Collectors.toList());
        System.out.println(resultList);

        //В первой коллекции убрать первый символ и вернуть массив чисел (int[])
        System.out.println("------------------------В первой коллекции убрать первый символ и вернуть массив чисел (int[])");
        stringStream = strings.stream();
        int[] integers2 = stringStream.mapToInt(value -> Integer.parseInt(value.substring(1))).toArray();
        for(int i=0; i<integers2.length; i++){
            System.out.println(integers2[i]);
        }

        //Из второй коллекции получить все числа, перечисленные через запятую из всех элементов
        System.out.println("------------------------Из второй коллекции получить все числа, перечисленные через запятую из всех элементов");
        stringStream = strings2.stream();
        String [] result = stringStream.flatMap(s -> Arrays.asList(s.split(",")).stream()).toArray(String[]::new);
        System.out.println(Arrays.asList(result));

    }
}
