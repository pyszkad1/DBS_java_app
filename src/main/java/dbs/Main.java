package dbs;

import jakarta.persistence.*;

public class Main {




    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbs");

        DAO dao = new DAO(emf);
        ServiceLevel sl = new ServiceLevel(dao.getEm());


        Tests t = new Tests();
//        t.test1(dao, sl);
//        t.test2(dao, sl);
//        t.test3(dao, sl);
//        t.test4(dao, sl);
//        t.test5(dao, sl);
//        t.test6(dao, sl);
        t.test7(dao, sl);


        dao.close();

    }


}