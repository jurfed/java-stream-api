import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {

    /**
     * create from collection
     *
     * @return
     */
    Stream createFromCollection() {
        Collection<String> col = Arrays.asList("a1", "a2", "a3");

        Stream<String> stream = col.stream();
        return stream;
    }

    /**
     * create from values
     *
     * @return
     */
    Stream createFromValues() {
        Stream stream = Stream.of("a1", "a2", "a3");
        return stream;
    }

    /**
     * from array
     *
     * @return
     */
    Stream createFromArray() {
        String[] array = {"a1", "a2", "a3"};

        Stream stream = Arrays.stream(array);
        return stream;
    }

    /**
     * create stream fom file
     *
     * @return
     * @throws IOException
     */
    Stream createFromFile() throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("textFile.txt").toURI());
        Stream stream = Files.lines(path);
        return stream;
    }

    /**
     * create from string
     *
     * @return
     */
    IntStream createFromString() {
        IntStream intStream = "123".chars();
        return intStream;
    }

    /**
     * with stream builder
     *
     * @return
     */
    Stream stream() {
        Stream stream = Stream.builder().add("a1").add("a2").add("a3").build();
        return stream;
    }

    /**
     * create parallel stream
     *
     * @return
     */
    Stream createParallelStream() {
        Collection<String> col = Arrays.asList("a1", "a2", "a3");

        Stream<String> stream = col.parallelStream();
        return stream;
    }

    /**
     * create infinite stream iterate
     *
     * @return
     */
    Stream CreateInfiniteStream() {
        Stream stream = Stream.iterate(1, integer -> integer + 1);
        return stream;

    }

    /**
     * create infinite stream generate
     *
     * @return
     */
    Stream CreateInfiniteStreamGenerate() {
        Stream stream = Stream.generate(() -> "a1");
        return stream;

    }

}
