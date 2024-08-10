package com.jsp.hibernate.jpa.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate.jpa.entity.Cart;
import com.jsp.hibernate.jpa.entity.Product;
import com.jsp.hibernate.jpa.entity.User;

public class ShoppingCartService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Shop");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void addProduct() {
		et.begin();
		System.out.println("Adding The Product Details:");

		Product p = new Product();
		System.out.println("Enter The Product Id:");
		p.setProductId(sc.nextInt());
		System.out.println("Enter The Product Name:");
		p.setProductName(sc.next());
		System.out.println("Enter The Product Brand:");
		p.setProductBrand(sc.next());
		System.out.println("Enter The Product Price:");
		p.setProductPrice(sc.nextInt());

		em.persist(p);
		et.commit();
		em.close();
		emf.close();
		System.out.println("Products Inserted Successfully!!");

	}

	public void addUser() {
		et.begin();
		User user = new User();
		if (user != null) {
			System.out.println("Enter The User Id:");
			user.setUserId(sc.nextInt());
			System.out.println("Enter The User Name:");
			user.setUserName(sc.next());
			System.out.println("Enter The User Email:");
			user.setUserEmail(sc.next());
			System.out.println("Enter The User Password:");
			user.setUserPassword(sc.next());

		}
		System.out.println("Creating a New Cart!!");
		Cart cart = new Cart();
		System.out.println("Enter The Cart Id:");
		cart.setCartId(sc.nextInt());
		
		user.setCart(cart);

		em.persist(user);
		em.persist(cart);
		et.commit();
		em.close();
		emf.close();

	}

	public void addProductIntoCart() {
		et.begin();
		System.out.println("Adding Products into Cart!");

		System.out.println("Enter The Product Id:");
		Product product = em.find(Product.class, sc.nextInt());

		if (product != null) {
			System.out.println("Enter The User Id:");
			User user = em.find(User.class, sc.nextInt());
			if (user != null) {
				Cart cart = user.getCart();
				cart.getProducts().add(product);
				em.merge(cart);
			} else {
				System.out.println("User with id does not exist.");
			}
		}else{
			System.out.println("Product with id does not exist.");
		}
		em.persist(product);
		et.commit();
		em.close();
		emf.close();
		
	}

	public void removeProductFromCart() {
		et.begin();
		System.out.println("Adding Products into Cart!");

		System.out.println("Enter The Product Id:");
		Product product = em.find(Product.class, sc.nextInt());

		if (product != null) {
			System.out.println("Enter The User Id:");
			User user = em.find(User.class, sc.nextInt());
			if (user != null) {
				Cart cart = user.getCart();
				cart.getProducts().remove(product);
				em.merge(cart);
			}else {
				System.out.println("User with id does not exist.");
			}
		} else {
			System.out.println("Product with id does not exist.");
		}

		et.commit();
		em.close();
		emf.close();
	}

	public void findAllProductsInCart() {
		et.begin();
		System.out.println("Enter The Cart Id:");
		Cart cart = em.find(Cart.class, sc.nextInt());

		System.out.println("Products in Cart:");
		for (Product product : cart.getProducts()) {
			System.out.println(product);
		}
		et.commit();
		em.close();
		emf.close();
	}
}
