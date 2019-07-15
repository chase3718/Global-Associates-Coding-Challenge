package com.im;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.im.business.AgedBrie;
import com.im.business.BackstagePass;
import com.im.business.Common;
import com.im.business.Conjured;
import com.im.business.Item;
import com.im.business.Sulfuras;
import com.im.db.ItemDB;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class ItemTests {

	@Before
	public void testAItemAdd() {
		ItemDB.add(new Common("+5 Dexterity Vest", 10, 20));
		ItemDB.add(new AgedBrie("Aged Brie", 2, 0));
		ItemDB.add(new Common("Elixir of the Mongoose", 5, 7));
		ItemDB.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
		ItemDB.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		ItemDB.add(new Conjured("Conjured Mana Cake", 3, 6));
		
		assertNotNull(ItemDB.get(3));
		assertEquals(ItemDB.get(0).getName(), "+5 Dexterity Vest");
		assertEquals(ItemDB.getByName("Conjured Mana Cake").getQuality(), 6);
	}
	
	@Test
	public void testBItemList() {
		List<Item> items = ItemDB.list();
		
		assertNotNull(items);
		assertEquals(items.get(3).getName(), "Sulfuras, Hand of Ragnaros");
	}
	
	@Test
	public void testCItemGet() {
		Item item1 = ItemDB.get(2);
		
		assertNotNull(item1);
		assertEquals(item1.getName(), "Elixir of the Mongoose");
	}
	
	@Test
	public void testDItemUpdate() {
		ItemDB.updateItems(5);
		assertEquals(ItemDB.getByName("Backstage passes to a TAFKAL80ETC concert").getQuality(), 25);
	}
	
	@After
	public void testEItemDelete() {
		Item item = ItemDB.get(3);
		ItemDB.deleteItem(item);
		for (Item i: ItemDB.list()) {
			if (i == item) {
				fail("Item not deleted");
			}
		}
	}
}
