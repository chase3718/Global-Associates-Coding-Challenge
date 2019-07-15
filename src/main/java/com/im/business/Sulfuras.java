package com.im.business;

public class Sulfuras extends Item {
	
	public Sulfuras (String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public Sulfuras(Item item) {
		super(item.getName(), item.getSellIn(), item.getQuality());
	}

	public void updateQuality() {
		if (this.getQuality() != 80) {
			this.setQuality(80);
		}
	}
	
}
