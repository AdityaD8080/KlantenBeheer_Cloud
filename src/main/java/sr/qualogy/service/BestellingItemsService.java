package sr.qualogy.service;

import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.repository.BestellingItemsRepository;
import sr.qualogy.entity.BestellingItems;
import java.util.List;

public class BestellingItemsService {

    private BestellingItemsRepository bestellingItemsRepository;

    public BestellingItemsService() {
        this.bestellingItemsRepository = new BestellingItemsRepository(JPAConfiguration.getEntityManager());
    }

    public BestellingItems saveBestellingItem(BestellingItems bestellingItem) {
        return bestellingItemsRepository.saveBestellingItem(bestellingItem);
    }

    public List<BestellingItems> getAllBestellingItems() {
        return bestellingItemsRepository.getAllBestellingItems();
    }

    public BestellingItems getBestellingItemById(int bestellingItemId) {
        return bestellingItemsRepository.getBestellingItemById(bestellingItemId);
    }

    public BestellingItems updateBestellingItem(BestellingItems bestellingItem) {
        return bestellingItemsRepository.updateBestellingItem(bestellingItem);
    }

    public void deleteBestellingItem(int bestellingItemId) {
        bestellingItemsRepository.deleteBestellingItem(bestellingItemId);
    }
}
