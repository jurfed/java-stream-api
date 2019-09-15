import people.People;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter, findFirst, findAny, skip, limit и count
 */
public class Examples2 {
    List<People> peopleList;

    Examples2() {
        peopleList = Arrays.asList(new
                People("Вася", 16, People.Sex.MAN), new
                People("Петя", 23, People.Sex.MAN), new
                People("Елена", 42, People.Sex.WOMEN), new
                People("Иван Иванович", 69, People.Sex.MAN));
    }


    public void start() {
        Stream<People> peopleStream;
        List<People> resultList;

        //Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        System.out.println("Выбрать мужчин-военнообязанных (от 18 до 27 лет)");
        peopleStream = peopleList.stream();
        resultList = peopleStream.filter(people -> people.sex == People.Sex.MAN && people.year >= 18 && people.year <= 27).collect(Collectors.toList());
        System.out.println(resultList);

        //Найти средний возраст среди мужчин
        System.out.println("Найти средний возраст среди мужчин");
        peopleStream = peopleList.stream();
        Double yearsAvg = peopleStream.filter(people -> people.sex == People.Sex.MAN).mapToInt(People::getYear).average().orElse(0);
        System.out.println("man's avg years = " + yearsAvg);

        //Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        System.out.println("Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)");
        peopleStream = peopleList.stream();
        Long workingPeoples = peopleStream.filter(people -> people.year>=18 && (people.sex== People.Sex.MAN && people.year<=60)|| people.sex== People.Sex.WOMEN && people.year<=55).count();
        System.out.println("working Peoples = " + workingPeoples);
    }


}
