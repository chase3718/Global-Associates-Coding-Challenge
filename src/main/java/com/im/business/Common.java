package com.im.business;

public class Common extends Item {
	
	public Common (String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public Common(Item item) {
		super(item.getName(), item.getSellIn(), item.getQuality());
	}

	public void updateQuality() {
		if (this.getQuality() > 50) {
			this.setQuality(50);
		}
		if (this.getSellIn() >= 0) {
			if (this.getQuality() > 0) {
				this.setQuality(this.getQuality() - 1);
			}
		} else {
			if (this.getQuality() > 0)
				this.setQuality(this.getQuality() - 1);
		}

		if (this.getQuality() < 0) {
			this.setQuality(0);
		}
		
		this.setSellIn(this.getSellIn() - 1);
	}
}
