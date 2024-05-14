package models.herbivores;

import models.abstracts.Entity;

public class Caterpillar extends Herbivores {

    public Caterpillar(Double weight,
                Integer maxCountOnField,
                Integer speed,
                Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Caterpillar(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Caterpillar{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
