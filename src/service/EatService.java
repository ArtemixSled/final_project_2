package service;

import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.DirectionType;
import models.island.Field;

import java.util.List;

public interface EatService {

    void eat(List<Entity> entities, Field from);
}
