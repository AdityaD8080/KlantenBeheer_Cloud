package sr.qualogy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import sr.qualogy.entity.Bestellingen;

import java.util.List;

public class BestellingRepository {

    private final EntityManager entityManager;

    public BestellingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Bestellingen saveBestelling(Bestellingen bestelling) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(bestelling);
            transaction.commit();
            return bestelling;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Rethrow the exception after rollback
        }
    }

    public List<Bestellingen> getAllBestellingen() {
        String jpql = "SELECT b FROM Bestellingen b";
        TypedQuery<Bestellingen> typedQuery = entityManager.createQuery(jpql, Bestellingen.class);
        return typedQuery.getResultList();
    }

    public Bestellingen getBestellingById(int bestellingId) {
        return entityManager.find(Bestellingen.class, bestellingId);
    }

    public Bestellingen updateBestelling(Bestellingen bestelling) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Bestellingen updatedBestelling = entityManager.merge(bestelling);
            transaction.commit();
            return updatedBestelling;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Bestellingen updateBestellingById(int bestellingId, Bestellingen updatedBestelling) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Bestellingen existingBestelling = getBestellingById(bestellingId);
            if (existingBestelling != null) {
                existingBestelling.setKlant(updatedBestelling.getKlant());
                existingBestelling.setBestelDatum(updatedBestelling.getBestelDatum());
                existingBestelling.setTotaalBedrag(updatedBestelling.getTotaalBedrag());
                existingBestelling.setVerzendadres(updatedBestelling.getVerzendadres());
                existingBestelling.setBetaalStatus(updatedBestelling.getBetaalStatus());
            }
            transaction.commit();
            return existingBestelling;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void deleteBestelling(int bestellingId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Bestellingen bestelling = entityManager.find(Bestellingen.class, bestellingId);
            if (bestelling != null) {
                entityManager.remove(bestelling);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
