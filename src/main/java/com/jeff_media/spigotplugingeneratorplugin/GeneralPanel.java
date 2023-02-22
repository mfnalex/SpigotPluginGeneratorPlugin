package com.jeff_media.spigotplugingeneratorplugin;

import javax.swing.*;
import java.awt.*;

public class SpigotMavenPluginBuilderPanel extends JPanel {

    private final JTextField pluginName = new JTextField("MyPlugin");
    private final JTextField author = new JTextField("MyUsername");

    private final JTextField groupId = new JTextField("me.myusername");
    private final JTextField artifactId = new JTextField("myplugin");
    private final JTextField version = new JTextField("1.0-SNAPSHOT");

    private final JTextField packageName = new JTextField("me.myusername.myplugin");
    private final JTextField mainClass = new JTextField("MyPlugin");

    private final JTextField spigotVersion = new JTextField("1.19.3");
    private final JCheckBox useBukkit = new JCheckBox("Include MS / CraftBukkit dependency", false);
    private final JTextField javaVersion = new JTextField("17");

    private final JCheckBox addStaticGetter = new JCheckBox("Add static getter for main istance", true);
    private final JCheckBox useKotlin = new JCheckBox("Use Kotlin instead of Java", false);

    public SpigotMavenPluginBuilderPanel() {
        setLayout(new GridBagLayout());

        add(new JLabel("Plugin name"), Constraints.get(0, 0, 0.5, 0, 1));
        add(pluginName, Constraints.get(1, 0, 0.5, 0, 1));

        add(new JLabel("Author"), Constraints.get(0, 1, 0.5, 0, 1));
        add(author, Constraints.get(1, 1, 0.5, 0, 1));

        add(new JSeparator(), Constraints.get(0, 2, 1, 0, 2));

        add(new JLabel("Group ID"), Constraints.get(0, 3, 0.5, 0, 1));
        add(groupId, Constraints.get(1, 3, 0.5, 0, 1));

        add(new JLabel("Artifact ID"), Constraints.get(0, 4, 0.5, 0, 1));
        add(artifactId, Constraints.get(1, 4, 0.5, 0, 1));

        add(new JLabel("Version"), Constraints.get(0, 5, 0.5, 0, 1));
        add(version, Constraints.get(1, 5, 0.5, 0, 1));

        add(new JSeparator(), Constraints.get(0, 6, 1, 0, 2));

        add(new JLabel("Package name"), Constraints.get(0, 7, 0.5, 0, 1));
        add(packageName, Constraints.get(1, 7, 0.5, 0, 1));

        add(new JLabel("Main class"), Constraints.get(0, 8, 0.5, 0, 1));
        add(mainClass, Constraints.get(1, 8, 0.5, 0, 1));

        add(new JSeparator(), Constraints.get(0, 9, 1, 0, 2));

        add(new JLabel("Spigot version"), Constraints.get(0, 10, 0.5, 0, 1));
        add(spigotVersion, Constraints.get(1, 10, 0.5, 0, 1));

        add(useBukkit, Constraints.get(0, 11, 1, 0, 2));

        add(new JLabel("Java version"), Constraints.get(0, 12, 0.5, 0, 1));
        add(javaVersion, Constraints.get(1, 12, 0.5, 0, 1));

        add(new JSeparator(), Constraints.get(0, 13, 1, 0, 2));

        add(addStaticGetter, Constraints.get(0, 14, 1, 0, 2));

        add(useKotlin, Constraints.get(0, 15, 1, 0, 2));





    }


}
