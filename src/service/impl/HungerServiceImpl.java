package service.impl;

import config.FieldSizeConfig;
import models.abstracts.Animal;
import models.island.Field;
import models.island.Island;
import service.HungerService;

import java.util.Set;

import static main.Main.dead_hunger_count;

public class HungerServiceImpl implements HungerService {

    private final Island island;
    private FieldSizeConfig fieldSizeConfig;

    public HungerServiceImpl(Island island, FieldSizeConfig fieldSizeConfig) {
        this.island = island;
        this.fieldSizeConfig = fieldSizeConfig;
    }
    @Override
    public void starvation(Animal animal, Field from) {
        int X = from.getX();
        int Y = from.getY();

        animal.setSatiety_left(animal.getSatiety_left() - animal.getSTARVING_FOR_A_DAY());

        if (animal.getSatiety_left() <= 0) {
            hungerAnimal_delete(animal, from, X, Y);
            dead_hunger_count++;
        }

    }
    private void hungerAnimal_delete(Animal entity, Field from, int X, int Y) {

        Set<Field> keys = island.getIsland().keySet();
        for (Field key : keys) {
            if (key.getX() == X && key.getY() == Y) {
                //System.out.println("Умер " + entity + " координаты: " + X + " - " + Y);
                island.getIsland().get(from).remove(entity);
                break;
            }
        }
    }
}
