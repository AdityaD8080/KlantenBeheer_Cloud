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
    public Klant updateKlantById(int klantId, Klant updatedKlant) {
        Klant existingKlant = getKlantById(klantId);
        if (existingKlant != null) {
            entityManager.getTransaction().begin();
            existingKlant.setGebruikersnaam(updatedKlant.getGebruikersnaam());
            existingKlant.setVoornaam(updatedKlant.getVoornaam());
            existingKlant.setAchternaam(updatedKlant.getAchternaam());
            existingKlant.setEmail(updatedKlant.getEmail());
            existingKlant.setAdres(updatedKlant.getAdres());
            entityManager.getTransaction().commit();
        }
        return existingKlant;
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

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.TypedQuery;
//import sr.qualogy.entity.Klant;
//
//import java.util.List;
//
//public class KlantRepository implements KlantRepositoryRP {
//
//    private final EntityManager entityManager;
//
//    public KlantRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public Klant getKlantById(int klantId) {
//        return entityManager.find(Klant.class, klantId);
//    }
//
//    @Override
//    public List<Klant> getAllKlanten() {
//        String jpql = "SELECT k FROM Klant k";
//        TypedQuery<Klant> typedQuery = entityManager.createQuery(jpql, Klant.class);
//        return typedQuery.getResultList();
//    }
//
//    @Override
//    public Klant saveKlant(Klant klant) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            entityManager.persist(klant);
//            transaction.commit();
//            return klant;
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw e; // Rethrow the exception after rollback
//        }
//    }
//
//    @Override
//    public Klant updateKlant(Klant klant) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            Klant updatedKlant = entityManager.merge(klant);
//            transaction.commit();
//            return updatedKlant;
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw e;
//        }
//    }
//
//    @Override
//    public Klant updateKlantById(int klantId, Klant updatedKlant) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            Klant existingKlant = getKlantById(klantId);
//            if (existingKlant != null) {
//                existingKlant.setGebruikersnaam(updatedKlant.getGebruikersnaam());
//                existingKlant.setVoornaam(updatedKlant.getVoornaam());
//                existingKlant.setAchternaam(updatedKlant.getAchternaam());
//                existingKlant.setEmail(updatedKlant.getEmail());
//                existingKlant.setAdres(updatedKlant.getAdres());
//            }
//            transaction.commit();
//            return existingKlant;
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw e;
//        }
//    }
//
////    @Override
////    public void deleteKlant(int klantId) {
////        EntityTransaction transaction = entityManager.getTransaction();
////        try {
////            transaction.begin();
////            Klant klant = entityManager.find(Klant.class, klantId);
////            if (klant != null) {
////                entityManager.remove(klant);
////            }
////            transaction.commit();
////        } catch (Exception e) {
////            if (transaction.isActive()) {
////                transaction.rollback();
////            }
////            throw e;
////        }
////    }
//    @Override
//    public void deleteKlant(int klantId) {
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {
//            transaction.begin();
//            Klant klant = entityManager.find(Klant.class, klantId);
//            if (klant != null) {
//                entityManager.remove(klant);
//            }
//            transaction.commit();
//        } catch (EntityNotFoundException e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw new RuntimeException("This Klant is referenced in another table and cannot be deleted.");
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw e;
//        }
//    }
//
//}

