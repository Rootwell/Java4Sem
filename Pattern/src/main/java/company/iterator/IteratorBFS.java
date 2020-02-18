package company.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class IteratorBFS implements Iterator<KladrNode> {
    private Queue<KladrNode> queue;

    public IteratorBFS(KladrNode kladrNode) {
        queue = new LinkedList<>();
        queue.add(kladrNode);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public KladrNode next() {
        if (queue.peek() != null) {
            queue.addAll(queue.peek().getChilds());
            return queue.poll();
        } else {
            throw new NoSuchElementException();
        }
    }

    public KladrNode getValue() {
        return queue.peek();
    }
}
