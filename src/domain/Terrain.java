package domain;

public class Terrain {
    private int id;
    private String type;
    private String numero;
    private String adresse;

    public Terrain (String type, String numero, String adresse){
        this.type=type;
        this.numero=numero;
        this.adresse=adresse;
    }


    public String getType() {
        return this.type;
    }
}
