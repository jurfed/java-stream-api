import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class StreamRunner {

    static Stream stream;

    public static void main(String[] args) throws IOException, URISyntaxException {

        //stream create
        StreamCreate streamCreate = new StreamCreate();
        Stream<String> streamFromFile = streamCreate.createFromFile();
        streamFromFile.forEach(System.out::println);
        stream = streamCreate.CreateInfiniteStream();
        //stream.forEach(System.out::println);

//stream methods
        StreamMethods cinveersAndTerminalsMethods = new StreamMethods();
        cinveersAndTerminalsMethods.conveersMethods();
        cinveersAndTerminalsMethods. terminalsMethods();

        //stream examples 1
        Examples1 examples1 = new Examples1();
        examples1.start();

        //stream examples 2
        Examples2 examples2 = new Examples2();
        examples2.start();

        //stream examples 3
        Examples3 examples3 = new Examples3();
        examples3.start();

        //stream examples 4
        Examples4 examples4 = new Examples4();
        examples4.start();

        //stream examples 5
        Examples5 examples5 = new Examples5();
        examples5.start();

        //stream examples 6
        Examples6 examples6 = new Examples6();
        examples6.start();

        //stream examples 7
        Examples7 examples7 = new Examples7();
        examples7.start();

    }



}
