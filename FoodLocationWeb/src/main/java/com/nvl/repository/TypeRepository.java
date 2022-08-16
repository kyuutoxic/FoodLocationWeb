/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.repository;

import com.nvl.pojo.Type;
import java.util.List;

/**
 *
 * @author kyuut
 */
public interface TypeRepository {
    List<Type> getType();
    Type getTypeById(int typeId);
}
