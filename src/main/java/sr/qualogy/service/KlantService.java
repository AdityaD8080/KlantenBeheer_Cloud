package sr.qualogy.service;

import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.repository.KlantRepository;
import sr.qualogy.entity.Klant;
import java.util.List;

public class KlantService {

    public final KlantRepository klantRepository;

    public KlantService() {
        this.klantRepository = new KlantRepository(JPAConfiguration.getEntityManager());
    }
    public List<Klant> getAllKlanten() {
        return klantRepository.getAllKlanten();
    }

    public Klant getKlantById(int klantId) {
        return klantRepository.getKlantById(klantId);
    }

    public  Klant saveKlant(Klant klant) {
        return klantRepository.saveKlant(klant);
    }

    public Klant updateKlant(Klant klant) {
        return klantRepository.updateKlant(klant);
    }

    public Klant updateKlantById(int klantId, Klant updatedKlant) {
        return klantRepository.updateKlantById(klantId, updatedKlant);
    }

    public void deleteKlant(int klantId) {
        klantRepository.deleteKlant(klantId);
    }
}
