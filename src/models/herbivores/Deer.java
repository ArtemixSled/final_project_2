package models.herbivores;

import models.abstracts.Entity;

public class Deer extends Herbivores {
    public Deer(Double weight,
                 Integer maxCountOnField,
                 Integer speed,
                 Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Deer(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Deer{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
