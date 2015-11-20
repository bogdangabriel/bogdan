// JavaScript source code
package hello;

import java.util.List;
import java.util.ArrayList;

public class Elev {
    private String name;
    private float medie;
    private int id;

    public Elev() {}

    public Elev(float medie, String name,int id) {
        this.name = name;
        this.medie = medie;
        this.id=id;
    }

    public String getName() {
        return this.name;
    }

    public float getMed() {
        return this.medie;
    }

    public float getId() {
        return this.id;
    }
	
	public float getMedie() {
        return this.medie;
    }

    public void setName (String name){
	  
        this.name = name;
	  
    }

    public void setMedie (float medie){
	  
        this.medie = medie;
	  
    }

}
