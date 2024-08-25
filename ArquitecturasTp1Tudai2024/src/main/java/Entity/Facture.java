package Entity;

public class Facture {
    private int idFacture;
    private int idClient;

    public Facture(int idFacture, int idClient) {
        this.idFacture = idFacture;
        this.idClient = idClient;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
