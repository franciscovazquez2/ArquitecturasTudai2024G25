package Entity;

public class ProductColleted extends Product{
    private int contTotal;
    private float colleted;

    public ProductColleted(Product pr, int contTotal, float colleted) {
        super(pr.getIdProduct(),pr.getName(),pr.getValue());
        this.contTotal = contTotal;
        this.colleted = colleted;
    }

    public int getContTotal() {
        return contTotal;
    }

    public float getColleted() {
        return colleted;
    }

    public ProductColleted getProductColleted(){
        return new ProductColleted(super.getProduct(),this.getContTotal(), this.getColleted());
    }
}
