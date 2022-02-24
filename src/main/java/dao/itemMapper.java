package dao;

import entity.item;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ryan Ouyang
 */
public interface itemMapper {

    boolean newItem(item i);

    boolean deleteById(Integer Id);

    boolean updateItemById(Integer Id, item newItem);

    item searchById(Integer Id);

    HashMap<Integer,item> displayAllItem();

}
