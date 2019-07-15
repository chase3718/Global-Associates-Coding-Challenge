package com.im.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.im.business.AgedBrie;
import com.im.business.BackstagePass;
import com.im.business.Common;
import com.im.business.Item;
import com.im.business.JsonResponse;
import com.im.business.Sulfuras;
import com.im.db.ItemDB;

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ItemController {
	
	@GetMapping("/")
	public JsonResponse list() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(ItemDB.list());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Item i = ItemDB.get(id);
			if (i != null) {
				jr = JsonResponse.getInstance(i);
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@GetMapping("/progress-days/{days}")
	public JsonResponse progressDays(@PathVariable int days) {
		JsonResponse jr = null;
		try {
			ItemDB.updateItems(days);
			jr = JsonResponse.getInstance(ItemDB.list());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping("/add")
	public JsonResponse addItem(@RequestBody Item item, @RequestParam String type) {
		JsonResponse jr = null;
		try {
			if (type.equalsIgnoreCase("common")) {
				jr = JsonResponse.getInstance(ItemDB.add(new Common(item)));
			} else if (type.equalsIgnoreCase("aged brie")) {
				jr = JsonResponse.getInstance(ItemDB.add(new AgedBrie(item)));
			} else if (type.equalsIgnoreCase("sulfuras")) {
				jr = JsonResponse.getInstance(ItemDB.add(new Sulfuras(item)));
			} else if (type.equalsIgnoreCase("backstage pass")) {
				jr = JsonResponse.getInstance(ItemDB.add(new BackstagePass(item)));
			}
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	};

	@DeleteMapping("/")
	public JsonResponse deleteItem(@RequestBody Item item) {
		JsonResponse jr = null;
		try {
			ItemDB.deleteItem(item);
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
}
