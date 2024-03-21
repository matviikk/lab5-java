package Commands;

import model.LabWork;

import java.util.TreeSet;

public class Show implements Command {
    TreeSet<LabWork> treeSet;

    public Show(TreeSet<LabWork> treeSet) {
        this.treeSet = treeSet;
    }
    public void show(){
        System.out.println(treeSet);
    }
    @Override
    public void execute() {
        show();
    }
}
