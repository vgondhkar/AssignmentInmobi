package com.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.implement.AddItemTocartFromAmazon;
import com.libs.BaseClass;

public class CartshoeItem extends AddItemTocartFromAmazon{
  @Test
  public void AddItemToCart() throws IOException {
	  String Lancer="Lancer Men's Formal Shoes";
	  AddLancerShoeToCart(Lancer);
	  
	
	  
	  
  }
}
