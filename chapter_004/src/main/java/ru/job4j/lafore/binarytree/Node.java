package ru.job4j.lafore.binarytree;

public class Node {

    public int iD; // Данные, используемые в качестве ключа
    public double dData; // Другие данные
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла

    public void displayNode() {
        System.out.print('{');
        System.out.print(iD);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}
