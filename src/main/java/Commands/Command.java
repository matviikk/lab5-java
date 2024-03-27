package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Command {
    public void execute() throws JsonProcessingException, FileNotFoundException;
}
