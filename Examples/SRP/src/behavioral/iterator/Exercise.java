package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Node2<T>
{
    public T value;
    public Node2<T> left, right, parent;

    public Node2(T value)
    {
        this.value = value;
    }

    public Node2(T value, Node2<T> left, Node2<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    public void treTraverse(Node2<T> current, ArrayList<Node2<T>> list) {
        list.add(current);
        if (current.left != null) treTraverse(current.left, list);
        if (current.right != null) treTraverse(current.right, list);
    }

    public Iterator<Node2<T>> preOrder() {
        ArrayList<Node2<T>> nodes = new ArrayList<>();
        treTraverse(this, nodes);
        return nodes.iterator();
    }
}



class Demo42 {
    public static void main(String[] args) {
        Node2<Character> node = new Node2<>('a',
                new Node2<>('b',
                        new Node2<>('c'),
                        new Node2<>('d')),
                new Node2<>('e'));
        StringBuilder sb = new StringBuilder();
        Iterator<Node2<Character>> it = node.preOrder();
        while (it.hasNext())
        {
            sb.append(it.next().value);
        }
        System.out.println(sb);
    }
}