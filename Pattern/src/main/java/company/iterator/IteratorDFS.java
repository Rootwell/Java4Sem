package company.iterator;

import java.util.Iterator;
import java.util.Stack;

public class IteratorDFS implements Iterator<KladrNode> {
    private Stack<KladrNode> stack;

    public IteratorDFS(KladrNode kladrNode) {
        stack = new Stack<>();
        stack.push(kladrNode);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public KladrNode next() {
        KladrNode node = stack.peek();
        stack.pop();
        stack.addAll(node.getChilds());
        return node;
    }

    public KladrNode getValue() {
        return stack.peek();
    }
}
