package com.jeff_media.spigotplugingeneratorplugin.dependency;

import lombok.Data;
import org.eclipse.aether.RepositoryListener;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@Data
public class Dependency implements Comparable<Dependency> {

    private final String name;
    private final Repository repository;
    private final String groupId;
    private final String artifactId;
    private final String version;
    private final Scope scope;
    private final String description;
    private final String url;

    @Override
    public int compareTo(@NotNull Dependency o) {
        return name.compareTo(o.name);
    }

    public Object[] asTableRow() {
        return new Object[] {
                false, name, url == null ? "" : "Link", description, scope
        };
    }

}
