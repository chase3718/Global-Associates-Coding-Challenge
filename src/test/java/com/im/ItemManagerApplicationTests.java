package com.im;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.im.business.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemManagerApplicationTests {
	
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
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void testAddItems() {
		Items.add(new Item("+5 Dexterity Vest", 10, 20));
		Items.add(new Item("Aged Brie", 2, 0));
		Items.add(new Item("Elixir of the Mongoose", 5, 7));
		Items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		Items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		Items.add(new Item("Conjured Mana Cake", 3, 6));
		assertNotNull(Items);
		assertNotNull(Items.get(3));
	}
	
	@Test
	public void testUpdateItems() {
		for (int i = 0; i < 5; i++) {
			updateQuality();
		}
		assertEquals(Items.get(0).getQuality(), 15);
		assertEquals(Items.get(1).getQuality(), 8);
		assertEquals(Items.get(2).getQuality(), 2);
		assertEquals(Items.get(3).getQuality(), 80);
		assertEquals(Items.get(4).getQuality(), 25);
		assertEquals(Items.get(5).getQuality(), 0);
		assertEquals(Items.get(2).getName(), "Elixir of the Mongoose"); 
	}

}
