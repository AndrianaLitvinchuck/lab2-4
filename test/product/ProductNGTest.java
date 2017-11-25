/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalDate;
import product.Product.Builder;

/**
 *
 * @author А
 */
public class ProductNGTest {
    
      @Test
     public void testDateOfProductionPositive() {

         LocalDate temp;
         temp=LocalDate.of(2016,12,12);
        Product p = new Product.Builder().setDateOfProduction(2016, 12, 12).createProduct();
        assertEquals(p.getDateOfProduction(), temp);
    }   
     
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetDateOFProductionNegative() {
        
        Builder builder = new Builder();
        builder.setDateOfProduction(2014, 12, 15);
    }
    
    
     @Test
     public void testPricePositive() {

        Product p = new Product.Builder().setPrice(50).createProduct();
        assertEquals(p.getPrice(), 50);
    }   
     
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPriceNegative() {
        
        Builder builder = new Builder();
        builder.setPrice(-2);
    }
    
    
    
   @Test(dataProvider = "inputProvider")
	public void suitableTest(int x1, int x2, int x3, int y1, int y2, int y3, boolean b) {
            Product p1=new Product.Builder().setDateOfProduction(x1, x2, x3).setShiftTime(y1,y2, y3).createProduct();
            
		assertEquals(p1.suitableProduct(), b);
	}

	@DataProvider
	public Object[][] inputProvider() {
		return new Object[][] { { 2017, 2 , 28,  2017, 10, 31, true } };
	}
    
      
}
