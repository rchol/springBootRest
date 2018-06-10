package ru.rchol.springgo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class HelloController {

    private static final String message = "GET by %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/hello", method=GET)
    public Hello hello(@RequestParam(value="name", defaultValue="You") String name){
        return new Hello(counter.incrementAndGet(), String.format(message, name));
    }

}
