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

        System.out.println();
        System.out.println("=== TESTE N4: seller insert -");
        // Seller newSeller = new Seller(null, "Emil", "emil@gmail.com", new Date(), 4000.0, new Department(2, null));
        // sellerDAO.insert(newSeller);
        // System.out.println(newSeller);

        System.out.println();
        System.out.println("=== TESTE N5: seller update -");
        Seller seller1 = sellerDAO.findById(2);
        System.out.println(seller1);
        seller1.setName("Clark");
        seller1.setEmail("clark@gmail.com");
        sellerDAO.update(seller1);
        System.out.println(seller1);
    }
}