package model.dao.impl;

import model.dao.SellerDAO;
import model.entities.Seller;

import java.util.List;

public class SellerDAOJDBC implements SellerDAO{
    @Override
    public void insert(Seller department){

    }

    @Override
    public void update(Seller department){

    }

    @Override
    public void deleteById(Integer Id){

    }

    @Override
    public Seller findById(Integer Id){
        return null;
    }

    @Override
    public List<Seller> findAll(){
        return List.of();
    }
}
