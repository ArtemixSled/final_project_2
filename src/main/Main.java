package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.EntityCharacteristicConfig;
import config.FieldSizeConfig;
import config.PosibilityOfEatingConfig;
import models.herbivores.*;
import models.island.Island;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.EntityType;
import models.island.Field;
import models.plants.Grass;
import models.plants.Plant;
import models.predators.*;
import service.EatService;
import service.HungerService;
import service.MoveService;
import service.MultiplyService;
import service.impl.*;

import java.util.Map.Entry;
import java.util.*;
import java.util.stream.IntStream;
public class Main {
    public static int day = 0;
    public static int multiply_count = 0;
    public static int dead_hunting_count = 0;
    public static int dead_hunger_count = 0;
    public static int count_animal_start = 0;
    public static int count_Wolf_start = 0;
    public static int count_Mouse_start = 0;
    public static int count_Grass_start = 0;
    public static int count_Bear_start = 0;
    public static int count_Boa_start = 0;
    public static int count_Eagle_start = 0;
    public static int count_Fox_start = 0;
    public static int count_Boar_start = 0;
    public static int count_Buffalo_start = 0;
    public static int count_Caterpillar_start = 0;
    public static int count_Deer_start = 0;
    public static int count_Duck_start = 0;
    public static int count_Goat_start = 0;
    public static int count_Horse_start = 0;
    public static int count_Rabbit_start = 0;
    public static int count_Sheep_start = 0;

    public static void main(String[] args) {

        Random random = new Random();
        ObjectMapper objectMapper = new ObjectMapper();
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, "resources/entity_characteristic.json");
        PosibilityOfEatingConfig posibilityOfEatingConfig = new PosibilityOfEatingConfig(objectMapper, "resources/posibility_of_eating.json");
        FieldSizeConfig fieldSizeConfig = new FieldSizeConfig(5, 5);

        ChooseDirectionServiceImpl chooseDirectionServiceImpl = new ChooseDirectionServiceImpl(random);

        Island island = createIsland(fieldSizeConfig);
        MoveService moveService = new MoveServiceImlp(island, fieldSizeConfig);
        MultiplyService multiplyService = new MultiplyServiceImpl(island);
        EatService eatService = new EatServiceImpl(island, posibilityOfEatingConfig);
        HungerService hungerService = new HungerServiceImpl(island, fieldSizeConfig);

