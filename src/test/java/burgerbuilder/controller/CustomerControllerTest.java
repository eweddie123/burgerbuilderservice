package burgerbuilder.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import burgerbuilder.AbstractTest;
import burgerbuilder.domain.Customer;

public class CustomerControllerTest extends AbstractTest{
	@Override
    @Before
    public void setUp() {
        super.setUp();
    } 
	
	@Test
	public void getCustomer() throws Exception {
	    String uri = "/customer/find";
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	       .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult.getResponse().getContentAsString();
	    Customer[] customerlist = super.mapFromJson(content, Customer[].class);
	    assertTrue(customerlist.length > 0);
	}
	
	@Test
	public void postandDeleteCustomer() throws Exception {
	    String uri = "/customer/add";
	    Customer customer = new Customer();
	    customer.setCountry("Narnia");
	    customer.setEmail("awjeez@gmail.com");
	    customer.setName("Morty");
	    customer.setStreet("testStreet");
	    customer.setZipcode("17771");
	    
	    String inputJson = super.mapToJson(customer);
	    
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
    		.contentType(MediaType.APPLICATION_JSON_VALUE)
	        .content(inputJson)).andReturn();
	      
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    
	    
	    String content = mvcResult.getResponse().getContentAsString();
	    String uri2 = "/customer/delete/" + content;
	    MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.delete(uri2)).andReturn();
	    int status2 = mvcResult2.getResponse().getStatus();
	    assertEquals(200, status2);
	    String content2 = mvcResult2.getResponse().getContentAsString();
	    assertEquals("Deleted", content2);
	}

}
