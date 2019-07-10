package com.im;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.im.business.Item;
import com.im.util.Console;

@SpringBootApplication
public class ItemManagerApplication {

	public static List<Item> Items = new ArrayList<Item>();

	public static void updateQuality() {
		for (Item item : Items) {
			String name = item.getName();
			String[] bsp = name.split("Backstage pass");
			String[] sulf = name.split("Sulfuras");
			String[] conj = name.split("Conjured");
			if (!item.getName().equals("Aged Brie")
					&& bsp.length < 2) {
				if (item.getQuality() > 0) {
					if (sulf.length < 2) {
						item.setQuality(item.getQuality() - 1);
					}
					if (conj.length >= 2) {
						item.setQuality(item.getQuality() - 1);
					}
				}
			} else {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
					if (bsp.length >= 2) {
						if (item.getSellIn() < 11) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}

						if (item.getSellIn() < 6) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}
					}
				}
			}

			if (sulf.length < 2) {
				item.setSellIn(item.getSellIn() - 1);
			}

			if (item.getSellIn() < 0) {
				if (!item.getName().equals("Aged Brie")) {
					if (bsp.length < 2) {
						if (item.getQuality() > 0) {
							if (sulf.length < 2) {
								item.setQuality(item.getQuality() - 1);
							}
							if (conj.length >= 2) {
								item.setQuality(item.getQuality() - 1);
							}
						}
					} else {
						item.setQuality(0);
					}
					
				} else {
					if (item.getQuality() < 50) {
						item.setQuality(item.getQuality() + 1);
					}
				}
			}
			
			if (item.getQuality() < 0) {
				item.setQuality(0);
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemManagerApplication.class, args);
		Items.add(new Item("+5 Dexterity Vest", 10, 20));
		Items.add(new Item("Aged Brie", 2, 0));
		Items.add(new Item("Elixir of the Mongoose", 5, 7));
		Items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		Items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		Items.add(new Item("Conjured Mana Cake", 3, 6));

		for (Item item : Items) {
			System.out.println("Item: " + item.getName() + 
					   "\nSellIn:   " + item.getSellIn() + 
					   "\nQuality:  " + item.getQuality() + "\n");
		}

		int iter = Console.getInt("Choose how many days to progress (enter 0 to quit): ");

		while (iter < 0) {
			iter = Console.getInt("Choose how many days to progress (enter 0 to quit): ");
		}

		while (iter > 0) {
			for (int i = 0; i < iter; i++) {
				updateQuality();
			}

			System.out.println("After " + iter + "Day(s)");
			for (Item item : Items) {
				System.out.println("Item: " + item.getName() + 
						   "\nSellIn:   " + item.getSellIn() + 
						   "\nQuality:  " + item.getQuality() + "\n");
			}

			iter = Console.getInt("Choose how many days to progress (enter 0 to quit): ");

			while (iter < 0) {
				iter = Console.getInt("Choose how many days to progress (enter 0 to quit): ");
			}
		}
		
		System.out.println("Exiting");
		
	}

}
