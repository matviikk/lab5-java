package Commands;

import utility.CommandManager;

import java.util.Map;

/**
 * Команда для отображения справочной информации по доступным командам в приложении.
 */
public class Help extends AbstractCommand {
    private final CommandManager commandManager;
    public Help(CommandManager commandManager) {
        super("help", "вывести справку по доступным командам");
        this.commandManager = commandManager;
    }

    /**
     * Выводит в стандартный поток вывода список доступных команд с их описанием.
     * @param args Аргументы команды (не используются в этой команде).
     */
//    @Override
//    public void execute(String... args) {
//        for (Map.Entry<String, Command> entry: commandManager.getCommands().entrySet()) {
//            System.out.println(entry.getValue().getName() + " : " + entry.getValue().getDescription());
//        }
//    }
//    }
    @Override
    public void execute(String... args) {
        System.out.println("Available commands:");
        System.out.println("-------------------");
        for (Map.Entry<String, Command> entry : commandManager.getCommands().entrySet()) {
            // Использование String.format для улучшения форматирования вывода
            String output = String.format("%-35s : %s", entry.getValue().getName(), entry.getValue().getDescription());
            System.out.println(output);
        }
    }
}
