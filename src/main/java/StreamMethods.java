import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    Stream stream;

    /**
     * конвеерные методы
     */
    void conveersMethods() {
        //filter, peak and count
        System.out.println("------------filter, peak and count");
        stream = Stream.of("a1", "a2", "a3", "a4");
        long i = stream.filter("a2"::equals).peek(System.out::println).count();

        //skip
        System.out.println("--------------skip");
        stream = Stream.of("a1", "a2", "a3", "a4");
        stream.skip(2).peek(System.out::println).collect(Collectors.toList());

        //limit
        System.out.println("-------------limit");
        stream = Stream.of("a1", "a2", "a3", "a4");
        stream.limit(2).peek(System.out::println).collect(Collectors.toList());

        //distinct
        System.out.println("----------distinct");
        stream = Stream.of("a1", "a2", "a2", "a1");
        stream.distinct().peek(System.out::println).collect(Collectors.toList());

        //map - transformate this stream
        System.out.println("-------------map");
        Stream<String> stringStream = Stream.of("a1", "a2", "a3", "a4");
        stringStream.map(o -> o.toUpperCase()).peek(System.out::println).collect(Collectors.toList());

        //sorted
        System.out.println("------------sorted");
        Stream<Integer> intStream = Stream.of(12, 43, 1, 6);
        intStream.sorted((o1, o2) -> o2 - o1).peek(System.out::println).collect(Collectors.toList());

        //map to int, double, long
        System.out.println("-------------map to int, double, long");
        stringStream = Stream.of("1", "2", "3");
        stringStream.mapToInt(Integer::parseInt).peek(System.out::println).toArray();

        //Flat map - split this stream
        System.out.println("------------------Flat map");
        Stream<String> flatMapStream = Stream.of("one, two, three, four", "1; 2; 3; 4", "A - B - C");
        String[] array = flatMapStream.flatMap(s -> Arrays.stream(s.split("[,;-]"))).toArray(String[]::new);
        Arrays.asList(array).forEach(System.out::println);
    }

    /**
     * терминальные методы
     */
    public void terminalsMethods() {
        Object element;

        System.out.println("-----------------findFirst");
        stream = Stream.of("a1", "a2", "a3", "a4");
        element = stream.findFirst().orElse("null");
        System.out.println(element);

        System.out.println("-----------------findAny ??????????????????");
        stream = Stream.of("a1", "a2", "a3", "a4");
        element = stream.findAny().orElse("null");
        System.out.println(element);

        System.out.println("-----------------anyMatch ??????????????????");
        stream = Stream.of("a1", "a2", "a3", "a4");
        element = stream.anyMatch("a2"::equals);
        System.out.println(element);

        System.out.println("-----------------noneMatch");
        stream = Stream.of("a1", "a2", "a3", "a4");
        element = stream.noneMatch("a2"::equals);
        System.out.println(element);

        System.out.println("-----------------allMatch");
        stream = Stream.of("a1", "a2", "a3", "a4");
        element = stream.allMatch(o -> ((String) o).contains("a"));
        System.out.println(element);

        System.out.println("-----------------min ");
        Stream<Integer> stream = Stream.of(-3, 100, -5, 765, 5);
        element = stream.min((o1, o2) -> o1 - o2).orElse(null);
        System.out.println(element);

        System.out.println("-----------------max ");
        Stream<String> streamString = Stream.of("b", "z", "445", "cdsf", "a");
        element = streamString.max(String::compareTo).get();
        System.out.println(element);


        //collect - get result as a collection ot other structure
        System.out.println("---------------- collect");
        Stream<String> streamString2 = Stream.of("b", "z", "445", "acdsf", "a");
        List<String> stringList = streamString2.filter(s -> s.contains("a")).collect(Collectors.toList());
        System.out.println(stringList);

        //count
        streamString2 = Stream.of("b", "z", "445", "acdsf", "a");
        System.out.println("count=" + streamString2.skip(2).count());

        //aggregate function
        System.out.println("---------------- aggregate functions!!!!");
        //1
        Stream<String> stream1 = Stream.of("a1", "a2", "a3", "a4");
        String result = stream1.reduce((s, s2) -> s + "_" + s2).orElse("!!!");
        System.out.println(result);
        //2
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        Integer integerResult = stream2.reduce((s, s2) -> s + s2).orElse(0);
        System.out.println(integerResult);

        //sum avarage mapToObject
        System.out.println("---------------- sum avarage mapToObject");
        //1
        Stream<String> streamStr = Stream.of("1", "2", "3", "4");
        int sum = streamStr.mapToInt(integer -> Integer.parseInt(integer)).sum();
        System.out.println("sum=" + sum);
        //2
        streamStr = Stream.of("1", "2", "3", "4");
        double avg = streamStr.mapToInt(integer -> Integer.parseInt(integer)).average().orElse(0.0);
        System.out.println("avg=" + avg);

    }

}
