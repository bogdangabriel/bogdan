package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class PersoanaController {
  private List<Persoana> Persoane = new ArrayList<Persoana>();
	//int i=4;
	//String Denumire="";
  PersoanaController() {
    Persoana p1 = new Persoana(1, "Vasile");
    Persoana p2 = new Persoana(2, "Ion");
    Persoana p3 = new Persoana(3, "George");

    Persoane.add(p1);
    Persoane.add(p2);
    Persoane.add(p3);
  }

  @RequestMapping(value="/Persoana", method = RequestMethod.GET)
  public List<Persoana> index() {
    return this.Persoane;
  }
  
  @RequestMapping(value="/Persoana/{Denumire}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("Denumire") String Denumire) {
		Persoana n=new Persoana( Persoane.size() +1,Denumire);
		Persoane.add(n);
		
        return new ResponseEntity<Persoana>(n, new HttpHeaders(), HttpStatus.OK); 
  }

  @RequestMapping(value="/Persoana/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Persoana p : this.Persoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

   

@RequestMapping(value="/Persoana/{id}", method = RequestMethod.PUT)
  public ResponseEntity update( @PathVariable("id") int id) {
	  
	  for(Persoana p : this.Persoane) {
		if(p.getId() == id) {
			p.setDenumire("Bogdan");
        return new ResponseEntity<Persoana>(p, new HttpHeaders(), HttpStatus.OK); 
		}
	  }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);	
  }

  @RequestMapping(value="/Persoana/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Persoana p : this.Persoane) {
      if(p.getId() == id) {
        this.Persoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}