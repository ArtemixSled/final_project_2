package models.herbivores;

import models.abstracts.Entity;

public class Mouse extends Herbivores {
    public Mouse(Double weight,
                Integer maxCountOnField,
                Integer speed,
                Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Mouse(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "weight=" + weight +
                ", maxCountOnField=" + maxCountOnField +
                ", speed=" + speed +
                ", kgToFullEating=" + kgToFullEating +
                '}';
    }
}
