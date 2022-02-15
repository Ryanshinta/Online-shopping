package dao;

import entity.item;

/**
 * @author Ryan Ouyang
 */
public interface itemMapper {

    boolean newItem(item i);

    boolean deleteById(Long Id);

    boolean updateItemById(Long Id, item newItem);

    item searchById(long Id);
    
    //dsgsd

}
