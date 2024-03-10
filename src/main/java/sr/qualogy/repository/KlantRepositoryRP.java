package sr.qualogy.repository;
import sr.qualogy.entity.Klant;
import java.util.List;

public interface KlantRepositoryRP {

    Klant getKlantById(int klantId);

    List<Klant> getAllKlanten();

    Klant saveKlant(Klant klant);

    Klant updateKlant(Klant klant);

    Klant updateKlantById(int klantId, Klant updatedKlant);

    void deleteKlant(int klantId);
}
