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
public class ElevController {
  private List<Elev> elevi = new ArrayList<Elev>();
	//int i=4;
	//String Denumire="";
  ElevController() {
    Elev p1 = new Elev(1, "IOANA");
    Elev p2 = new Elev(2, "MARIA");
    Elev p3 = new Elev(3, "COSMIN");

    elevi.add(p1);
    elevi.add(p2);
    elevi.add(p3);
  }

  @RequestMapping(value="/Elev", method = RequestMethod.GET)
  public List<Elev> index() {
    return this.elevi;
  }
  
  @RequestMapping(value="/Elev/{Denumire}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("Denumire") String Denumire) {
		Elev n=new Elev( elevi.size() +1,Denumire);
		elevi.add(n);
		
        return new ResponseEntity<Elev>(n, new HttpHeaders(), HttpStatus.OK); 
  }

  @RequestMapping(value="/Elev/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Elev p : this.elevi) {
      if(p.getId() == id) {
        return new ResponseEntity<Elev>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

    

@RequestMapping(value="/Elev/{id}", method = RequestMethod.PUT)
  public ResponseEntity update( @PathVariable("id") int id) {
	  
	  for(Elev p : this.elevi) {
		if(p.getId() == id) {
			p.setName("Bogdan");
        return new ResponseEntity<Elev>(p, new HttpHeaders(), HttpStatus.OK); 
		}
	  }
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);	
  }


  @RequestMapping(value="/Elev/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Elev p : this.elevi) {
      if(p.getId() == id) {
        this.elevi.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}