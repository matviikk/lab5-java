package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;

public interface Command {
    public void execute(String... args) throws JsonProcessingException, FileNotFoundException;
}
