package models.abstracts;

import service.AnimalAction;

public abstract class Animal extends Entity implements AnimalAction , Cloneable {

    private static final double SATIETY_MAX = 4; //сытость максимум
    private static final double STARVING_FOR_A_DAY = 1; //уменьшение сытости в день
    private double satiety_left = 4; //сытость осталась
    private double saturation_KG_for_a_day = kgToFullEating / SATIETY_MAX; //восполнение сытости в день

    private boolean isMovedInThisLap = false;
    private boolean isHuntedInThisLap = false;
    private boolean dead = false;

    public double getSatiety_left() {
        return satiety_left;
    }

    public void setSatiety_left(double satiety) {
        this.satiety_left = satiety;
    }


    public double getSaturation_KG_for_a_day() {
        return saturation_KG_for_a_day;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isMovedInThisLap() {
        return isMovedInThisLap;
    }

    public void setMovedInThisLap(boolean movedInThisLap) {
        isMovedInThisLap = movedInThisLap;
    }

    public boolean isHuntedInThisLap() {
        return isHuntedInThisLap;
    }

    public void setHuntedInThisLap(boolean huntedInThisLap) {
        isHuntedInThisLap = huntedInThisLap;
    }

    public double getSTARVING_FOR_A_DAY() {
        return STARVING_FOR_A_DAY;
    }

    public double getSATIETY_MAX() {
        return SATIETY_MAX;
    }

    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void chooseDirection() {

    }

    @Override
    public void eat() {

    }

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "satiety_left=" + satiety_left +
                '}';
    }
}
