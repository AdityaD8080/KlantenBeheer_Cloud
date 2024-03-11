package sr.qualogy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.qualogy.entity.Bestellingen;

import java.util.List;

public class BestellingRepository {

    private final EntityManager entityManager;

    public BestellingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Bestellingen saveBestelling(Bestellingen bestelling) {
        entityManager.getTransaction().begin();
        entityManager.persist(bestelling);
        entityManager.getTransaction().commit();

        return bestelling;
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
        entityManager.getTransaction().begin();
        Bestellingen updatedBestelling = entityManager.merge(bestelling);
        entityManager.getTransaction().commit();
        return updatedBestelling;
    }

    public Bestellingen updateBestellingById(int bestellingId, Bestellingen updatedBestelling) {
        Bestellingen existingBestelling = getBestellingById(bestellingId);
        if (existingBestelling != null) {
            entityManager.getTransaction().begin();
            existingBestelling.setKlant(updatedBestelling.getKlant());
            existingBestelling.setBestelDatum(updatedBestelling.getBestelDatum());
            existingBestelling.setTotaalBedrag(updatedBestelling.getTotaalBedrag());
            existingBestelling.setVerzendadres(updatedBestelling.getVerzendadres());
            existingBestelling.setBetaalStatus(updatedBestelling.getBetaalStatus());
            entityManager.getTransaction().commit();
        }
        return existingBestelling;
    }


    public void deleteBestelling(int bestellingId) {
        Bestellingen bestelling = entityManager.find(Bestellingen.class, bestellingId);
        if (bestelling != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(bestelling);
            entityManager.getTransaction().commit();
        }
    }
}