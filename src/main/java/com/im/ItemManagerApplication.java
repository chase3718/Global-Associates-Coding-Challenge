package com.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.im.business.*;
import com.im.db.ItemDB;

@SpringBootApplication
public class ItemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemManagerApplication.class, args);
		
		ItemDB.add(new Common("+5 Dexterity Vest", 10, 20));
		ItemDB.add(new AgedBrie("Aged Brie", 2, 0));
		ItemDB.add(new Common("Elixir of the Mongoose", 5, 7));
		ItemDB.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
		ItemDB.add(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		ItemDB.add(new Conjured("Conjured Mana Cake", 3, 6));
	}

}
