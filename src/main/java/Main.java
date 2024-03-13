import java.util.Scanner;
import sr.qualogy.entity.Klant;
import sr.qualogy.service.KlantService;

public class Main {

    public static KlantService klantservice = new KlantService();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a klant");
            System.out.println("2. Read a klant");
            System.out.println("3. Update a klant");
            System.out.println("4. Delete a klant");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the gebruikersnaam:");
                    String gebruikersnaam = scanner.next();

                    System.out.println("Enter the voornaam:");
                    String voornaam = scanner.next();

                    System.out.println("Enter the achternaam:");
                    String achternaam = scanner.next();

                    System.out.println("Enter the email:");
                    String email = scanner.next();

                    System.out.println("Enter the adres:");
                    String adres = scanner.next();


                    Klant klant = new Klant();
                    klant.setGebruikersnaam(gebruikersnaam);
                    klant.setVoornaam(voornaam);
                    klant.setAchternaam(achternaam);
                    klant.setEmail(email);
                    klant.setAdres(adres);

                    klantservice.saveKlant(klant);

                    System.out.println("klant created successfully!");
                    break;

                case 2:
                    System.out.println("Enter the ID of the klant:");
                    int id = scanner.nextInt();

                    klant = klantservice.getKlantById(id);

                    if (klant != null) {
                        System.out.println("gebruikersnaam: " + klant.getGebruikersnaam());
                        System.out.println("voornaam: " + klant.getVoornaam());
                        System.out.println("achternaam: " + klant.getAchternaam());
                        System.out.println("email: " + klant.getEmail());
                        System.out.println("adres: " + klant.getAdres());
                    } else {
                        System.out.println("Klant not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the ID of the klant3:");
                    id = scanner.nextInt();

                    klant = klantservice.getKlantById(id);

                    if (klant != null) {
                        System.out.println("Enter the new gebruikersnaam:");
                        gebruikersnaam = scanner.next();
                        klant.setGebruikersnaam(gebruikersnaam);

                        System.out.println("Enter the new voornaam:");
                        voornaam = scanner.next();
                        klant.setVoornaam(voornaam);

                        System.out.println("Enter the new achternaam:");
                        achternaam = scanner.next();
                        klant.setAchternaam(achternaam);

                        System.out.println("Enter the new email:");
                        email = scanner.next();
                        klant.setEmail(email);

                        System.out.println("Enter the new adres:");
                        adres = scanner.next();
                        klant.setAdres(adres);

                        klantservice.updateKlant(klant);

                        System.out.println("klant updated successfully!");
                    } else {
                        System.out.println("klant not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the ID of the klant:");
                    id = scanner.nextInt();

                    klantservice.deleteKlant(id);

                    System.out.println("klant deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

