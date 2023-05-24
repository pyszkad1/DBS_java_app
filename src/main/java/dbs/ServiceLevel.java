package dbs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceLevel {

    private EntityManager em;

    public ServiceLevel(EntityManager em) {
        this.em = em;
    }


    public List<PlayerInTournament> getPlayersInTournament(EntityManager em, Integer tournamentId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PlayerInTournament> cq = cb.createQuery(PlayerInTournament.class);
            Root<PlayerInTournament> root = cq.from(PlayerInTournament.class);

            Predicate tournamentPredicate = cb.equal(root.get("id").get("tournamentId"), tournamentId);

            cq.where(tournamentPredicate);

            TypedQuery<PlayerInTournament> query = em.createQuery(cq);
            List<PlayerInTournament> players = query.getResultList();

            return players;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public String getPlayersInTournamentInString(EntityManager em, Integer tournamentId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PlayerInTournament> cq = cb.createQuery(PlayerInTournament.class);
            Root<PlayerInTournament> root = cq.from(PlayerInTournament.class);

            Predicate tournamentPredicate = cb.equal(root.get("id").get("tournamentId"), tournamentId);

            cq.where(tournamentPredicate);

            TypedQuery<PlayerInTournament> query = em.createQuery(cq);
            List<PlayerInTournament> players = query.getResultList();

            StringBuilder sb = new StringBuilder();

            for (PlayerInTournament player : players) {

                Person p = em.find(Person.class, player.getId().getPlayerNumber());
                Integer playerNumber = player.getId().getPlayerNumber();
                String playerName = p.getFirstName() + " " + p.getLastName();


                sb.append(playerNumber + " " + playerName).append("\n");
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getResultsByPlayerIdAndTournament(EntityManager em, Integer personalNumber, Integer tournamentId) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TResult> cq = cb.createQuery(TResult.class);
            Root<TResult> root = cq.from(TResult.class);

            Predicate playerPredicate = cb.or(
                    cb.equal(root.get("id").get("player1"), personalNumber),
                    cb.equal(root.get("id").get("player2"), personalNumber),
                    cb.equal(root.get("id").get("player3"), personalNumber),
                    cb.equal(root.get("id").get("player4"), personalNumber)
            );

            Predicate tournamentPredicate = cb.equal(root.get("id").get("tournamentId"), tournamentId);

            cq.where(playerPredicate, tournamentPredicate);

            TypedQuery<TResult> query = em.createQuery(cq);
            List<TResult> results = query.getResultList();

            if (results.isEmpty()) {
                return "No results found for the player in the specified tournament.";
            }

            StringBuilder sb = new StringBuilder();
            for (TResult result : results) {
                sb.append(result.toString());
            }

            return sb.toString();
        } catch (Exception e) {
            // Handle any exception that occurred during the query execution
            e.printStackTrace();
            return "An error occurred while retrieving the results.";
        }
    }

    public void dropTournamentById(EntityManager em, Integer tournamentId) {
        try {
            Tournament tournament = em.find(Tournament.class, tournamentId);
            if (tournament == null) {
                throw new IllegalArgumentException("Tournament not found with ID: " + tournamentId);
            }
            for (PlayerInTournament p : this.getPlayersInTournament(em, tournamentId)) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }

            em.getTransaction().begin();
            em.remove(tournament);
            em.getTransaction().commit();
            System.out.println("Tournament with ID: " + tournamentId + " was successfully removed.");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle or throw the exception as needed
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }


    public void updatePlayerCategory(EntityManager em) {
        try {
            em.getTransaction().begin();

            LocalDate elevenYearsAgo = LocalDate.now().minusYears(11);

            Query updateQuery = em.createQuery("UPDATE Player p SET p.category = 'U11' WHERE p.dateOfBirth > :elevenYearsAgo AND p.category = 'U13'");
            updateQuery.setParameter("elevenYearsAgo", elevenYearsAgo);


            int updatedCount = updateQuery.executeUpdate();

            em.getTransaction().commit();

            System.out.println("Updated " + updatedCount + " player(s) successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void updatePlayerCategoryToOriginal(EntityManager em) {
        try {
            em.getTransaction().begin();

            Query updateQuery = em.createQuery("UPDATE Player p SET p.category = 'U13' WHERE p.category = 'U11'");
            int updatedCount = updateQuery.executeUpdate();

            em.getTransaction().commit();

            System.out.println("Updated " + updatedCount + " player(s) to original category successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }


    public void createResult(EntityManager em, Integer tournamentId, Integer boardNumber, String cards, Integer player1,
                             Integer player2, Integer player3, Integer player4, String contract, String declarer,
                             String contractResult, Integer points) {
        try {
            em.getTransaction().begin();

            // Retrieve the Tournament entity
            Tournament tournament = em.find(Tournament.class, tournamentId);

            // Create the composite primary key for TResult
            TResultId resultId = new TResultId(tournamentId, boardNumber, cards, player1, player2, player3, player4);

            // Create the TResult entity
            TResult resultEntity = new TResult(resultId, contract, declarer, contractResult, points);

            // Persist the TResult entity
            em.persist(resultEntity);

            em.getTransaction().commit();

            System.out.println("Result created successfully.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public void changeClubMembership(EntityManager em, Integer personalNumber, Integer newClubNumber) {
        try {
            em.getTransaction().begin();

            // Retrieve the Person entity
            Person person = em.find(Person.class, personalNumber);

            if (person != null) {
                // Retrieve the new Club entity
                Club newClub = em.find(Club.class, newClubNumber);

                if (newClub != null) {
                    // Update the club membership for the person
                    person.setClub(newClub);

                    // Persist the updated Person entity
                    em.persist(person);

                    em.getTransaction().commit();
                    System.out.println("Club membership updated successfully.");
                } else {
                    System.out.println("New club not found.");
                }
            } else {
                System.out.println("Person not found.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }








    public void rollback(EntityManager em) {
        try {
            em.getTransaction().rollback();
            System.out.println("Update rolled back successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
