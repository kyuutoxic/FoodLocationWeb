/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.service.impl;

import com.nvl.pojo.Type;
import com.nvl.repository.TypeRepository;
import com.nvl.service.TypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyuut
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getType() {
        return this.typeRepository.getType();
    }

    @Override
    public Type getTypeById(int typeId) {
        return this.typeRepository.getTypeById(typeId);
    }

}
