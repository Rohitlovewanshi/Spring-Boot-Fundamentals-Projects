package com.rohit.springweb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.rohit.springweb.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {
	
	@Value("${productrestapi.services.url}")
	private String baseUrl;

	@Test
	void testGetProduct() {
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		Assertions.assertNotNull(product);
		Assertions.assertEquals("xiomi", product.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("samsung");
		product.setPrice(1000);
		Product newProduct = restTemplate.postForObject(baseUrl, product,
				Product.class);
		Assertions.assertNotNull(newProduct);
		Assertions.assertNotNull(newProduct.getId());
		Assertions.assertEquals("samsung", newProduct.getName());
	}

	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"3", Product.class);
		product.setDescription("Its amazing");
		restTemplate.put(baseUrl, product, Product.class);

	}
}