        int maxPlantsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.GRASS);
        int maxWolfOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.WOLF);
        int maxMouseOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.MOUSE);
        int maxBearOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.BEAR);
        int maxBoaOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.BOA);
        int maxEagleOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.EAGLE);
        int maxFoxOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.FOX);
        int maxBoarOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.BOAR);
        int maxBuffaloOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.BUFFALO);
        int maxCaterpillarOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.CATERPILLAR);
        int maxDeerOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.DEER);
        int maxDuckOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.DUCK);
        int maxGoatOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.GOAT);
        int maxHorseOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.HORSE);
        int maxRabbitOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.RABBIT);
        int maxSheepOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.SHEEP);

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxMouseOnField))
                        .mapToObj(i -> createMouse(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxPlantsOnField))
                        .mapToObj(i -> createGrass(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxWolfOnField))
                        .mapToObj(i -> createWolf(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxBearOnField))
                        .mapToObj(i -> createBear(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxBoaOnField))
                        .mapToObj(i -> createBoa(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxEagleOnField))
                        .mapToObj(i -> createEagle(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxFoxOnField))
                        .mapToObj(i -> createFox(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxBoarOnField))
                        .mapToObj(i -> createBoar(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxBuffaloOnField))
                        .mapToObj(i -> createBuffalo(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxCaterpillarOnField))
                        .mapToObj(i -> createCaterpillar(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxDeerOnField))
                        .mapToObj(i -> createDeer(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxDuckOnField))
                        .mapToObj(i -> createDuck(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxGoatOnField))
                        .mapToObj(i -> createGoat(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxHorseOnField))
                        .mapToObj(i -> createHorse(entityCharacteristicConfig))
                        .forEach(value::add));

        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxRabbitOnField))
                        .mapToObj(i -> createRabbit(entityCharacteristicConfig))
                        .forEach(value::add));
        island.getIsland().values()
                .forEach(value -> IntStream.range(0, random.nextInt(maxSheepOnField))
                        .mapToObj(i -> createSheep(entityCharacteristicConfig))
                        .forEach(value::add));

        statistic_animal_count_start(island);
        while (true) {
            System.out.println("Общее количество животных на старте: " + count_animal_start);
            System.out.println("Количество волков на старте: " + count_Wolf_start);
            System.out.println("Количество мышей на старте: " + count_Mouse_start);
            System.out.println("Количество травы на старте: " + count_Grass_start);
            System.out.println("Количество медведей на старте: " + count_Bear_start);
            System.out.println("Количество удавов на старте: " + count_Boa_start);
            System.out.println("Количество орлов на старте: " + count_Eagle_start);
            System.out.println("Количество лис на старте: " + count_Fox_start);
            System.out.println("Количество буйвалов на старте: " + count_Buffalo_start);
            System.out.println("Количество гусениц на старте: " + count_Caterpillar_start);
            System.out.println("Количество оленей на старте: " + count_Deer_start);
            System.out.println("Количество уток на старте: " + count_Duck_start);
            System.out.println("Количество лошадей на старте: " + count_Horse_start);
            System.out.println("Количество кроликов на старте: " + count_Rabbit_start);
            System.out.println("Количество овец на старте: " + count_Sheep_start);
            System.out.println("Количество козлов на старте: " + count_Goat_start);
            System.out.println("Количество кабанов на старте: " + count_Boar_start);

            System.out.println("Загрузка...");
            day++;
            moveGame(island, entityCharacteristicConfig, chooseDirectionServiceImpl, moveService);
            hungerGame(island, hungerService);
            eatGame(island, posibilityOfEatingConfig, eatService);
            multiplyGame(island, multiplyService, entityCharacteristicConfig);
            createGrassEveryDay(island, maxPlantsOnField, random, entityCharacteristicConfig);

            System.out.println("---------------------------------------------------------");
            System.out.println("Конец дня " + day);
            System.out.println("Родилось новых животных: " + multiply_count);
            System.out.println("Было съедено животных: " + dead_hunting_count);
            System.out.println("Умерло животных от голода: " + dead_hunger_count);

            multiply_count = 0;
            dead_hunting_count = 0;
            dead_hunger_count = 0;
            statistic_animal_count(island);
            System.out.println("---------------------------------------------------------");
        }
    }

    private static void statistic_animal_count_start(Island island) {

        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            List<Animal> animals = countEntities(fieldListEntry.getValue(), Animal.class);
            count_animal_start += animals.size();

            List<Wolf> wolves = countEntities(fieldListEntry.getValue(), Wolf.class);
            count_Wolf_start += wolves.size();

            List<Mouse> mice = countEntities(fieldListEntry.getValue(), Mouse.class);
            count_Mouse_start += mice.size();

            List<Plant> grass = countEntities(fieldListEntry.getValue(), Plant.class);
            count_Grass_start += grass.size();

            List<Boar> boar = countEntities(fieldListEntry.getValue(), Boar.class);
            count_Boar_start += boar.size();

            List<Buffalo> buffalo = countEntities(fieldListEntry.getValue(), Buffalo.class);
            count_Buffalo_start += buffalo.size();

            List<Caterpillar> caterpillar = countEntities(fieldListEntry.getValue(), Caterpillar.class);
            count_Caterpillar_start += caterpillar.size();

            List<Deer> deer = countEntities(fieldListEntry.getValue(), Deer.class);
            count_Deer_start += deer.size();

            List<Duck> duck = countEntities(fieldListEntry.getValue(), Duck.class);
            count_Duck_start += duck.size();

            List<Goat> goat = countEntities(fieldListEntry.getValue(), Goat.class);
            count_Goat_start += goat.size();

            List<Horse> horse = countEntities(fieldListEntry.getValue(), Horse.class);
            count_Horse_start += horse.size();

            List<Rabbit> rabbit = countEntities(fieldListEntry.getValue(), Rabbit.class);
            count_Rabbit_start += rabbit.size();

            List<Sheep> sheep = countEntities(fieldListEntry.getValue(), Sheep.class);
            count_Sheep_start += sheep.size();

            List<Bear> bear = countEntities(fieldListEntry.getValue(), Bear.class);
            count_Bear_start += bear.size();

            List<Eagle> eagle = countEntities(fieldListEntry.getValue(), Eagle.class);
            count_Eagle_start += eagle.size();

            List<Fox> fox = countEntities(fieldListEntry.getValue(), Fox.class);
            count_Fox_start += fox.size();

            List<Boa> boa = countEntities(fieldListEntry.getValue(), Boa.class);
            count_Boa_start += boa.size();
        }
    }

    private static <T> List<T> countEntities(List<Entity> entities, Class<T> type) {
        return entities.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    private static void statistic_animal_count(Island island) {
        int count_animal = 0;
        int count_Wolf = 0;
        int count_Mouse = 0;
        int count_Grass = 0;
        int count_Bear = 0;
        int count_Boa = 0;
        int count_Eagle = 0;
        int count_Fox = 0;
        int count_Boar = 0;
        int count_Buffalo = 0;
        int count_Caterpillar = 0;
        int count_Deer = 0;
        int count_Duck = 0;
        int count_Goat = 0;
        int count_Horse = 0;
        int count_Rabbit = 0;
        int count_Sheep = 0;

        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            List<Animal> animals = countEntities(fieldListEntry.getValue(), Animal.class);
            count_animal += animals.size();

            List<Wolf> wolves = countEntities(fieldListEntry.getValue(), Wolf.class);
            count_Wolf += wolves.size();

            List<Mouse> mice = countEntities(fieldListEntry.getValue(), Mouse.class);
            count_Mouse += mice.size();

            List<Plant> grass = countEntities(fieldListEntry.getValue(), Plant.class);
            count_Grass += grass.size();

            List<Bear> bear = countEntities(fieldListEntry.getValue(), Bear.class);
            count_Bear += bear.size();

            List<Boa> Boa = countEntities(fieldListEntry.getValue(), Boa.class);
            count_Boa += Boa.size();

            List<Eagle> eagle = countEntities(fieldListEntry.getValue(), Eagle.class);
            count_Eagle += eagle.size();

            List<Fox> fox = countEntities(fieldListEntry.getValue(), Fox.class);
            count_Fox += fox.size();

            List<Boar> boar = countEntities(fieldListEntry.getValue(), Boar.class);
            count_Boar += boar.size();

            List<Buffalo> buffalo = countEntities(fieldListEntry.getValue(), Buffalo.class);
            count_Buffalo += buffalo.size();

            List<Caterpillar> caterpillar = countEntities(fieldListEntry.getValue(), Caterpillar.class);
            count_Caterpillar += caterpillar.size();

            List<Deer> deer = countEntities(fieldListEntry.getValue(), Deer.class);
            count_Deer += deer.size();

            List<Duck> duck = countEntities(fieldListEntry.getValue(), Duck.class);
            count_Duck += duck.size();

            List<Goat> goat = countEntities(fieldListEntry.getValue(), Goat.class);
            count_Goat += goat.size();

            List<Horse> horse = countEntities(fieldListEntry.getValue(), Horse.class);
            count_Horse += horse.size();

            List<Rabbit> rabbit = countEntities(fieldListEntry.getValue(), Rabbit.class);
            count_Rabbit += rabbit.size();

            List<Sheep> sheep = countEntities(fieldListEntry.getValue(), Sheep.class);
            count_Sheep += sheep.size();
        }

        System.out.println("Общее количество животных на текущий момент: " + count_animal);
        System.out.println("Количество волков на текущий момент: " + count_Wolf);
        System.out.println("Количество мышей на текущий момент: " + count_Mouse);
        System.out.println("Количество травы на текущий момент: " + count_Grass);
        System.out.println("Количество медведей на текущий момент: " + count_Bear);
        System.out.println("Количество удавов на текущий момент: " + count_Boa);
        System.out.println("Количество орлов на текущий момент: " + count_Eagle);
        System.out.println("Количество лис на текущий момент: " + count_Fox);
        System.out.println("Количество буйвалов на текущий момент: " + count_Buffalo);
        System.out.println("Количество гусениц на текущий момент: " + count_Caterpillar);
        System.out.println("Количество оленей на текущий момент: " + count_Deer);
        System.out.println("Количество уток на текущий момент: " + count_Duck);
        System.out.println("Количество лошадей на текущий момент: " + count_Horse);
        System.out.println("Количество кроликов на текущий момент: " + count_Rabbit);
        System.out.println("Количество овец на текущий момент: " + count_Sheep);
        System.out.println("Количество козлов на текущий момент: " + count_Goat);
        System.out.println("Количество кабанов на текущий момент: " + count_Boar);
    }

    private static void createGrassEveryDay(Island island, int maxPlantsOnField, Random random, EntityCharacteristicConfig entityCharacteristicConfig) {
        island.getIsland().values()
                .forEach(value -> {
                    long grassCount = value.stream().filter(entity -> entity instanceof Grass).count();
                    long remainingGrassToAdd = Math.min(maxPlantsOnField - grassCount, random.nextInt(maxPlantsOnField));

                    IntStream.range(0, (int) remainingGrassToAdd)
                            .mapToObj(i -> createGrass(entityCharacteristicConfig))
                            .forEach(value::add);
                });
    }

    private static void hungerGame(Island island, HungerService hungerService) {
        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(Animal.class::isInstance)
                    .map(el -> (Animal) el)
                    .toList();
            for (Animal entity : entities) {
                hungerService.starvation(entity, field);
            }

        }
    }

    private static void multiplyGame(Island island, MultiplyService multiplyService, EntityCharacteristicConfig entityCharacteristicConfig) {
        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(Animal.class::isInstance)
                    .map(el -> (Animal) el)
                    .toList();
            multiplyService.multiply(entities, field, entityCharacteristicConfig);
        }
    }

    private static void eatGame(Island island, PosibilityOfEatingConfig posibilityOfEatingConfig, EatService eatService) {
        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Entity> entities = fieldListEntry.getValue();
            eatService.eat(entities, field);
        }
    }

    private static void moveGame(Island island, EntityCharacteristicConfig entityCharacteristicConfig, ChooseDirectionServiceImpl chooseDirectionServiceImpl, MoveService moveService) {
        Random random = new Random();
        for (Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(Animal.class::isInstance)
                    .map(el -> (Animal) el)
                    .toList();

            int speed;
            int maxAnimalOnField;
            for (Animal entity : entities) {
                EntityType entityType = getEntityType(entity);
                speed = getSpeed(entityCharacteristicConfig, entityType);
                maxAnimalOnField = getMaxCountOnField(entityCharacteristicConfig, entityType);

                var directionToMove = chooseDirectionServiceImpl.chooseDirection();
                speed = random.nextInt(speed);
                moveService.move(entity, field, directionToMove, speed, maxAnimalOnField);
            }

        }
    }
    private static EntityType getEntityType(Entity entity) {
        if (entity instanceof Wolf) {
            return EntityType.WOLF;
        } else if (entity instanceof Mouse) {
            return EntityType.MOUSE;
        }
        else if (entity instanceof Bear) {
            return EntityType.BEAR;
        }
        else if (entity instanceof Boa) {
            return EntityType.BOA;
        }
        else if (entity instanceof Eagle) {
            return EntityType.EAGLE;
        }
        else if (entity instanceof Fox) {
            return EntityType.FOX;
        }
        else if (entity instanceof Boar) {
            return EntityType.BOAR;
        }
        else if (entity instanceof Buffalo) {
            return EntityType.BUFFALO;
        }
        else if (entity instanceof Deer) {
            return EntityType.DEER;
        }
        else if (entity instanceof Duck) {
            return EntityType.DUCK;
        }
        else if (entity instanceof Goat) {
            return EntityType.GOAT;
        }
        else if (entity instanceof Horse) {
            return EntityType.HORSE;
        }
        else if (entity instanceof Rabbit) {
            return EntityType.RABBIT;
        }
        else if (entity instanceof Sheep) {
            return EntityType.SHEEP;
        }
        else if (entity instanceof Caterpillar) {
            return EntityType.CATERPILLAR;
        }
        else {
            throw new IllegalArgumentException("Неизвестный тип сущности: " + entity.getClass().getName());
        }
    }


    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
    }

    private static Wolf createWolf(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Wolf(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.WOLF));
    }
    private static Mouse createMouse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Mouse(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.MOUSE));
    }

    private static Boar createBoar(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Boar(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BOAR));
    }

    private static Buffalo createBuffalo(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Buffalo(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BUFFALO));
    }
    private static Caterpillar createCaterpillar(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Caterpillar(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.CATERPILLAR));
    }
    private static Deer createDeer(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Deer(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.DEER));
    }

    private static Duck createDuck(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Duck(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.DUCK));
    }
    private static Goat createGoat(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Goat(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GOAT));
    }
    private static Horse createHorse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Horse(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.HORSE));
    }

    private static Rabbit createRabbit(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Rabbit(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.RABBIT));
    }
    private static Sheep createSheep(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Sheep(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.SHEEP));
    }
    private static Bear createBear(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Bear(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BEAR));
    }

    private static Boa createBoa(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Boa(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.BOA));
    }
    private static Eagle createEagle(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Eagle(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.EAGLE));
    }
    private static Fox createFox(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Fox(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.FOX));
    }

    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }

    private static Integer getSpeed(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getSpeed();
    }

    private static Island createIsland(FieldSizeConfig fieldSizeConfig) {
        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < fieldSizeConfig.getHeight(); i++) {
            for (int j = 0; j < fieldSizeConfig.getWidth(); j++) {
                Field f = new Field(i, j);
                island.put(f, new ArrayList<>());
            }
        }
        return new Island(island);
    }

}