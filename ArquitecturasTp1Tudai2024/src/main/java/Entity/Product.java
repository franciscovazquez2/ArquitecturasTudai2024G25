package Entity;

public class Product {
    private int idProduct;
    private String name;
    private float value;

    public Product(String name, float value) {
        this.name = name;
        this.value = value;
    }
    public Product(int idProduct,String name, float value) {
        this.name = name;
        this.value = value;
        this.idProduct=idProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
