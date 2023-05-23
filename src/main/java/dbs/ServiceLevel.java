package dbs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ServiceLevel {

    private EntityManager em;

    public ServiceLevel(EntityManager em) {
        this.em = em;
    }


    public String getPlayersInTournament(EntityManager em, Integer tournamentId) {
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

}
