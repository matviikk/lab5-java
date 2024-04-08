package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;

import java.util.Iterator;
import java.util.TreeSet;

public class PrintDescending implements Command {
    TreeSet<LabWork> treeSet;
    public PrintDescending(TreeSet<LabWork> treeSet) {
        this.treeSet = treeSet;
    }
    public void printDescending() {
        Iterator<LabWork> iterator = treeSet.iterator();
        recursion(iterator);
    }
    public void recursion(Iterator<LabWork> iterator) {
        if (iterator.hasNext()) {
            LabWork lb = iterator.next();
            recursion(iterator);
            System.out.println(lb);
        }
    }
    @Override
    public void execute(String... args) throws JsonProcessingException {
        printDescending();
    }
}
