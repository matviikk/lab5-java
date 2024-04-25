package Commands;
/**
 * AbstractCommand предоставляет базовую реализацию для интерфейса {@link Command},
 * инкапсулируя общие свойства, такие как имя и описание.
 * Этот класс служит основой для всех команд в системе.
 */
public abstract class AbstractCommand implements Command {
    private String name;
    private String description;
    /**
     * Конструктор для создания новой команды с указанным именем и описанием.
     *
     * @param name имя команды
     * @param description краткое описание действия команды
     */
    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /**
     * Получает имя команды.
     *
     * @return имя команды
     */
    public String getName() {
        return name;
    }
    /**
     * Устанавливает новое имя для команды.
     *
     * @param name новое имя команды
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Получает описание команды.
     *
     * @return описание команды
     */
    public String getDescription() {
        return description;
    }
    /**
     * Устанавливает новое описание для команды.
     *
     * @param description новое описание команды
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
