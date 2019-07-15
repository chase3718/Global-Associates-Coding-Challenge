package com.im.db;

import java.util.ArrayList;
import java.util.List;

import com.im.business.Item;

public class ItemDB {

	public static List<Item> Items = new ArrayList<Item>();

	public static void add(Item item) {
		Items.add(item);
	}

	public static Item get(int id) {
		return Items.get(id);
	}

	public static Item getByName(String name) {
		for (Item i : Items) {
			if (i.getName().equals(name)) {
				return i;
			}
		}

		return null;

	}

	public static List<Item> list() {
		return Items;
	}

	public static void updateItems(int days) {
		for (int i = 0; i < days; i++) {
			for (Item item : Items) {
				item.updateQuality();
			}
		}
	}

	public static void deleteItem(Item item) {
		for (Item i : Items) {
			if (i.getName().equals(item.getName())) {
				Items.remove(i);
				break;
			}
		}
	}

}
