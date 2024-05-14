package models.herbivores;

import models.abstracts.Entity;

public class Buffalo extends Herbivores {
    public Buffalo(Double weight,
                Integer maxCountOnField,
                Integer speed,
                Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Buffalo(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Boar{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
