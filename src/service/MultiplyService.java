package service;

import config.EntityCharacteristicConfig;
import models.abstracts.Animal;
import models.island.Field;

import java.util.List;

public interface MultiplyService {

    void multiply(List<Animal> entities, Field from, EntityCharacteristicConfig entityCharacteristicConfig);
}
