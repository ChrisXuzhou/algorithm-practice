package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySum {


    // Given an array of integers, find two numbers such that they add up to a specific target sum.
    public int[] find(int[] array, int sum) {
        Map<Integer, Integer> arrayMap = IntStream.range(0, array.length)
                .boxed()
                .collect(
                        Collectors.toMap(
                                i->array[i],
                                i->i
                        )
                );

        for (int e: array) {
            if (arrayMap.containsKey(sum - e)) {
                return new int[]{e, sum -e};
            }
        }

        return new int[0];
    }

}
