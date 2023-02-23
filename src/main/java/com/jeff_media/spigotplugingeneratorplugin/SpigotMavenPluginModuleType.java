package com.jeff_media.spigotplugingeneratorplugin;

import com.intellij.openapi.module.ModuleType;
import lombok.Getter;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SpigotMavenPluginModuleType extends ModuleType<SpigotMavenPluginModuleBuilder> {

    @Getter private static SpigotMavenPluginModuleType instance = new SpigotMavenPluginModuleType();

    public SpigotMavenPluginModuleType() {
        super("SPIGOT_MAVEN_PLUGIN");
    }

    @Override
    public @NotNull SpigotMavenPluginModuleBuilder createModuleBuilder() {
        return new SpigotMavenPluginModuleBuilder();
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getName() {
        return "Spigot Plugin";
    }

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Sentence) String getDescription() {
        return "Spigot plugin using Maven";
    }

    @Override
    public @NotNull Icon getNodeIcon(boolean isOpened) {
        return new ImageIcon();
    }
}
