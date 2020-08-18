package burgerbuilder.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import burgerbuilder.AbstractTest;
import burgerbuilder.domain.Orders;

public class OrdersControllerTest extends AbstractTest{
	@Override
    @Before
    public void setUp() {
        super.setUp();
    } 
	
	@Test
	public void getOrders() throws Exception {
	    String uri = "/orders/find";
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	       .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult.getResponse().getContentAsString();
	    Orders[] orderslist = super.mapFromJson(content, Orders[].class);
	    assertTrue(orderslist.length > 0);
	}
	
	@Test
	public void postandDeleteOrders() throws Exception {
	    String uri = "/orders/add";
	    Orders order = new Orders();
	    order.setBacon(1);
	    order.setCheese(1);
	    order.setMeat(4);
	    order.setSalad(1);
	    order.setDeliveryMethod("pick-up");
	    order.setCustomer(55);
	    order.setPrice(8.00);
	    
	    String inputJson = super.mapToJson(order);
	    
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
    		.contentType(MediaType.APPLICATION_JSON_VALUE)
	        .content(inputJson)).andReturn();
	      
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    
	    
	    String content = mvcResult.getResponse().getContentAsString();
	    String uri2 = "/orders/delete/" + content;
	    MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.delete(uri2)).andReturn();
	    int status2 = mvcResult2.getResponse().getStatus();
	    assertEquals(200, status2);
	    String content2 = mvcResult2.getResponse().getContentAsString();
	    assertEquals("Deleted", content2);
	}

}
