package edu.northeastern.cs5200.models;

import java.util.List;

public class SelectedMenuItems {

    private int id;
    private List<Menu> menuList;

    public SelectedMenuItems(){

    }

    public SelectedMenuItems(int id, List<Menu> menuList){
        this.id = id;
        this.menuList = menuList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
