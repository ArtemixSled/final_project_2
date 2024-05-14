package service;

import models.abstracts.Animal;
import models.enums.DirectionType;
import models.island.Field;

public interface MoveService {

    void move(Animal entityToMove, Field from, DirectionType direction, int speed, int maxAnimalOnField);
}
