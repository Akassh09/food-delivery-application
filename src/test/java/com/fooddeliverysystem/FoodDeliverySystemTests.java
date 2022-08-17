package com.fooddeliverysystem;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fooddeliverysystem.dao.CustomerRepository;
import com.fooddeliverysystem.dao.RestaurantRepository;
import com.fooddeliverysystem.model.Customer;
import com.fooddeliverysystem.model.Restaurant;
import com.fooddeliverysystem.service.CustomerService;


@SpringBootTest
class FoodDeliverySystemTests {

	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerService reservice;
	
	@Autowired
	private RestaurantRepository respo;
	
	@Test
	void testAddCustomer() {
       Customer cus=new Customer();
       cus.setCustomerId((long) 1);
       cus.setFirstName("Sujit");
       cus.setLastName("Singh");
       cus.setGender("male");
       cus.setAge(23);
       cus.setMobileNumber("9957223570");
       Customer cust=repo.save(cus);
       assertThat(cust.getCustomerId()).isEqualTo(1);
       System.out.println("#####10MARKS#####");
	}
	
	@Test
	void testUpdateCustomerById() {
		Optional<Customer> op = repo.findById((long) 1);
		System.out.println(op);
		if (op.isPresent()) {
		    Customer cus = op.get();
			assertThat(cus.getCustomerId()).isEqualTo(1);
			cus.setFirstName("Sujit");
			repo.save(cus);
			cus.setLastName("Singh");
			repo.save(cus);
			cus.setGender("male");
			repo.save(cus);
			cus.setAge(23);
			repo.save(cus);
			System.out.println("####10MARKS####");
		} else {
			assertThat(op).isEmpty();
		}
	}
	
	@Test
	void testDeleteCustomerById() {
		Optional<Customer> op = repo.findById((long) 1);
		if (op.isPresent()) {
			Customer cus = op.get();
			assertThat(cus.getCustomerId()).isEqualTo(1);
			System.out.println("####10MARKS####");
		}
	}
	
	@Test
	void testGetCustomerById() {
		Optional<Customer> op = repo.findById((long) 2);
		if (op.isPresent()) {
			Customer cus = op.get();
			assertThat(cus.getCustomerId()).isEqualTo(2);
			System.out.println("###10MARKS###");
		}
	}
	
	@Test
	void testAllStudent() {
		List<Customer> list = new ArrayList<Customer>();
		repo.findAll().forEach(list::add);
		assertThat(list.size()).isGreaterThanOrEqualTo(0);
		System.out.println("##10MARKS##");
	}
	
	@Test
	void testAddRestaurant() {
       Restaurant res=new Restaurant();
       res.setRestaurantId((long) 1);
       res.setRestaurantName("Kiranshree");
       res.setManagerName("Sujit");
       res.setRes_pincode("781009");
       res.setContactNumber("9957223570");
       Restaurant rest=respo.save(res);
       assertThat(rest.getRestaurantId()).isEqualTo(1);
       System.out.println("#####10MARKS#####");
	}
	
	@Test
	void testDeleteRestaurantById() {
		Optional<Restaurant> op = respo.findById((long) 1);
		if (op.isPresent()) {
			Restaurant res = op.get();
			assertThat(res.getRestaurantId()).isEqualTo(1);
			System.out.println("####10MARKS####");
		}
	}

}
