package sr.qualogy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import sr.qualogy.entity.BestellingItems;

import java.util.List;

public class BestellingItemsRepository {

    private EntityManager entityManager;

    public BestellingItemsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BestellingItems saveBestellingItem(BestellingItems bestellingItem) {
        entityManager.getTransaction().begin();
        entityManager.persist(bestellingItem);
        entityManager.getTransaction().commit();

        return bestellingItem;
    }

    public List<BestellingItems> getAllBestellingItems() {
        String jpql = "SELECT bi FROM BestellingItems bi";
        TypedQuery<BestellingItems> typedQuery = entityManager.createQuery(jpql, BestellingItems.class);
        return typedQuery.getResultList();
    }

    public BestellingItems getBestellingItemById(int bestellingItemId) {
        return entityManager.find(BestellingItems.class, bestellingItemId);
    }

    public BestellingItems updateBestellingItem(BestellingItems bestellingItem) {
        entityManager.getTransaction().begin();
        BestellingItems updatedBestellingItem = entityManager.merge(bestellingItem);
        entityManager.getTransaction().commit();
        return updatedBestellingItem;
    }

    public void deleteBestellingItem(int bestellingItemId) {
        BestellingItems bestellingItem = entityManager.find(BestellingItems.class, bestellingItemId);
        if (bestellingItem != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(bestellingItem);
            entityManager.getTransaction().commit();
        }
    }
}

