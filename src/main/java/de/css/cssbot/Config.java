package de.css.cssbot;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;

public class Config {

    private static Path PATH_TO_CONFIG;
    private final String discordToken;

    public Config() throws IOException {
        final Properties props = getProperties();

        this.discordToken = Objects.requireNonNull(props.getProperty("token"), "Discord Token not set");
    }

    public static void setPathToConfig(Path path) {
        PATH_TO_CONFIG = path;
    }

    public String getDiscordToken() {
        return discordToken;
    }

    private Properties getProperties() throws IOException {

        final Properties props = new Properties();
        try (InputStream stream = Files.newInputStream(PATH_TO_CONFIG)) {
            props.load(stream);
        }
        return props;
    }
}
