package service;

import dao.itemMapper;
import entity.item;

import java.util.HashMap;


/**
 * @author Ryan
 */
public class ItemService implements itemMapper {

    static public HashMap<Long, item> itemMap = new HashMap();


    @Override
    public boolean newItem(item i) {
        if (i != null){
            itemMap.put(i.getItemID(),i);
            return true;
        }
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
        if (itemMap.isEmpty()){
            return null;
        }
        if (itemMap.get(Id) != null){

        }
        return null;
    }
}