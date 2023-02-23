package com.jeff_media.spigotplugingeneratorplugin.dependency;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repository implements Comparable<Repository> {

    @NotNull private final String name;

    @NotNull private final String url;

    public Repository(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return name.equals(that.name) && url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }


    @Override
    public int compareTo(@NotNull Repository o) {
        return name.compareTo(o.name);
    }
}
