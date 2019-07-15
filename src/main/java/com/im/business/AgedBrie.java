package com.im.business;

public class AgedBrie extends Item {
	
	public AgedBrie (String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public AgedBrie(Item item) {
		super(item.getName(), item.getSellIn(), item.getQuality());
	}

	public void updateQuality() {
		if (this.getQuality() > 50) {
			this.setQuality(50);
		}

		if (this.getQuality() < 50) {
			this.setQuality(this.getQuality() + 1);
		}
		
		if (this.getQuality() < 0) {
			this.setQuality(0);
		}
		
		this.setSellIn(this.getSellIn() - 1);
	}
}
