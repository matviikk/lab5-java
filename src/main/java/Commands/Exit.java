package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;
/**
 * Команда для завершения выполнения программы.
 */
public class Exit extends AbstractCommand {
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл");
    }

    /**
     * Выполняет операцию выхода из программы, устанавливая флаг isRunning в состояние false.
     * @param args Аргументы команды (не используются в этой команде).
     * @throws JsonProcessingException Если происходит ошибка обработки JSON во время выполнения команды.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        Main.isRunning = false;
    }
}
