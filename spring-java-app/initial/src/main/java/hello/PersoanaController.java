package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersoanaController {

    private static final String template = "Nume:, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	 @RequestMapping("/persoana")
    public Persoana persoana(@RequestParam(value="name", defaultValue="Noname") String nume) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, nume));
    }
	
	private static final string template = "Prenume:, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/persoana")
    public Persoana persoana(@RequestParam(value="prenume", defaultValue="Noname") String prenume) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, prenume));
    }
	
	private static final int template = "Varsta:, %d!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/persoana")
    public Persoana persoana(@RequestParam(value="Varsta", defaultValue="0") String varsta) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, varsta));
    }
	
	private static final long template = "cnp:, %d!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping("/persoana")
    public Persoana persoana(@RequestParam(value="cnp", defaultValue="0000000000000") String cnp) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, cnp));
    }
}