package ru.rchol.springgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rchol.springgo.model.Visitors;
import ru.rchol.springgo.modelwork.VisitorsService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class HelloController {

    private static final String message = "GET by %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private VisitorsService visitorsService;

    @RequestMapping(value="/hello", method=GET)
    public Hello hello(@RequestParam(value="name", defaultValue="You") String name){
        visitorsService.addVisitor(new Visitors(name));
        return new Hello(counter.incrementAndGet(), String.format(message, name));
    }

    @RequestMapping(value = "/show", method = GET)
    public @ResponseBody ResponseEntity<List<Visitors>> getAll() {
        return ResponseEntity.ok(visitorsService.getAllVisitors());
    }

    @RequestMapping(value = "/addVisitor", method = POST)
    public void addVisitorApi(@RequestParam(value = "name", defaultValue = "Anon") String name){
        visitorsService.addVisitor(new Visitors(name));
        counter.incrementAndGet();
    }


}
