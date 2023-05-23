package dbs;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbs");

        DAO dao = new DAO(emf);
        System.out.println(dao.getClub(dao.getEm(), 1));
        System.out.println(dao.getPerson(dao.getEm(), 1));


    }


}