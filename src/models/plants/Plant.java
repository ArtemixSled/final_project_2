package models.plants;

import models.abstracts.Entity;

public abstract class Plant extends Entity {


    protected Plant(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
