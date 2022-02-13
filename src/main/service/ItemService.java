package main.service;

import main.dao.itemMapper;
import main.entity.item;

/**
 * @author Ryan
 */
public class ItemService implements itemMapper {

    //todo


    @Override
    public boolean newItem(item i) {
        return false;
    }

    @Override
    public boolean deleteById(Long Id) {
        return false;
    }

    @Override
    public boolean updateItemById(Long Id) {
        return false;
    }

    @Override
    public item searchById(long Id) {
        return null;
    }
}
