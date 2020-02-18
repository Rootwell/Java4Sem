package company.iterator;

import java.util.Iterator;

public class Kladr<KladrNode> implements Iterable {

    public Kladr(){}
    public KladrNode getRoot() {
        return root;
    }

    public void setRoot(KladrNode root) {
        this.root = root;
    }

    KladrNode root;

    public Kladr(KladrNode root) {
        this.root = root;
    }

    @Override
    public Iterator iterator() {
        return new IteratorDFS((company.iterator.KladrNode) this.getRoot());
    }
}
