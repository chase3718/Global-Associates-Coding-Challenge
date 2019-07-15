package com.im.business;

public class Conjured extends Item {
	public Conjured (String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateQuality() {
		if (this.getQuality() > 50) {
			this.setQuality(50);
		}
		if (this.getSellIn() >= 0) {
			if (this.getQuality() > 0) {
				this.setQuality(this.getQuality() - 2);
			}
		} else {
			if (this.getQuality() > 0)
				this.setQuality(this.getQuality() - 4);
		}
		
		if (this.getQuality() < 0) {
			this.setQuality(0);
		}
		
		this.setSellIn(this.getSellIn() - 1);
	}
}
