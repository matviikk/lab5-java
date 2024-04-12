package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;
/**
 * Команда для вывода истории последних выполненных команд.
 */
public class History implements Command {
    /**
     * Выполняет команду, выводя историю последних команд, введённых пользователем.
     * @param args Аргументы команды (не используются в этой команде).
     * @throws JsonProcessingException Если в процессе выполнения команды возникнут ошибки обработки JSON.
     */
    @Override
    public void execute(String... args) throws JsonProcessingException {
        System.out.println(Main.history);
    }
}
