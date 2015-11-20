package hello;

import java.util.List;
import java.util.ArrayList;

public class  Produs{
    private String name;
    private int id;
    float pret;

    public Produs() {}

    public Produs(int id, String name,float pret) {
        this.name = name;
        this.id = id;
        this.pret=pret;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getPret() {
        return this.pret;
    }

    public void setName (String name){
	  
        this.name = name;
	  
    }
    ublic void setPret (float pret){
	  
        this.pret = pret;
	  
    }
}

