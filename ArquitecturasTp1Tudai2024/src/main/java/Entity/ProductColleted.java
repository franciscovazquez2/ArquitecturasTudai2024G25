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

    @Override
    public ProductColleted copy(){
        return new ProductColleted(super.copy(),this.getContTotal(), this.getColleted());
    }

    @Override
    public String toString() {
        return  super.toString() +
                "contTotal=" + contTotal +
                ", colleted=" + colleted +
                '}';
    }
}
