/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import java.util.ArrayList;
import product.Product;
import org.testng.annotations.DataProvider;

/**
 *
 * @author andri
 */
public class ShoppingCartNGTest {
    
    Product p1, p2, p3, p4, p5, p6;
  
    public ShoppingCartNGTest(){
        p1=new Product.Builder().setTitle("Butter").setType("Dairy").setPrice(100).
                setDateOfProduction(2017, 10, 5).
                setShiftTime(2017, 11,20).createProduct();
        p2=new Product.Builder().setTitle("Pork").setType("Meat").setPrice(100).
                setDateOfProduction(2017, 10, 25).
                setShiftTime(2017, 11,12).createProduct();
        p3=new Product.Builder().setTitle("Chocolate").setType("Sweets").setPrice(30).
                setDateOfProduction(2017, 9, 15).
                setShiftTime(2018, 2, 15).createProduct();
        p4=new Product.Builder().setTitle("Chocolate").setType("Sweets").setPrice(30).
                setDateOfProduction(2017, 9, 15).
                setShiftTime(2018, 2, 15).createProduct();
        p5=new Product.Builder().setTitle("Tomatoes").setType("Vegetables").setPrice(40).
                setDateOfProduction(2017, 11, 2).
                setShiftTime(2018, 11, 15).createProduct();
        p6=new Product.Builder().setTitle("Branbread").setType("Baked").setPrice(10).
                setDateOfProduction(2017, 11, 3).
                setShiftTime(2018, 11, 5).createProduct();
    
        
    }
    
     @Test
    public void testsumOfShoppingCart() {
    ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(p1);
        cart1.addProduct(p2);
        cart1.addProduct(p3);
        cart1.addProduct(p4); 
        cart1.addProduct(p5);
        cart1.addProduct(p6);
        assertEquals(cart1.sumOfShoppingCart(), 310);
    }
    
 
     @Test(dataProvider = "getAddProductNameProvider")
    public void testAddProductName(ShoppingCart cart, String title, boolean b) {
        assertEquals(cart.addProductByName(title), b );
    }
    
    @DataProvider
    public Object[][] getAddProductNameProvider(){
        
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(p1);
        cart1.addProduct(p2);
        cart1.addProduct(p3); 
        cart1.addProduct(p5);
        cart1.addProduct(p6);
         return new Object[][]{{cart1,"Pork", true}};
    }
    
      @Test
    public void testTheMostExpensiveProduct() {

        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(p1);
        cart1.addProduct(p2);
        cart1.addProduct(p3);
        cart1.addProduct(p4);
        cart1.addProduct(p5);
        cart1.addProduct(p6);
         ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(p1);
        cart2.addProduct(p2);
        ArrayList<Product> d1= new ArrayList<Product>();
        d1= cart2.getCollection();
        assertEquals( cart1.theMostExpensiveProduct(), d1 );
    }
    
 
}
