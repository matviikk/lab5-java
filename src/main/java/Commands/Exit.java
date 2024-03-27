package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;

public class Exit implements Command {

    @Override
    public void execute() throws JsonProcessingException {
        Main.isRunning = false;
    }
}
