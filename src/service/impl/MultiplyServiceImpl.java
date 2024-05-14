package service.impl;

import config.EntityCharacteristicConfig;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.EntityType;
import models.herbivores.*;
import models.island.Field;
import models.island.Island;
import models.predators.*;
import service.MultiplyService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static main.Main.multiply_count;
public class MultiplyServiceImpl implements MultiplyService {
    private final Island island;
    public MultiplyServiceImpl(Island island) {
        this.island = island;
    }

    @Override
    public void multiply(List<Animal> entities, Field field, EntityCharacteristicConfig entityCharacteristicConfig) {
        int newX = field.getX();
        int newY = field.getY();
        for (EntityType entityType : EntityType.values()) {
            //?
            int count = 0;
            for (Animal entity : entities) {
                if (entityType.getClazz().isInstance(entity) && entity.isDead() == false) { //&& entity.isDead() == false
                    count++;
                }
                if (count == 2) {
                    int maxAnimalOnField = getMaxCountOnField(entityCharacteristicConfig, entityType);
                    if (isMaxCountAnimal(newX, newY, entity, maxAnimalOnField)) {
                        multiplyAnimal_Add(entity, newX, newY);
                    }
                    count = 0;
                }

            }
        }
    }
    private void multiplyAnimal_Add(Animal animal, int newX, int newY) {
        Set<Field> keys = island.getIsland().keySet();
        for (Field key : keys) {
            if (key.getX() == newX && key.getY() == newY && !animal.isDead()) {
                Animal newAnimal = animal.clone();
                newAnimal.setSatiety_left(newAnimal.getSATIETY_MAX());
                island.getIsland().get(key).add(newAnimal);
                multiply_count++;
                break;
            }
        }
    }


    private boolean isMaxCountAnimal(int x, int y, Animal animal, int maxAnimalOnField) {
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            if (field.getX() == x && field.getY() == y) {
                List<Entity> entities = fieldListEntry.getValue();
                int count = 0;
                for (Entity entity : entities) {
                    if (entity instanceof Wolf && animal instanceof Wolf) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    } else if (entity instanceof Mouse && animal instanceof Mouse) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Bear && animal instanceof Bear) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Boa && animal instanceof Boa) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Eagle && animal instanceof Eagle) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Fox && animal instanceof Fox) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Boar && animal instanceof Boar) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Buffalo && animal instanceof Buffalo) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Caterpillar && animal instanceof Caterpillar) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Deer && animal instanceof Deer) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Duck && animal instanceof Duck) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Goat && animal instanceof Goat) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Horse && animal instanceof Horse) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Rabbit && animal instanceof Rabbit) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                    else if (entity instanceof Sheep && animal instanceof Sheep) {
                        count++;
                        if (count >= maxAnimalOnField) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }
}
