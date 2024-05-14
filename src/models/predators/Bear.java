package models.predators;

import models.abstracts.Entity;

public class Bear extends Predator {

    public Bear(Double weight,
               Integer maxCountOnField,
               Integer speed,
               Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }


    public Bear(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Bear{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
