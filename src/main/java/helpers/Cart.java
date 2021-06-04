package helpers;

import models.CartItem;
import models.Product;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Cart {
    public static final String CART_KEY = "CART";
    public static final int TAX = 10;
    ArrayList<CartItem> cartItems = new ArrayList<>();

    public Cart() {

    }

    //thêm sp vào giỏ hàng
    public void addItem(Product product) {
        //check xem sp có tồn tại giỏ hàng hay không
        int index = findItemInCart(product.getId());
        if (index != -1) {
            //tăng số lượng sp lên
            cartItems.get(index).setQuantity(cartItems.get(index).getQuantity() + 1);
        } else {
            //thêm mới sp vào
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItems.add(cartItem);
        }
    }

    //xoá sp trong giỏ hàng
    public void removeItem(int id) {
        int index = findItemInCart(id);
        cartItems.remove(index);
    }

    //làm trống giỏ hàng
    public void emptyCart() {
        cartItems = new ArrayList<>();
    }

    public void updateQuantity(int id, int offset) {
        //off là dương hoặc âm
        int index = findItemInCart(id);
        if (index != -1) {
            //tăng số lượng sp lên
            cartItems.get(index).setQuantity(cartItems.get(index).getQuantity() + offset);
        }
    }

    public int findItemInCart(int id) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }


    public float getSubTotal() {
        float total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            total+= (cartItems.get(i).getQuantity() * cartItems.get(i).getProduct().getPrice());
        }
        return total;
    }

    public float getTax() {
        return (getSubTotal() * TAX) / 100;
    }

    public float getTotal() {
        return getTax() + getSubTotal();
    }

}
