
// package com.Hexaware.CMS.Model;

// import static org.junit.Assert.assertEquals;

// import java.time.LocalDate;

// import org.junit.Test;


// public class OrderListTest {

//     @Test
//     public void testOrderList(){
//         OrderList o = new OrderList();
//         o.setOrderId(3001);
//         o.setOrderDate(LocalDate.parse("2022-04-13"));
//         o.setCustId(1);
//         o.setTotalPrice( 550.00);
//         o.setFoodCode(1001);
//         o.setOrderStatus("ACCEPTED");
//         o.setVendorId(102);
//         o.setQuantity(2);

//         assertEquals(3001, o.getOrderId());
//         //assertEquals("2022-04-13",LocalDate.format( o.getOrderDate()));
//         assertEquals(1, o.getcustId());
//         assertEquals(550.00, o.getTotalPrice(),0);
//         assertEquals(1001, o.getFoodCode());
//         assertEquals("ACCEPTED", o.getOrderStatus());
//         assertEquals(102, o.getVendorId());
//         assertEquals(2, o.getQuantity());
//     }

//     @Test
//     // public void testOrderListP() {
//     //     OrderList o = new OrderList(3001, LocalDate.parse("2022-04-13"), 1, 550.00, 1001, "ACCEPTED", 102, 2);

//     //     assertEquals(3001, o.getOrderId());
//     //     assertEquals("2022-04-13",LocalDate.format( o.getOrderDate());
//     //     assertEquals(1, o.getcustId());
//     //     assertEquals(550.00, o.getTotalPrice(), 0);
//     //     assertEquals(1001, o.getFoodCode());
//     //     assertEquals("ACCEPTED", o.getOrderStatus());
//     //     assertEquals(102, o.getVendorId());
//     //     assertEquals(2, o.getQuantity());

//     }

//     @Test
//     public void testSetOrderId() {

//         OrderList o= new OrderList();
//         o.setOrderId(1);
//         assertEquals(3001, o.getOrderId());
//     }

//     /**
//      * Test method for GetOrderId
//      */

//     @Test
//     public void testGetOrderId() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(3001, o.getOrderId());
//     }

//     @Test
//     public void testSetOrderDate() {

//         OrderList o = new OrderList();
//         o.setOrderDate(LocalDate.parse("2022-04-13"));
//         assertEquals("2022-04-13",LocalDate.format( o.getOrderDate());
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetOrderDate() {

//         OrderList o = new OrderList(3001, LocalDate.parse("2022-04-13"), 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals("2022-04-13",LocalDate.format( o.getOrderDate());
//     }

//     @Test
//     public void testSetCustId() {

//         OrderList o = new OrderList();
//         o.setCustId(1);
//         assertEquals(1, o.getcustId());
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetCustId() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(1, o.getcustId());
//     }
    
//     @Test
//     public void testSetTotalPrice() {

//         OrderList o = new OrderList();
//         o.setTotalPrice(550.00);
//         assertEquals(550.00, o.getTotalPrice(),0);
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetTotalPrice() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(550.00, o.getTotalPrice(),0);
//     }

//     @Test
//     public void testSetFoodCode() {

//         OrderList o = new OrderList();
//         o.setFoodCode(1001);
//         assertEquals(1001, o.getFoodCode());
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetfoodCode() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(1001, o.getFoodCode());
//     }

//     @Test
//     public void testSetOrderStatus() {

//         OrderList o = new OrderList();
//         o.setOrderStatus("ACCEPTED");
//         assertEquals("ACCEPTED", o.getOrderStatus());
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetOrderStatus() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals("ACCEPTED", o.getOrderStatus());
//     }

//     @Test
//     public void testSetVendorId() {

//         OrderList o = new OrderList();
//         o.setVendorId(102);
//         assertEquals(102, o.getVendorId());
//     }

//     /**
//      * Test method for GetOrderDate
//      */

//     @Test
//     public void testGetVendorId() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(102, o.getVendorId());
//     }

//     @Test
//     public void testSetQuantity() {

//         OrderList o = new OrderList();
//         o.setQuantity(2);
//         assertEquals(2, o.getQuantity());
//     }

//     /**
//      * Test method for GetQuantity
//      */

//     @Test
//     public void testGetQuantity() {

//         OrderList o = new OrderList(3001, LocalDate, 1, 550.00, 1001, "ACCEPTED", 102, 2);
//         assertEquals(2, o.getQuantity());
//     }
    
// }
