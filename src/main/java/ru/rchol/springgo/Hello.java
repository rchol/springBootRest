package ru.rchol.springgo;

/**
 * Created by User on 010 10.06.18.
 */
public class Hello {
    private final long id;
    private final String name;

    public Hello(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
