package company.interpreter;

import company.facade.FacadeXML;
import company.iterator.IteratorDFS;
import company.iterator.Kladr;
import company.iterator.KladrNode;
import company.iterator.Type;

import java.util.Iterator;
import java.util.List;

public class Interpreter {
    public Kladr getKladr() {
        return kladr;
    }

    public void setKladr(Kladr kladr) {
        this.kladr = kladr;
    }

    private Kladr kladr;

    public Interpreter(Kladr kladr) {
        this.kladr = kladr;
    }

    public List interpret(String string) throws Exception {
        String[] strings = string.split(" ");
        if (strings[0].equalsIgnoreCase("return") && strings[1].equalsIgnoreCase("children")) {
            Iterator iterator = kladr.iterator();
            while (iterator.hasNext()) {
                KladrNode node = (KladrNode) iterator.next();
                if ((node).getType().toString().equalsIgnoreCase(strings[2]) && node.getName().equalsIgnoreCase(strings[3])) {
                    return node.getChilds();
                }
            }
        }

        if (strings[0].equalsIgnoreCase("add")) {
            String[] address = strings[1].split(";")[0].split(",");
            String name = strings[1].split(";")[1];
            Type type = Type.valueOf(strings[1].split(";")[1]);
            KladrNode node = findNode(address);
            KladrNode[] array = (KladrNode[]) node.getChilds()
                    .stream()
                    .filter(child -> child.getName().equals(name) && child.getType().equals(type))
                    .toArray();
            if (array[0] == null) {
                KladrNode newChild = new KladrNode.Builder(name).setType(type).setParent(node).build();
                node.addChild(newChild);
            } else {
                throw new Exception("The same child already exists");
            }
        }

        if (strings[0].equalsIgnoreCase("delete")) {
            String[] address = strings[1].split(";")[0].split(",");
            findNode(address).getParent().removeChild(findNode(address));
        }

        if (strings[0].equalsIgnoreCase("save")) {
            FacadeXML facadeXML = FacadeXML.getInstance();
            facadeXML.writeTree(kladr,"file.xml");
        }
        throw new NoSuchMethodException("Interpretation error");
    }

    private KladrNode findNode(String[] address) throws Exception {
        IteratorDFS iteratorDFS = new IteratorDFS((KladrNode) kladr.getRoot());
        while (iteratorDFS.hasNext()) {
            KladrNode node = iteratorDFS.next();
            if (node.getName().equals(address[address.length - 1])) {
                KladrNode lastAddress = node;
                for (int i = address.length - 2; i >= 0; i--) {
                    lastAddress = lastAddress.getParent();
                    if (!address[i].equals(lastAddress.getName())) {
                        lastAddress = null;
                        break;
                    }
                }
                if (lastAddress == null) {
                    throw new Exception("Invalid address");
                } else {
                    return lastAddress;
                }
            }
        }
        throw new Exception("Invalid address");
    }
}
