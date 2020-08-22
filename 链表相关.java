import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void bucketSort(Integer[] a) {
        ArrayList<Integer>[] bucket = new ArrayList[a.length];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            int index = a[i] * a.length / (max + 1);
            //bucket.insert(a[index])
            //if empty
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<>();
                bucket[index].add(a[i]);
            } else {
                //not empty

                for (int j = 0; j < bucket[index].size(); j++) {
                    if (bucket[index].get(j) < a[i]) {
                        if (j == bucket[index].size() - 1) {
                            bucket[index].add(a[i]);
                            break;
                        }
                        continue;
                    } else {
                        bucket[index].add(j, a[i]);
                        break;
                    }
                }

            }

        }
//        //test:show bucket
//        for(int i = 0; i < a.length; i++){
//            if(bucket != null){
//                System.out.println(bucket[i]);
//            }
//        }

        int pivot = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    a[pivot++] = bucket[i].get(j);
                }
            } else {
                continue;
            }
        }

    }

    public static class Node {
        Node next = null;
        int data;

        Node(int data) {
            this.data = data;
        }

        void appendToTail(int data) {
            Node p = this;
            Node end = new Node(data);
            while (p.next != null) {
                p = p.next;
            }
            p.next = end;
        }

    }

    public static void show(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();


    }

    public static void show(Node head) {
        Node p = head;
        while (p != null) {
            System.out.printf("%d ", p.data);
            p = p.next;
        }
        System.out.println();
    }

    public static void removeRepeative(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node p = head;
        Node pre = null;
        while (p != null) {
            if (hs.contains(p.data)) {
                pre.next = pre.next.next;
                p = pre.next;
            } else {
                hs.add(p.data);
                pre = p;
                p = p.next;
                continue;
            }
        }
    }

    public static int getRverseKth(Node head, int k) {
        int res;
        Node pre = head;
        Node p = head.next;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int time = count - k + 1;
        if (time < 0)
            res = -1;
        else {
            for (int i = 0; i < time; i++) {
                pre = pre.next;
            }

            res = pre.data;
        }

        return res;
    }

    public static Node getReverse(Node head) {
        if (head == null) {
            return null;
        }

        Node tmp = getReverse(head.next);
        if (tmp == null)
            return head;

        Node p = tmp;

        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        head.next = null;

        return tmp;

    }

    //    public static Node reverse(Node head){
//        Node p1 = head;
//        Node p2 = head.next;
//        p1.next = null;
//        while (p2 != null){
//            Node p3 = p2.next;
//            p2.next = p1;
//            p1 = p2;
//            p2 = p3;
//        }
//        return p1;
//    }
    public static boolean isLoop(Node head) {
        Node p1 = head;
        Node p2 = head;
        do {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                Node start = head;
                while (p1 != start) {
                    p1 = p1.next;
                    start = start.next;
                }

                System.out.println(start.data);

                return true;
            }
        } while (p2 != null);


        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
//        head.next.next.next.next.next.next = head;
        show(head);
        head = getReverse(head);
        show(head);
    }
}
