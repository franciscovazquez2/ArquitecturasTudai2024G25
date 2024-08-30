package Entity;

public class ClientMaxFacture extends Client {

    private int totalFacturado;

    public ClientMaxFacture(Client c, int totalFacturado){
            super(c.getIdClient(),c.getName(),c.getEmail());
            this.totalFacturado=totalFacturado;
    }
    //devolver copia
    public int getTotalFacturado() {
        return totalFacturado;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "totalFacturado=" + totalFacturado +
                '}';
    }
}
