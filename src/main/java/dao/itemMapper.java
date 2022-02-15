package dao;

import entity.item;

import java.util.List;

/**
 * @author Ryan Ouyang
 */
public interface itemMapper {

    boolean newItem(item i);

    boolean deleteById(Long Id);

    boolean updateItemById(Long Id, item newItem);

    item searchById(long Id);

    List displayAllItem();
    
    //dsgsd

}
