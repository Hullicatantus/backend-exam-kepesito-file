package hu.nive.ujratervezes.io.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                Files.write(Path.of(output), () -> contacts.entrySet().stream()
                        .<CharSequence>map(e -> e.getKey() + ": " + e.getValue())
                        .iterator());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}