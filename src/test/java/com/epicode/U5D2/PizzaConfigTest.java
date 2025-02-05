package com.epicode.U5D2;

import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PizzaConfigTest {
	@Autowired
	private Pizza margherita;
	@Autowired
	private Pizza hawaiian;
	@Autowired
	private Topping toppings_tomato;
	@Autowired
	private Topping toppings_pineapple;
	@Autowired
	private Topping toppings_cheese;
	@Autowired
	private Topping toppings_ham;


	@Test
	@DisplayName ("Test Margherita Bean per verificare correttezza valori inseriti")
	public void testMargherita () {
		assertEquals("Pizza Margherita",margherita.getName());
		assertEquals(2, margherita.getToppingList().size());
	}

	@Test
	@DisplayName("Test Hawaiian Bean per verificare correttezza valori inseriti")
	public void testHawaiian() {
		List<Topping> toppings = hawaiian.getToppingList();
		assertTrue(toppings.contains(toppings_tomato), "Tomato c'è");
		assertTrue(toppings.contains(toppings_pineapple), "c'è pineapple");
		assertEquals(toppings_cheese, toppings.get(1));
		assertEquals(toppings_ham, toppings.get(2));
	}


}
