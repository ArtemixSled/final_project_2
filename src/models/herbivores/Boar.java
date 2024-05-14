package models.herbivores;

import models.abstracts.Entity;

public class Boar extends Herbivores {
    public Boar(Double weight,
                 Integer maxCountOnField,
                 Integer speed,
                 Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Boar(Entity entity) {
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
