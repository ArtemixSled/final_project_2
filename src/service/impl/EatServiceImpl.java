package service.impl;

import config.PosibilityOfEatingConfig;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.EntityType;
import models.herbivores.Herbivores;
import models.island.Field;
import models.island.Island;
import models.plants.Plant;
import models.predators.Predator;
import models.predators.Wolf;
import service.EatService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static main.Main.dead_hunting_count;

public class EatServiceImpl implements EatService {
    private final Island island;
    private final PosibilityOfEatingConfig posibilityOfEatingConfig;
    Random random = new Random();

    public EatServiceImpl(Island island, PosibilityOfEatingConfig posibilityOfEatingConfig) {
        this.island = island;
        this.posibilityOfEatingConfig = posibilityOfEatingConfig;
    }


    @Override
    public void eat(List<Entity> entities, Field field) {
        Map<Map<EntityType, EntityType>, Long> possibilityOEating = posibilityOfEatingConfig.getPossibilityOEating();
        Set<Map<EntityType, EntityType>> keys = possibilityOEating.keySet();

        List<Animal> animals = entities.stream()
                .filter(entity -> entity instanceof Animal)
                .map(entity -> (Animal) entity)
                .toList();

        for (Animal animal : animals) {
            animal.setHuntedInThisLap(false);
        }

        int newX = field.getX();
        int newY = field.getY();

        for (Animal hunter : animals) {

            if (hunter.isDead() == false && hunter.isHuntedInThisLap() == false) {
                for (Entity victim : entities) {
                    if (NotFriendlyFire(hunter, victim) == true && victim.isDead() == false) {
                        for (Map.Entry<Map<EntityType, EntityType>, Long> entry : possibilityOEating.entrySet()) {
                            Map<EntityType, EntityType> key = entry.getKey();
                            Long percent = entry.getValue();

                            for (Map.Entry<EntityType, EntityType> from_to : key.entrySet()) {
                                EntityType from = null;
                                EntityType to = null;
                                from = from_to.getKey();
                                to = from_to.getValue();
                                int probability_of_attack = random.nextInt(101);
                                if (eat_if(hunter, victim, from, to) == true && percent != 0) {
                                    hunter.setHuntedInThisLap(true);
                                    if(probability_of_attack < percent) {
                                        victim.setDead(true);
                                        hunger(hunter, victim);
                                        //System.out.println("Убили: " + victim + " hunter: " + hunter + " from: " + from + " to: " + to);
                                        eatAnimal_Delete(victim, newX, newY, percent);
                                        from = null;
                                        to = null;
                                        break;
                                    } else break;
                                } else {
                                    from = null;
                                    to = null;
                                    break;
                                }
                            }
                            if (hunter.isHuntedInThisLap() == true) {
                               break;
                            }
                        }
                    } 
                    if (hunter.isHuntedInThisLap() == true) {
                        break;
                    }
                }
            }
        }
    }

    private static void hunger(Animal hunter, Entity victim) {
        double satiety_add = victim.getWeight() / hunter.getSaturation_KG_for_a_day();
        hunter.setSatiety_left(hunter.getSatiety_left() + satiety_add);

        if (satiety_add > hunter.getSATIETY_MAX() ) {
            hunter.setSatiety_left(hunter.getSATIETY_MAX());
        }
    }

    private static boolean eat_if(Animal hunter, Entity victim, EntityType from, EntityType to) {
        boolean canEat = from.getClazz().isInstance(hunter) && to.getClazz().isInstance(victim);
        if (canEat) {
            //System.out.println("Хищник " + from + " может съесть жертву " + to);
        } else {
            //System.out.println("Хищник " + from + " не может съесть жертву " + to);
        }
        return canEat;
    }
    private static boolean NotFriendlyFire(Animal hunter, Entity victim) {
        for (EntityType entityType : EntityType.values()) {
            if (entityType.getClazz().isInstance(hunter) && entityType.getClazz().isInstance(victim)) {
                return false;
            }
        }
        return true;
    }
    private void eatAnimal_Delete(Entity entity, int newX, int newY, Long percent) {

        Set<Field> keys = island.getIsland().keySet();
        for (Field key : keys) {
            if (key.getX() == newX && key.getY() == newY) {
                if (entity.isDead() == true) {
                    island.getIsland().get(key).remove(entity);
                    dead_hunting_count++;
                }
                break;
            }
        }
    }
}
