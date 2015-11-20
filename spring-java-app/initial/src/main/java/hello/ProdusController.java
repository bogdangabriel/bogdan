
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
public class ProdusController {
    private List<Produs> produse = new ArrayList<Produs>();

        ProdusController() {
            Produs p1 = new Produs(1, "John");
            Produs p2 = new Produs(2, "Paul");
            Produs p3 = new Produs(3, "Paul");

            produse.add(p1);
            produse.add(p2);
            produse.add(p3);
        }

    @RequestMapping(value="/Produs", method = RequestMethod.GET)
    public List<Produs> index() {
        return this.produse;
    }

@RequestMapping(value="/Produs/{}", method = RequestMethod.POST)
   public ResponseEntity create() {
   
       Produs p = new Produs(1, "bogdan");
       this.produse.add (p);
       return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
   }
	
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
  
  
  @RequestMapping(value="/Produs/{id}", method = RequestMethod.PUT)
     public ResponseEntity update(@PathVariable("id") int id) {
		 for(Produs p : this.produse) {
		     if(p.getId() == id) {
		 
		         p.setName("madalina");
		         p.setpret(10.0);
		         return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
		     }
		 }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

    @RequestMapping(value="/Produs/{id}", method = RequestMethod.GET)
    public ResponseEntity show(@PathVariable("id") int id) {
      for(Produs p : this.produse) {
          if(p.getId() == id) {
              return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
          }
      }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

  @RequestMapping(value="/Produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
        if(p.getId() == id) {
            this.produse.remove(p);
            return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
        }
    }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
