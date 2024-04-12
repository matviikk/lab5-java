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
public class Save implements Command {
    TreeSet<LabWork> treeSet;
    String path;
    XmlMapper mapper = new XmlMapper();
    /**
     * Конструктор класса Save.
     * @param treeSet Коллекция лабораторных работ для сохранения.
     * @param path Путь к файлу, в который будет производиться сохранение.
     */
    public Save(TreeSet<LabWork> treeSet, String path) {
        this.treeSet = treeSet;
        this.path = path;
        mapper.registerModule(new JavaTimeModule());
    }
    /**
     * Сохраняет коллекцию в XML-формате в файл по заданному пути.
     * @throws JsonProcessingException Если происходит ошибка при сериализации объектов.
     */
    public void save() throws JsonProcessingException {
        Date now = new Date();
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (LabWork labWork: treeSet) {
                labWork.setLastSaveTime(now);
                String xml = mapper.writeValueAsString(labWork);
                printWriter.println(xml);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден: " + path, e);
        }
    }
    /**
     * Выполняет команду сохранения коллекции в файл.
     * @param args Аргументы команды (не используются).
     * @throws JsonProcessingException Если в процессе выполнения команды происходят ошибки сериализации данных.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        save();
    }
}
