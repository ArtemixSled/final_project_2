package models.herbivores;

import models.abstracts.Entity;

public class Duck extends Herbivores {
    public Duck(Double weight,
                   Integer maxCountOnField,
                   Integer speed,
                   Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Duck(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Duck{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
