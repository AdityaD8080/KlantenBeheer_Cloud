package sr.qualogy.service;

import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.repository.BestellingRepository;
import sr.qualogy.entity.Bestellingen;
import java.util.List;

public class BestellingService {

    private BestellingRepository bestellingRepository;

    public BestellingService() {
        this.bestellingRepository = new BestellingRepository(JPAConfiguration.getEntityManager());
    }

    public Bestellingen saveBestelling(Bestellingen bestelling) {
        return bestellingRepository.saveBestelling(bestelling);
    }

    public List<Bestellingen> getAllBestellingen() {
        return bestellingRepository.getAllBestellingen();
    }

    public Bestellingen getBestellingById(int bestellingId) {
        return bestellingRepository.getBestellingById(bestellingId);
    }

    public Bestellingen updateBestelling(Bestellingen bestelling) {
        return bestellingRepository.updateBestelling(bestelling);
    }

    public void deleteBestelling(int bestellingId) {
        bestellingRepository.deleteBestelling(bestellingId);
    }
}
