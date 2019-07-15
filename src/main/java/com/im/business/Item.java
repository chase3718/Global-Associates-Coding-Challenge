package com.im.business;

public abstract class Item implements updatable {
	private String Name;
	private int SellIn;
	private int Quality;
	
	public Item() {
		
	}
	
	public Item(String name, int sellIn, int quality) {
		Name = name;
		SellIn = sellIn;
		Quality = quality;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getSellIn() {
		return SellIn;
	}

	public void setSellIn(int sellIn) {
		SellIn = sellIn;
	}

	public int getQuality() {
		return Quality;
	}

	public void setQuality(int quality) {
		Quality = quality;
	}
	
}
