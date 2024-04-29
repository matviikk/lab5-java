package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.LabWork;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.TreeSet;
/**
 * Команда для сохранения коллекции лабораторных работ в XML-формате в файл.
 */
public class Save extends Command {
    private final TreeSet<LabWork> treeSet;
    private final String path;
    private final XmlMapper mapper = new XmlMapper();
    /**
     * Конструктор класса Save.
     * @param treeSet Коллекция лабораторных работ для сохранения.
     * @param path Путь к файлу, в который будет производиться сохранение.
     */
    public Save(TreeSet<LabWork> treeSet, String path) {
        super("save", "сохранить коллекцию в файл");
        this.treeSet = treeSet;
        this.path = path;
        mapper.registerModule(new JavaTimeModule());
    }
    /**
     * Сохраняет коллекцию в XML-формате в файл по заданному пути.
     */
    public void save() {
        Date now = new Date();
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (LabWork labWork: treeSet) {
                labWork.setLastSaveTime(now);
                String xml = null;
                try {
                    xml = mapper.writeValueAsString(labWork);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                printWriter.println(xml);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + path, e);
        }
    }
    /**
     * Выполняет команду сохранения коллекции в файл.
     * @param args Аргументы команды (не используются).
     */
    @Override
    public void execute(String... args) {
        save();
    }
}
