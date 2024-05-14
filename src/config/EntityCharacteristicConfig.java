package config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.abstracts.Entity;
import models.enums.EntityType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EntityCharacteristicConfig {
    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {
        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {
        HashMap<EntityType, Entity> entityMapConfig = new HashMap<>();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(pathToJson));

            for (EntityType entityType : EntityType.values()) {
                JsonNode entityNode = rootNode.get(entityType.toString().toLowerCase());

                Double weight = entityNode.get("weight").asDouble();
                Integer maxCountOnField = entityNode.get("maxCountOnField").asInt();
                Integer speed = entityNode.get("speed").asInt();
                Double kgToFullEating = entityNode.get("kgToFullEating").asDouble();

                entityMapConfig.put(entityType, new Entity(weight, maxCountOnField, speed, kgToFullEating));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.entityMapConfig = entityMapConfig;
    }
}