package company.iterator;

import java.util.*;

public class IteratorPriority implements Iterator<KladrNode> {
    private Queue<KladrNode> queue;

    public IteratorPriority(KladrNode kladrNode) {
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
            List<KladrNode> childs = queue.peek().getChilds();
            childs.sort(Comparator.comparing(KladrNode::getPriority).reversed());
            queue.addAll(childs);
            return queue.poll();
        } else {
            throw new NoSuchElementException();
        }
    }
}
