package com.jeff_media.spigotplugingeneratorplugin;

import com.jeff_media.spigotplugingeneratorplugin.dependency.Repository;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class RepositoryList {

    private final Map<String, Repository> repositories = new HashMap<>();

    public RepositoryList() {
        try(InputStream stream = RepositoryList.class.getResourceAsStream("/repositories.yml")) {
            Map<String,Object> yaml = new Yaml().load(stream);
            for(Map.Entry<String,String> entry : yaml.entrySet()) {
                String name = entry.getKey();
                String url = entry.getValue();
                repositories.put(name, new Repository(name, url));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
