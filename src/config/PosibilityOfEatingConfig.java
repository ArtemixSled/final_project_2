package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.EntityType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PosibilityOfEatingConfig {
    private Map<Map<EntityType, EntityType>, Long> possibilityOEating;

    public Map<Map<EntityType, EntityType>, Long> getPossibilityOEating() {
        return possibilityOEating;
    }

    public PosibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) {
        HashMap<Map<EntityType, EntityType>, Long> possibilityOEating = new HashMap<>();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(pathToJson));

            for (JsonNode node : rootNode) {
                String from = node.get("from").asText();
                String to = node.get("to").asText();
                int percent = node.get("percent").asInt();

                EntityType fromEntityType = EntityType.valueOf(from.toUpperCase());
                EntityType toEntityType = EntityType.valueOf(to.toUpperCase());

                Map<EntityType, EntityType> animalMap = new HashMap<>();
                animalMap.put(fromEntityType, toEntityType);

                possibilityOEating.put(animalMap, (long) percent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.possibilityOEating = possibilityOEating;
    }
}
