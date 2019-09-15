import people.People;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reduce
 */
public class Examples6 {


    Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);


    public void start() {

        //Получить сумму чисел или вернуть 0
        System.out.println("------------------------Получить сумму чисел или вернуть 0");
        int sum = integers.stream().reduce((i, resutl) -> resutl + i).orElse(0);
        System.out.println(sum);

        //Вернуть максимум или -1
        System.out.println("------------------------Вернуть максимум или -1");
        int max = integers.stream().reduce((i, resutl) -> i < resutl ? resutl : i).orElse(-1);
        int max2 = integers.stream().reduce(Integer::max).orElse(-1);
        System.out.println(max);
        System.out.println(max2);

        //Вернуть сумму нечетных чисел или 0
        System.out.println("------------------------Вернуть сумму нечетных чисел или 0");
        int sumNechet = integers.stream().filter(integer -> integer % 2 != 0).reduce((integer, integer2) -> integer + integer2).orElse(0);
        System.out.println(sumNechet);
    }
}
