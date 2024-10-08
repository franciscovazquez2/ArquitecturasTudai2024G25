package entity;

public class Facture {
    private int idFacture;
    private int idClient;

    public Facture(int idFacture, int idClient) {
        this.idFacture = idFacture;
        this.idClient = idClient;
    }

    public Facture (Client c){
        this.idClient=c.getIdClient();
    }

    public Facture (int id){
        this.idClient=id;
    }
    public int getIdFacture() {
        return idFacture;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Facture copy() {return new Facture(this.getIdFacture(),this.getIdClient());}

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", idClient=" + idClient +
                '}';
    }
}
