
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
public class EleviController {
    private List<Elevi> elevi = new ArrayList<Elevi>();

        EleviController() {
            Elevi p1 = new Elevi(1, "John");
            Elevi p2 = new Elevi(2, "Paul");
            Elevi p3 = new Elevi(3, "Paul");

            elevi.add(p1);
            elevi.add(p2);
            elevi.add(p3);
        }

    @RequestMapping(value="/Elevi", method = RequestMethod.GET)
    public List<Elevi> index() {
        return this.elevi;
    }

@RequestMapping(value="/Elevi/{}", method = RequestMethod.POST)
   public ResponseEntity create() {
   
       Elevi p = new Elevi(1, "bogdan");
       this.elevi.add (p);
       return new ResponseEntity<Elevi>(p, new HttpHeaders(), HttpStatus.OK);
   }
	
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
  
  
  @RequestMapping(value="/Elevi/{id}", method = RequestMethod.PUT)
     public ResponseEntity update(@PathVariable("id") int id) {
		 for(Elevi p : this.elevi) {
		     if(p.getId() == id) {
		 
		         p.setName("madalina");
		         p.setMedie(10);
		         return new ResponseEntity<Elevi>(p, new HttpHeaders(), HttpStatus.OK);
		     }
		 }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

    @RequestMapping(value="/Elevi/{id}", method = RequestMethod.GET)
    public ResponseEntity show(@PathVariable("id") int id) {
      for(Elevi p : this.elevi) {
          if(p.getId() == id) {
              return new ResponseEntity<Elevi>(p, new HttpHeaders(), HttpStatus.OK);
          }
      }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

  @RequestMapping(value="/Elevi/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Elevi p : this.elevi) {
        if(p.getId() == id) {
            this.elevi.remove(p);
            return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
        }
    }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}