package com.example.product.service.impl;


import com.example.product.model.QuanLyChatLieu;
import com.example.product.repository.IQuanLyChatLieuRepository;
import com.example.product.repository.impl.QuanLyChatLieuRepository;
import com.example.product.service.IQuanLyChatLieuService;

import java.util.List;

public class QuanLyChatLieuService implements IQuanLyChatLieuService {
    private static IQuanLyChatLieuRepository quanLyChatLieuRepository =  new QuanLyChatLieuRepository();


    @Override
    public void insert(QuanLyChatLieu quanLyChatLieu) {
        quanLyChatLieuRepository.insert(quanLyChatLieu);
    }

    @Override
    public QuanLyChatLieu select(String id) {
        return quanLyChatLieuRepository.selectUser(id);
    }

    @Override
    public List<QuanLyChatLieu> selectAll() {
        return quanLyChatLieuRepository.displayAll();
    }

    @Override
    public boolean update(QuanLyChatLieu quanLyChatLieu) {
        return quanLyChatLieuRepository.update(quanLyChatLieu);
    }

    @Override
    public List<QuanLyChatLieu> selectAllByName(String name) {
        return quanLyChatLieuRepository.selectAllByName(name);
    }

    @Override
    public int getIdByCode(String code) {
        return quanLyChatLieuRepository.getIdByCode(code);
    }

    @Override
    public List<String> getAllName() {
        return quanLyChatLieuRepository.getAllName();
    }

}
