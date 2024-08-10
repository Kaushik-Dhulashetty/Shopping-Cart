package com.jsp.hibernate.jpa.shoppingcart;

import java.util.Scanner;

import com.jsp.hibernate.jpa.service.ShoppingCartService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.println("Welcome To Shopping Dashboard!!");
		 System.out.println("1 - Add Product");
         System.out.println("2 - Add User");
         System.out.println("3 - Add Product to Cart");
         System.out.println("4 - Remove Product from Cart");
         System.out.println("5 - Find All Products in Cart");
		 System.out.println("Enter The Operation:");
		 int num = sc.nextInt();
		 
		ShoppingCartService shop = new ShoppingCartService();

		switch (num) {
		case 1:
			shop.addProduct();
			break;
		case 2:
			shop.addUser();
			break;
		case 3:
			shop.addProductIntoCart();
			break;
		case 4:
			shop.removeProductFromCart();
			break;
		case 5:
			shop.findAllProductsInCart();
			break;
		}
		sc.close();
	}
}
