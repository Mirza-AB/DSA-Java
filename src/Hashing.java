import java.util.Collections;
import java.util.HashMap;

public class Hashing {
    public static void main(String[] args) {

        int[] arr = {1,1, 2,3,1,3,2,4, 3, 3, 3, 3};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i: arr)
        {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0 ) +1);
        }

        System.out.println(hashMap.values());


        System.out.println(Collections.max(hashMap.values()));
//        int max=0;
//        for(int i: hashMap.values())
//        {
//            if(i>max)
//                max = i;
//        }
//        System.out.println(max);


        String s = "abcreab";

        HashMap<Character, Integer> hashMap1 = new HashMap<>();

        for(char c:s.toCharArray())
        {
            hashMap1.put(c, hashMap1.getOrDefault(c, 0) +1);
        }

//        System.out.println(hashMap1.getOrDefault('e',0));

    }
}
