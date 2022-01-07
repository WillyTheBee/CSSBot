package de.css.cssbot;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) throws IOException {

        final String pathToConfig = Arrays.stream(args)
                .filter(s -> s.startsWith("pathToConfig"))
                .findFirst()
                .orElse("src/config.properties");

        Config.setPathToConfig(Path.of(pathToConfig));

        Config config = new Config();
        System.out.println(config.getDiscordToken());
    }
}
