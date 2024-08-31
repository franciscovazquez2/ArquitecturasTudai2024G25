package Entity;

public class Facture_Product {
    private int idFacture;
    private int idProduct;
    private int cantidad;

    public Facture_Product(int idFacture, int idProduct, int cantidad) {
        this.idFacture = idFacture;
        this.idProduct = idProduct;
        this.cantidad = cantidad;
    }

    public int getIdFacture() {return idFacture;}

    public int getIdProduct() {return idProduct;}

    public int getCantidad() {return cantidad;}

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Facture_Product copy() {return new Facture_Product(this.getIdFacture(),this.getIdProduct(),this.getCantidad());}

    @Override
    public String toString() {
        return "Facture_Product{" +
                "idFacture=" + idFacture +
                ", idProduct=" + idProduct +
                ", cantidad=" + cantidad +
                '}';
    }
}
