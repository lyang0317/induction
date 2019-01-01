package com.test.calculate;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

public class Test {

    public strictfp static void main(String[] args) {
        System.out.println(1);
        /*LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1.size());
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);

        int size1 = list1.size();
        int size2 = list2.size();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            int i1 = 0;
            int i2 = 0;
            if(i < size1 - size2) {
                Integer poll1 = list1.poll();
                i1 = poll1 == null ? 0 : poll1;
            } else {
                Integer poll1 = list1.poll();
                Integer poll2 = list2.poll();
                i1 = poll1 == null ? 0 : poll1;
                i2 = poll2 == null ? 0 : poll2;
            }
            list.add(i1 + i2);
        }
        System.out.println(list);*/

        /*for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ServiceA().callA();
                }
            }).start();
            System.out.println(i);
        }*/


        /*List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list);

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println(set);

        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(3);
        stack.add(1);
        System.out.println(stack);

        Map<Integer, String> map = new HashMap();
        map.put(2, "");
        map.put(3, "");
        map.put(1, "");
        System.out.println(map);

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.add(2);
        linkedBlockingQueue.add(3);
        linkedBlockingQueue.add(1);
        System.out.println(linkedBlockingQueue);

        Content content1 = new Content(1, 123);
        Content content2 = new Content(2, 42);
        Content content3 = new Content(3, 22);
        Content content4 = new Content(4, 36);
        Content content5 = new Content(5, 162);
        Content content6 = new Content(6, 84);
        Content content7 = new Content(7, 63);
        Content content8 = new Content(8, 12);
        Content content9 = new Content(9, 5);
        Content content10 = new Content(10, 77);
        List<Content> datas = new ArrayList<>();
        datas.add(content6);
        datas.add(content7);
        datas.add(content8);
        datas.add(content9);
        datas.add(content10);
        List<Content> dataList = new ArrayList<>();
        dataList.add(content1);//k次
        dataList.add(content2);
        dataList.add(content3);
        dataList.add(content4);
        dataList.add(content5);
        for (int i = 6; i < 11; i++) {//n-k
            dataList.add(datas.get(i - 6));
            Collections.sort(dataList, new MyComparator());//k
            dataList.remove(dataList.size() - 1);
        }
        System.out.println(dataList);//k+klogk+(n-k)k*/

        //nlogn+k

        /*List<List<Long>> list1 = new ArrayList<>();
        List<Long> subList1 = new ArrayList<>();
        subList1.add(1l);
        subList1.add(2l);
        list1.add(subList1);
        List<Long> subList2 = new ArrayList<>();
        subList2.add(3l);
        list1.add(subList2);
        List<Long> subList3 = new ArrayList<>();
        subList3.add(4l);
        list1.add(subList3);

        List<Long> list2 = new ArrayList<>();
        list2.add(4l);

        System.out.println(list1);
        System.out.println(list2);
        adjustPassenger(list1, list2);
        System.out.println(list1);


        threadPrint();*/

        /*List<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.reverse(list);
        System.out.println(list);*/

        /*MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList.Node node1 = new MyLinkedList.Node(1);
        MyLinkedList.Node node2 = new MyLinkedList.Node(2);
        MyLinkedList.Node node3 = new MyLinkedList.Node(3);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        myLinkedList.first = node1;
        myLinkedList.last = node3;
        System.out.println(myLinkedList.first);

        MyLinkedList.Node node = myLinkedList.last;
        MyLinkedList.Node prevNode = node.prev;
        MyLinkedList.Node temp = null;
        node.prev = null;
        while (prevNode != null) {
            temp = prevNode.prev;
            node.next = prevNode;
            prevNode.prev = node;
            node = prevNode;
            prevNode = temp;
        }
        node.next = null;
        System.out.println(myLinkedList.first);

        TreeNode<Integer> treeNode1 = new TreeNode<>(1);
        TreeNode<Integer> treeNode2 = new TreeNode<>(2);
        TreeNode<Integer> treeNode3 = new TreeNode<>(3);
        TreeNode<Integer> treeNode4 = new TreeNode<>(4);
        TreeNode<Integer> treeNode5 = new TreeNode<>(5);
        TreeNode<Integer> treeNode6 = new TreeNode<>(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        printNode(treeNode1);

        Class<Test> testClass = Test.class;
        Class<? extends Test> aClass = new Test().getClass();
        Class<? extends Test> aClass12 = new Test().getClass();
        try {
            Class<?> aClass1 = Class.forName("com.test.calculate.Test");
            System.out.println(testClass == aClass);
            System.out.println(testClass == aClass1);
            System.out.println(aClass == aClass1);
            System.out.println(aClass.equals(aClass12));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        List list = new LinkedList();
        for (int i =0; i < list.size(); i++) {
            list.get(i);
        }
        Iterator iterator = list.iterator();
        ListIterator listIterator = list.listIterator();
        for (Object o : list) {

        }
    }

    private static void printNode(TreeNode<Integer> treeNode) {
        Class<? extends TreeNode> aClass = treeNode.getClass();
        TreeNode<Integer> left = treeNode.left;
        TreeNode<Integer> right = treeNode.right;
        if(left != null) {
            printNode(left);
        }
        System.out.println(treeNode.data);
        if(right != null) {
            printNode(right);
        }
    }

    static class MyLinkedList<T> {

        Node<T> first;
        Node<T> last;

        static class Node<T> {

            private T t;
            Node<T> next;
            Node<T> prev;

            Node (T t) {
                this.t = t;
            }
        }
    }

    static class TreeNode<T> {

        public TreeNode(T data) {
            this.data = data;
        }

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

    }

    static class MyComparator implements Comparator<Content> {

        @Override
        public int compare(Content o1, Content o2) {
            if (o1.getNum() > o2.getNum()) {
                return -1;
            } else if (o1.getNum() < o2.getNum()) {
                return 1;
            }
            return 0;
        }
    }


    /**
     * 乘客调整
     * @param passengerList
     * @param passengerNo
     */
    public static void adjustPassenger(List<List<Long>> passengerList, List<Long> passengerNo) {
        if(passengerList != null) {
            Iterator<List<Long>> iterator = passengerList.iterator();
            while (iterator.hasNext()) {
                List<Long> passengers = iterator.next();
                for (Long passenger : passengerNo) {
                    if(passengers.contains(passenger)) {
                        passengers.remove(passenger);
                    }
                }
                if(passengers.size() == 0) {
                    iterator.remove();
                }
            }
        }
    }

    public static void threadPrint() {

        /*Object lock = new Object();
        Thread thread1 = new MyThread("pair", 1, lock);
        Thread thread2 = new MyThread("city", 2, lock);
        Thread thread3 = new MyThread("_", 0, lock);

        thread1.start();
        thread2.start();
        thread3.start();*/

        for (int i = 0; i < 10; i++) {

            Thread thread21 = new MyThread2("pair");
            Thread thread22 = new MyThread2("city", thread21);
            Thread thread23 = new MyThread2("_", thread22);

            thread21.start();
            thread22.start();
            thread23.start();
            try {
                thread23.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        private String taskName;
        private Integer threadNo;
        private Object lock;

        private static int num = 1;
        private int count = 1;

        public MyThread(String taskName, Integer threadNo, Object lock) {
            this.taskName = taskName;
            this.threadNo = threadNo;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    if(threadNo == 0 && count > 9) {
                        break;
                    } else if (threadNo != 0 && count > 10) {
                        break;
                    }
                    if(num % 3 == threadNo) {
                        num ++;
                        count ++;
                        System.out.print(taskName);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    static class MyThread2 extends Thread {

        private String taskName;
        private Thread preThread;

        public MyThread2(String taskName) {
            this.taskName = taskName;
        }

        public MyThread2(String taskName, Thread preThread) {
            this.taskName = taskName;
            this.preThread = preThread;
        }

        @Override
        public void run() {
            if(preThread != null) {
                try {
                    preThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(taskName);
        }

    }

}
