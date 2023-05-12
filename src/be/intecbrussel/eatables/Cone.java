package be.intecbrussel.eatables;

import java.util.Objects;
import java.util.stream.Stream;

public class Cone implements Eatable {
    //properties
    private Flavor[] balls;


    //constructors
    public Cone() {
        this.balls = new Flavor[]{};
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }


    //custom methods
    @Override
    public void eat() {
        System.out.print("I'm eating a cone with ");
        Stream.of(balls)
                .filter(Objects::nonNull)
                .forEach(item -> System.out.println(item.name().toLowerCase()));
    }


    //inner classes
    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;
    }
}
