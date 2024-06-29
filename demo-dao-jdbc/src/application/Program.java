package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

import java.util.List;

public class Program{
    public static void main(String[] args){
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();

        System.out.println("=== TESTE N1: seller findById -");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== TESTE N2: seller findByDepartmentId -");
        List<Seller> findByDepartmentIdList = sellerDAO.findByDepartmentId(2);
        for(Seller item : findByDepartmentIdList){
            System.out.println(item);
        }

        System.out.println();
        System.out.println("=== TESTE N3: seller findAll -");
        List<Seller> findAllList = sellerDAO.findAll();
        for(Seller item : findAllList){
            System.out.println(item);
        }
    }
}