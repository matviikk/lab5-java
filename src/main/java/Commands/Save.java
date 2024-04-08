package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.LabWork;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Save implements Command {
    TreeSet<LabWork> treeSet;
    String path;
    XmlMapper mapper = new XmlMapper();
    public Save(TreeSet<LabWork> treeSet, String path) {
        this.treeSet = treeSet;
        this.path = path;
        mapper.registerModule(new JavaTimeModule());
    }
    public void save() throws JsonProcessingException {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (LabWork labWork: treeSet) {
                String xml = mapper.writeValueAsString(labWork);
                printWriter.println(xml);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void execute(String... args) throws JsonProcessingException {
        save();
    }
}
