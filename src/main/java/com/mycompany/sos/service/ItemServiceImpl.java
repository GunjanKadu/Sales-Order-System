/**
 * 
 */
package com.mycompany.sos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sos.dao.ItemDao;
import com.mycompany.sos.dao.entities.ItemEntity;

/**
 * @author colin
 *
 */
@Service("itemServiceImpl")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public boolean addItem(ItemEntity item) {
		return itemDao.addItem(item);
	}

}
