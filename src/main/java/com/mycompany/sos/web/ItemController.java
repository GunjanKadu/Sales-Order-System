/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.sos.repository.entities.ItemEntity;
import com.mycompany.sos.service.ItemService;
import com.mycompany.sos.web.viewmodel.forms.CreateItemForm;

/**
 * {@link ItemController} class
 * 
 * @author colin
 *
 */
@Controller
public class ItemController {
	
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ItemService itemService;
	
	
	/**
	 * Shows the items list page
	 * 
	 * @param model the model
	 * @return view name
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String showItemsList(ModelMap model) {
		List<ItemEntity> items = itemService.getItems();
		model.addAttribute("items", items);
		return "items";
	}
	
	/**
	 * Shows the create item form page
	 * 
	 * @param modelMap
	 * @return view name
	 */
	@RequestMapping(value = "/items/create", method = RequestMethod.GET)
	public String showCreateItemPage(ModelMap modelMap) {
		modelMap.addAttribute("createItemForm", new CreateItemForm());
		logger.info("Accessed Create Item page");
		if(logger.isDebugEnabled()) {
			logger.debug("Retrieved createItemForm");
		}
		return "items-create";
	}
	
	/**
	 * Handles the create item form submit
	 * 
	 * @param createItemForm the form backing object
	 * @param result Spring's framework binding result object
	 * @return model and view object
	 */
	@RequestMapping(value = "/items/createItem", method = RequestMethod.POST)
	public ModelAndView createItem(
			@Valid @ModelAttribute("createItemForm") ItemEntity itemEntity,
			BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors()) {
			modelAndView.setViewName("items-create");
			return modelAndView;
		}
		
		if(itemService.addItem(itemEntity)) {
			logger.info("Successfully added item");
			// should redirect back to items list page
			modelAndView.setViewName("redirect:/items");
		} else {
			logger.warn("Unable to add item");
		}
		
		return modelAndView;
	}
}