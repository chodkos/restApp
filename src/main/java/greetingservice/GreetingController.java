package greetingservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    private final String anotherTemplate = "Hello, %s you are our %d customer";
    private final AtomicLong anotherCounter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.getAndIncrement(), String.format(template, name));
    }

    @RequestMapping("/anothergreeting")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "Zbigniew") String name){
        return new Greeting(anotherCounter.getAndIncrement(), String.format(anotherTemplate, name, anotherCounter.get()));
    }
}
