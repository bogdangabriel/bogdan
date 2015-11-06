package hello;

public class Persoana {

private final long Cnp;
private final String Nume;
private final String Prenume;
private final int Varsta;

public Persoana(long x, String y,String u,int v) {
        this.Cnp = x;
        this.Nume = y;
		this.Prenume=u;
		this.Varsta=v;
    }

    public long getCnp() {
        return Cnp;
    }

    public String getNume() {
        return Nume;
    }
	
	public String getPrenume() {
        return Prenume;
    }
	
	public String getVarsta() {
        return Varsta;
    }
}
