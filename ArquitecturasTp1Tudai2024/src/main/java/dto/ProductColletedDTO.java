package dto;

public class ProductColletedDTO {

    private int idProduct;
    private String name;
    private int price;
    private int cantTotal;
    private float collected;

    public ProductColletedDTO(int idProduct, String name, int price, int cantTotal, float collected) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.cantTotal = cantTotal;
        this.collected = collected;
    }

    public int getCantTotal() {
        return cantTotal;
    }

    public float getCollected() {
        return collected;
    }

    @Override
    public String toString() {
        return "ProductColletedDTO{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cantTotal=" + cantTotal +
                ", collected=" + collected +
                '}';
    }
}
