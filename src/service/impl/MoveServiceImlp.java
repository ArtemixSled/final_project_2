package service.impl;

import config.FieldSizeConfig;
import models.abstracts.Entity;
import models.herbivores.*;
import models.island.Island;
import models.abstracts.Animal;
import models.enums.DirectionType;
import models.island.Field;
import models.predators.*;
import service.MoveService;

import java.util.*;

public class MoveServiceImlp implements MoveService {

    private final Island island;

    private FieldSizeConfig fieldSizeConfig;

    public MoveServiceImlp(Island island, FieldSizeConfig fieldSizeConfig) {
        this.island = island;
        this.fieldSizeConfig = fieldSizeConfig;
    }


    @Override
    public void move(Animal entity, Field from, DirectionType direction, int speed, int maxAnimalOnField) {
        int newX = from.getX();
        int newY = from.getY();
        int oldX = from.getX();
        int oldY = from.getY();
        switch (direction) {
            case UP:
                newY -= speed;
                break;
            case DOWN:
                newY += speed;
                break;
            case LEFT:
                newX -= speed;
                break;
            case RIGHT:
                newX += speed;
                break;
        }

        if (isWithinBounds(newX, newY) && isMaxCountAnimal(newX, newY, entity, maxAnimalOnField)) {
            moveAnimal_deleteAdd(entity, from, newX, newY, oldX, oldY);
            //System.out.println("Движение возможно");
        } //else System.out.println("Движение невозможно");
    }
    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < fieldSizeConfig.getWidth() && y >= 0 && y < fieldSizeConfig.getHeight();
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

    private void moveAnimal_deleteAdd(Animal entity, Field from, int newX, int newY, int oldX, int oldY) {
        island.getIsland().get(from).remove(entity);

        Set<Field> keys = island.getIsland().keySet();
        for (Field key : keys) {
            if (key.getX() == newX && key.getY() == newY) {
                island.getIsland().get(key).add(entity);
                break;
            }
        }
    }
}