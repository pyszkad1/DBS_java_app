package dbs;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbs");

        DAO dao = new DAO(emf);
        ServiceLevel sl = new ServiceLevel(dao.getEm());
//        System.out.println(dao.getClub(dao.getEm(), 1));
//        System.out.println(dao.getPerson(dao.getEm(), 1));

        System.out.println(sl.getResultsByPlayerIdAndTournament(dao.getEm(), 888, 1));


    }


}