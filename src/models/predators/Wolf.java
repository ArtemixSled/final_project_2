package models.predators;

import models.abstracts.Entity;

public class Wolf extends Predator {

    public Wolf(Double weight,
                Integer maxCountOnField,
                Integer speed,
                Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }


    public Wolf(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
