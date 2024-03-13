package sr.qualogy.service;

import sr.qualogy.entity.Bestellingen;
import java.util.List;

public interface BestellingenIMPL {

     Bestellingen saveBestelling(Bestellingen bestelling);

     List<Bestellingen> getAllBestellingen();


     Bestellingen getBestellingById(int bestellingId);


     Bestellingen updateBestelling(Bestellingen bestelling);

     Bestellingen updateBestellingById(int bestellingId, Bestellingen updatedBestelling);

     void deleteBestelling(int bestellingId);


}
