package sr.qualogy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.qualogy.entity.Klant;
import java.util.List;
public class KlantRepository implements KlantRepositoryRP {

    private EntityManager entityManager;

    public KlantRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Klant getKlantById(int klantId) {
        return entityManager.find(Klant.class, klantId);
    }

    @Override
    public List<Klant> getAllKlanten() {
        String jpql = "SELECT k FROM Klant k";
        TypedQuery<Klant> typedQuery = entityManager.createQuery(jpql, Klant.class);
        return typedQuery.getResultList();
    }

    @Override
    public Klant saveKlant(Klant klant) {
        entityManager.getTransaction().begin();
        entityManager.persist(klant);
        entityManager.getTransaction().commit();
        return klant;
    }

    @Override
    public Klant updateKlant(Klant klant) {
        entityManager.getTransaction().begin();
        Klant updatedKlant = entityManager.merge(klant);
        entityManager.getTransaction().commit();
        return updatedKlant;
    }

    @Override
    public void deleteKlant(int klantId) {
        Klant klant = entityManager.find(Klant.class, klantId);
        if (klant != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(klant);
            entityManager.getTransaction().commit();
        }
    }
}
