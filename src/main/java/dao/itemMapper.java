package dao;

import main.entity.item;

/**
 * @author Ryan Ouyang
 */
public interface itemMapper {

    boolean newItem(item i);

    boolean deleteById(Long Id);

    boolean updateItemById(Long Id);

    item searchById(long Id);

}
