package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.menuApi.Item;
import edu.northeastern.cs5200.menuApi.MenuApus;
import edu.northeastern.cs5200.models.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    List<Menu> getMenuItems(String key);

}
