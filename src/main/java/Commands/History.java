package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Main;

public class History implements Command {
    @Override
    public void execute() throws JsonProcessingException {
        System.out.println(Main.history);
    }
}