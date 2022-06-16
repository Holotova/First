package selfEducation.lesson15;

import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        System.out.println(linkedList);

        linkedList.addLast("last");
        linkedList.addFirst("first");
        System.out.println(linkedList);

        linkedList.add(2, "new second element");
        System.out.println(linkedList);

        System.out.println(String.format("LinkedList has %d elements", linkedList.size()));

        System.out.println(linkedList.get(5));
        linkedList.set(5, "New fifth element");
        System.out.println(linkedList.get(5));
        System.out.println(linkedList);
        System.out.println("-------------------------------------");

        for (String number: linkedList){
            System.out.println(number);
        }

        if (linkedList.contains("two")){
            System.out.println("it really contain");
        } else {
            System.out.println("No no no, sorry");
        }

        linkedList.remove(2);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        linkedList.remove("three");
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        linkedList.removeFirst();
        System.out.println("Remove first: " + linkedList);
        System.out.println(linkedList.size());
        linkedList.removeLast();
        System.out.println("Remove last: " + linkedList);
        System.out.println(linkedList.size());
    }
}
