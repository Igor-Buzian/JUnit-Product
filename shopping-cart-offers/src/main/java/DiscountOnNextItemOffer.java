import discount.IOffer;
import dto.Product;

public class DiscountOnNextItemOffer implements IOffer {
    int discountPercent;

    public DiscountOnNextItemOffer(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void applyOffer(Product product) {
        double oneProductPrice = product.getTotalPrice() / product.getQuantity();
        int totalQuantity = product.getQuantity();
        while (totalQuantity>1)
        {
            product.setTotalPrice(product.getTotalPrice()-(oneProductPrice/(100/discountPercent)));
            totalQuantity-=2;
        }
    }
}
