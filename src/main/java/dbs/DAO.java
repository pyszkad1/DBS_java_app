package dbs;

import jakarta.persistence.*;

public class DAO {


    private EntityManager em;

    public DAO(EntityManagerFactory emf) {

        em = emf.createEntityManager();
    }


    public static void createPerson(EntityManager em, Integer personalNumber, String firstName, String lastName, Club club) {
        em.getTransaction().begin();
        Person person = new Person(personalNumber, firstName, lastName, club);
        em.persist(person);
        em.getTransaction().commit();
    }

    public static void createClub(EntityManager em, Integer clubNumber, String name, String address, String federation) {
        em.getTransaction().begin();
        Club club = new Club(clubNumber, name, address, federation);
        em.persist(club);
        em.getTransaction().commit();
    }

    public Club getClub(EntityManager em, Integer clubNumber) {
        return em.find(Club.class, clubNumber);
    }

    public Person getPerson(EntityManager em, Integer personalNumber) {
        return em.find(Person.class, personalNumber);
    }

    public Player getPlayer(EntityManager em, Integer personalNumber) {
        return em.find(Player.class, personalNumber);
    }

    public EntityManager getEm() {
        return em;
    }


}
