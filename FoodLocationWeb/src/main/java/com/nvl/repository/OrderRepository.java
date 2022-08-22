/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvl.repository;

import com.nvl.pojo.Cart;
import com.nvl.pojo.MenuOrder;
import com.nvl.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author duonghuuthanh
 */
public interface OrderRepository {

    boolean addReceipt(Map<Integer, Cart> cart, User user, float total);

    List<MenuOrder> getOrder(int storeId);

}
