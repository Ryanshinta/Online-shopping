package service;

import dao.itemMapper;
import entity.item;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * @author Ryan
 */
public class ItemService implements itemMapper {

    static private HashMap<Long, item> itemMap = new HashMap();


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
        if (!itemMap.isEmpty() && itemMap.get(Id) != null) {
            itemMap.remove(Id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateItemById(Long Id, item newItem) {
        if (!itemMap.isEmpty() && itemMap.containsKey(Id)){
            item oldItem = itemMap.get(Id);
            return itemMap.replace(Id,oldItem,newItem);
        }
        return false;
    }

    @Override
    public item searchById(long Id) {
        if (!itemMap.isEmpty() && itemMap.get(Id) != null) {
            return itemMap.get(Id);
        }
        return null;
    }

    @Override
    public List displayAllItem() {
        if (!itemMap.isEmpty()){
            return Collections.singletonList(itemMap);
        }
        return null;
    }
}
