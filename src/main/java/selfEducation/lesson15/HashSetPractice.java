package selfEducation.lesson15;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetPractice {
    public static void main(String[] args) {
        HashSet<String> numbersHashSet = new HashSet<>();
        numbersHashSet.add("арбуз");
        numbersHashSet.add("банан");
        numbersHashSet.add("вишня");
        numbersHashSet.add("груша");
        numbersHashSet.add("дыня");
        numbersHashSet.add("ежевика");
        numbersHashSet.add("женьшень");
        numbersHashSet.add("земляника");
        numbersHashSet.add("ирис");
        numbersHashSet.add("банан");
        System.out.println(numbersHashSet);

        Iterator<String> value = numbersHashSet.iterator();
        while (value.hasNext()){
            System.out.println(value.next());
        }

    }


}
