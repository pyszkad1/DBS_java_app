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


//    public String getResultsByPlayerIdAndTournament(EntityManager em, Integer personalNumber, Integer tournamentId) {
//        TypedQuery<TResult> query = em.createQuery("SELECT r FROM TResult r WHERE (r.id.player1 = :personalNumber OR r.id.player2 = :personalNumber OR r.id.player3 = :personalNumber OR r.id.player4 = :personalNumber) AND r.id.tournamentId = :tournamentId", TResult.class);
//        query.setParameter("personalNumber", personalNumber);
//        query.setParameter("tournamentId", tournamentId);
//        List<TResult> results = query.getResultList();
//        StringBuilder sb = new StringBuilder();
//        for (TResult result : results) {
//            sb.append(result.toString());
//        }
//        return sb.toString();
//    }
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
