package cm.ua.pt.ementasua;

/**
 * Created by luispedro on 3/2/17.
 */
public class Meal {

    private String sopa;
    private String carne;
    private String peixe;
    private Boolean encerrada;
    private String name;
    private String date;
    private String type;

    public Meal(String name, String date, String type, String sopa, String carne, String peixe, Boolean encerrada) {
        this.sopa = sopa;
        this.carne = carne;
        this.peixe = peixe;
        this.encerrada = encerrada;
        this.name = name;
        this.date = date;
        this.type = type;
    }

    public String getSopa() {
        return sopa;
    }

    public String getCarne() {
        return carne;
    }

    public String getPeixe() {
        return peixe;
    }

    public Boolean getEncerrada() {
        return encerrada;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
