package de.css.cssbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;


public class Launcher {

    private static Logger logger = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) throws IOException {

        final String pathToConfig = Arrays.stream(args)
                .filter(s -> s.startsWith("pathToConfig"))
                .findFirst()
                .orElse("./config.properties");

        Config.setPathToConfig(Path.of(pathToConfig));

        Config config = new Config();

        logger.info("test info Log");
        logger.warn("warn log");

        System.out.println(config.getDiscordToken());
    }
}
