package company.iterator;

import java.util.LinkedList;
import java.util.List;

public class KladrNode {
    private Type type;
    private String name;
    private int priority;
    private List<KladrNode> childs;
    private KladrNode parent;

    public KladrNode(){

    }
    private KladrNode(Builder builder) {
        this.type = builder.getType();
        this.name = builder.getName();
        this.priority = builder.getPriority();
        this.childs = builder.getChilds();
        this.parent = builder.getParent();
    }

    public KladrNode getParent() {
        return parent;
    }

    public void setParent(KladrNode parent) {
        this.parent = parent;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<KladrNode> getChilds() {
        return childs;
    }

    public void setChilds(List<KladrNode> childs) {
        this.childs = childs;
    }

    public void addChild(KladrNode child) {
        List<KladrNode> list = getChilds();
        list.add(child);
        setChilds(list);
    }

    public void removeChild(KladrNode child) {
        List<KladrNode> list = getChilds();
        list.remove(child);
        setChilds(list);
    }

    public static class Builder {
        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder setChilds(List<KladrNode> childs) {
            this.childs = childs;
            return this;
        }

        public Builder setParent(KladrNode parent) {
            this.parent = parent;
            return this;
        }

        private Type type;
        private String name;
        private int priority;
        private List<KladrNode> childs;
        private KladrNode parent;

        public Type getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        public List<KladrNode> getChilds() {
            return childs;
        }

        public KladrNode getParent() {
            return parent;
        }

        public Builder(String name) {
            this.name = name;
            childs = new LinkedList<>();
        }

        public KladrNode build() {
            return new KladrNode(this);
        }
    }

    @Override
    public String toString() {
        return "KladrNode{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
