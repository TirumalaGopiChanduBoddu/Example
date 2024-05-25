package com.gopi;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gopi.entity.Address;
import com.gopi.entity.Order;
import com.gopi.entity.OrderItem;
import com.gopi.entity.Product;
import com.gopi.entity.Role;
import com.gopi.entity.User;
import com.gopi.repository.AddressRepository;
import com.gopi.repository.OrderItemRepository;
import com.gopi.repository.OrderRepository;
import com.gopi.repository.ProductRepository;
import com.gopi.repository.RoleRepository;
import com.gopi.repository.UserRepository;

@SpringBootApplication
public class ExampleeeeeApplication implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository RoleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleeeeeApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		//saveOrder() ;
		//saveProduct();
		//saveRole();
		//saveUser();
		saveRole();
	}
	
	
	private void saveProduct() {
		Product product1= new Product();
		product1.setProductDesc("Santhoor Soap");
		product1.setProductName("Santhoor_Soap");
		product1.setProductPrice(20);
		
		
		Product product2= new Product();
		product2.setProductDesc("Cinthol Soap");
		product2.setProductName("Cinthol_Soap");
		product2.setProductPrice(10);
		
		productRepository.saveAll(List.of(product1, product2));
		
	}
	public void saveOrder() {
		Address address = new Address();
		address.setCountry("India");
		address.setPin(523187);
		address.setState("Andhra Pradesh");
		address.setStreet("Danthampeta, Vetapalem Mandal , Chirala");
		
//		addressRepository.save(address);
//		
		
		Order order = new Order();
		order.setOrderStatus("InProgess");
	
		OrderItem item1= new OrderItem();
		item1.setProduct(productRepository.findById(1L).get());
		item1.setQuantity(2);
		item1.setPrice(productRepository.findById(1L).get().getProductPrice() * 2);
		
		
		OrderItem item2= new OrderItem();
		item2.setProduct(productRepository.findById(2L).get());
		item2.setQuantity(1);
		item2.setPrice(productRepository.findById(2L).get().getProductPrice() * 1);
		
		order.setOrderItems(List.of(item1 , item2));
		
		
		order.setAddress(address);
		order.setTotalPrice((long) (productRepository.findById(2L).get().getProductPrice() * 1) + (productRepository.findById(1L).get().getProductPrice() * 2));
		order.setTatalQuantity(2);
		orderRepository.save(order);
		
	}

	
	public void saveUser() {
		User user = new User();
		user.setFristName("Goip");
		user.setLastName("Boddu");
		user.setEmail("goip@gmail.com");
		user.setPassword("password12333");
		
		Role admin = new Role();
		admin.setName("Role_Admin");
		
		Role customer = new Role();
		customer.setName("Role_Customer");
		
		user.getRoles().add(admin);
		user.getRoles().add(customer);
		
		userRepository.save(user);
		
	}
	
	public void saveRole(){
		User user1 = new User();
		user1.setFristName("Goip");
		user1.setLastName("Boddu");
		user1.setEmail("goip@gmail.com");
		user1.setPassword("password12333");
		
		User user2 = new User();
		user2.setFristName("Tirumala");
		user2.setLastName("Biraka");
		user2.setEmail("Tirumala@gmail.com");
		user2.setPassword("password2233");
		
		
		Role admin = new Role();
		admin.setName("Role_Admin");
		
		admin.getUsers().add(user1);
		admin.getUsers().add(user2);
		
		user1.getRoles().add(admin);
		user2.getRoles().add(admin);
		
		RoleRepository.save(admin);
		
		
	}
}
