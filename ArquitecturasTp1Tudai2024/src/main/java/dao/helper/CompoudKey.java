package dao.helper;

public class CompoudKey {
    private int idFacture;
    private int idProduct;


    public CompoudKey(int idFacture, int idProduct) {
        this.idFacture = idFacture;
        this.idProduct = idProduct;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public int getIdProduct() {
        return idProduct;
    }
}
