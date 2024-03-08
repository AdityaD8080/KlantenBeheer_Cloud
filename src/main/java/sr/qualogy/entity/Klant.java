package sr.qualogy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Klant")
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer klantID;

    @Column(name = "Gebruikersnaam", nullable = false, length = 50)
    private String gebruikersnaam;

    @Column(name = "Voornaam", nullable = false, length = 50)
    private String voornaam;

    @Column(name = "Achternaam", nullable = false, length = 50)
    private String achternaam;

    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "Adres", length = 255)
    private String adres;

    public Klant() {
        // Default constructor required by JPA
    }

    public Klant(Integer klantID, String gebruikersnaam, String voornaam, String achternaam, String email, String adres) {
        this.klantID = klantID;
        this.gebruikersnaam = gebruikersnaam;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.adres = adres;
    }

    public Integer getKlantID() {
        return klantID;
    }

    public void setKlantID(Integer klantID) {
        this.klantID = klantID;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}