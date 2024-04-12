package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
/**
 * Интерфейс для команд, используемых в приложении.
 * Обеспечивает выполнение действий, основанных на вводе пользователя.
 */
public interface Command {
    /**
     * Выполняет команду с использованием переданных аргументов.
     * @param args Аргументы, передаваемые команде.
     * @throws JsonProcessingException Если происходит ошибка при обработке JSON.
     * @throws FileNotFoundException Если необходимый файл не найден.
     */
    public void execute(String... args) throws JsonProcessingException, FileNotFoundException;
}
