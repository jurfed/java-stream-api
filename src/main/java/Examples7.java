import people.People;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Примеры использования toArray и collect функции
 * .collect(Collectors.
 */
public class Examples7 {


	Collection<Integer> integers = Arrays.asList(1, 2, 3, 4);


	public void start() {

		//Получить сумму нечетных чисел
		System.out.println("------------------------Получить сумму нечетных чисел");
		int sum = integers.stream().collect(Collectors.summingInt(value -> value % 2 == 0 ? 0 : value));
		System.out.println(sum);

		//Вычесть от каждого элемента 1 и получить среднее
		System.out.println("------------------------Вычесть от каждого элемента 1 и получить среднее");
		double result = integers.stream().collect(Collectors.averagingInt(value -> value + 1));
		System.out.println(result);

		//Прибавить к числам 3 и получить статистику
		System.out.println("------------------------Прибавить к числам 3 и получить статистику");
		IntSummaryStatistics intSummaryStatistics = integers.stream().collect(Collectors.summarizingInt(value -> value + 3));
		System.out.println(intSummaryStatistics);

		//Разделить числа на четные и нечетные
		System.out.println("------------------------Разделить числа на четные и нечетные");
		Map map = integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
		System.out.println(map);


		Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

		//Получение списка без дубликатов
		System.out.println("------------------------Получение списка без дубликатов");
		List list = strings.stream().distinct().collect(Collectors.toList());
		System.out.println(list);

		//Получить массив строк без дубликатов и в верхнем регистре
		System.out.println("------------------------Получить массив строк без дубликатов и в верхнем регистре");
		list = strings.stream().distinct().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(list);

		//Объединить все элементы в одну строку через разделитель: и обернуть тегами <b>… </b>
		System.out.println("------------------------Объединить все элементы в одну строку через разделитель: и обернуть тегами <b>… </b>");
		String str = strings.stream().collect(Collectors.joining(":", "<b>", "</b>"));
		System.out.println(str);


		//Преобразовать в map, где первый символ ключ, второй символ значение
		System.out.println("------------------------Преобразовать в map, где первый символ ключ, второй символ значение");
		Map map1 = strings.stream().distinct().collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1, 2)));
		System.out.println(map1);

		//Преобразовать в map, сгруппировав по первому символу строки
		System.out.println("------------------------Преобразовать в map, сгруппировав по первому символу строки");
		Map map2 = strings.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1)));
		System.out.println(map2);

		//Преобразовать в map, сгруппировав по первому символу строки и объединим вторые символы через :
		System.out.println("------------------------Преобразовать в map, сгруппировав по первому символу строки и объединим вторые символы через :");
		Map map3 = strings.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1), Collectors.mapping((p) -> p.substring(1, 2), Collectors.joining(":"))));
		System.out.println(map3);

		var people1 = new People("Ivan", 2000, People.Sex.MAN);
		var people2 = new People("Ivan2", 2000, People.Sex.WOMEN);
		var people3 = new People("Ivan3", 2001, People.Sex.WOMEN);
		var peoples = List.of(people1, people2, people3);

		//преобразовать в простую карту
        var myMap = peoples.stream().collect(Collectors.toMap(People::getName,Function.identity()));

        //группиоует и делает карту из списков
        var myMap2 = peoples.stream().collect(Collectors.groupingBy(People::getYear));
		System.out.println(myMap);

	}
}
