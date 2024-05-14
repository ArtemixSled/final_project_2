package models.abstracts;

public class Entity {
    protected Double weight;
    protected Integer maxCountOnField;
    protected Integer speed;
    protected Double kgToFullEating;

    private boolean dead = false;

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public Entity(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        this.weight = weight;
        this.maxCountOnField = maxCountOnField;
        this.speed = speed;
        this.kgToFullEating = kgToFullEating;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getMaxCountOnField() {
        return maxCountOnField;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Double getKgToFullEating() {
        return kgToFullEating;
    }
}
