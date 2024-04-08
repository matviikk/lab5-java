package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.LabWork;

import java.util.TreeSet;

public class AverageOfAveragePoint implements Command {
    TreeSet<LabWork> treeSet;
    public AverageOfAveragePoint(TreeSet<LabWork> treeSet) {
        this.treeSet = treeSet;
    }
    public void averageOfAveragePoint() {
        double sum = 0;
        for (LabWork lb: treeSet) {
            sum += lb.getAveragePoint();
        }
        System.out.println(sum / treeSet.size());
    }
    @Override
    public void execute(String... args) throws JsonProcessingException {
        averageOfAveragePoint();
    }
}
