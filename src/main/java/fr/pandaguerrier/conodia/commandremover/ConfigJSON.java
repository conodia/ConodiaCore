package fr.pandaguerrier.conodia.commandremover;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigJSON {
    public String unvailableCommand = "n'avez pas le droit d'utiliser cette commande.";

    public List<String> commandList = new ArrayList<>(Arrays.asList(new String[] { "testCommand", "testCommand" }));
}
