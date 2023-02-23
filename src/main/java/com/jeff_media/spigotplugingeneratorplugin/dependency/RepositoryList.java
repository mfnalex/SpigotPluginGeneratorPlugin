package com.jeff_media.spigotplugingeneratorplugin.dependency;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryList {

    private final Map<String, Repository> repositories = new HashMap<>();

    public RepositoryList() {
        try(InputStream stream = RepositoryList.class.getResourceAsStream("/repositories.yml")) {
            Map<String,Object> yaml = new Yaml().load(stream);
            for(String repoName : yaml.keySet()) {
                Map<String,Object> repoMap = (Map<String, Object>) yaml.get(repoName);
                String repoUrl = (String) repoMap.get("url");
                repositories.put(repoName, new Repository(repoName, repoUrl));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Repository getRepository(String name) {
        return repositories.get(name);
    }

}
