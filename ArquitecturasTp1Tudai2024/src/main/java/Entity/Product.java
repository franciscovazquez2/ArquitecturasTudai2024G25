package Entity;

public class Product {
    private int idProduct;
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public Product(int idProduct,String name, float price) {
        this.name = name;
        this.price = price;
        this.idProduct=idProduct;
    }

    public Product copy(){return new Product(this.idProduct,this.name,this.price);}

    public int getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return price;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
