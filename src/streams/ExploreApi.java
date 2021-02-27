package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExploreApi {

    public static void main(String[] args) {

        int[] data = {1,2,3,4};
        String[] data1 ={"x","y","z","A","B"};

        Stream streamObj = Stream.of(data);
        IntStream intStreamObj = Arrays.stream(data);

        streamObj.forEach(System.out::println);
        intStreamObj.forEach(System.out::println);

        List<String> listObj = Arrays.stream(data).mapToObj(i->data1[i]).collect(Collectors.toList());
        System.out.println(listObj);
    }
}
