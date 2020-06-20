package online;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/23
 * @description:
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        function();
    }
    public static Object[] function() {
        Integer[] ints = {1,2,3,3,2,1};
        Set<Integer> intSet = Stream.of(ints).collect(Collectors.toSet());
        return intSet.toArray();
    }

}
