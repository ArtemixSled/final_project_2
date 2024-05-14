package models.herbivores;

import models.abstracts.Animal;

public abstract class Herbivores extends Animal {

    protected Herbivores(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
