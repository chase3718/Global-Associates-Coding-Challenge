package com.im.business;

public class BackstagePass extends Item {
	
	public BackstagePass (String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public BackstagePass(Item item) {
		super(item.getName(), item.getSellIn(), item.getQuality());
	}

	public void updateQuality() {
		if (this.getQuality() > 50) {
			this.setQuality(50);
		}
		if (this.getSellIn() > 10) {
			this.setQuality(this.getQuality() + 1);
		} else if (this.getSellIn() >= 0) {
			this.setQuality(this.getQuality() + 2);
		} else {
			this.setQuality(0);
		}

		if (this.getQuality() < 0) {
			this.setQuality(0);
		}
		
		this.setSellIn(this.getSellIn() - 1);
	}
}
