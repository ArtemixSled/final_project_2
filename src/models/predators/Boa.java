package models.predators;

import models.abstracts.Entity;

public class Boa extends Predator {

    public Boa(Double weight,
                Integer maxCountOnField,
                Integer speed,
                Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }


    public Boa(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Boa{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
