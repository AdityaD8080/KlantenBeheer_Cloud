package sr.qualogy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "Bestellingen")
public class Bestellingen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bestellingID;

    @ManyToOne
    @JoinColumn(name = "KlantID", nullable = false)
    private Klant klant;

    @Column(name = "BestelDatum", nullable = false, length = 255)
    private String bestelDatum;

    @Column(name = "TotaalBedrag", nullable = false, precision = 12, scale = 2)
    private BigDecimal totaalBedrag;

    @Column(name = "Verzendadres", nullable = false, length = 255)
    private String verzendadres;

    @Column(name = "BetaalStatus", length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'In Afwachting'")
    private String betaalStatus;

    public Bestellingen() {
        // Default constructor required by JPA
    }

    public Bestellingen(Integer bestellingID, Klant klant, String bestelDatum, BigDecimal totaalBedrag, String verzendadres, String betaalStatus) {
        this.bestellingID = bestellingID;
        this.klant = klant;
        this.bestelDatum = bestelDatum;
        this.totaalBedrag = totaalBedrag;
        this.verzendadres = verzendadres;
        this.betaalStatus = betaalStatus;
    }

    public Integer getBestellingID() {
        return bestellingID;
    }

    public void setBestellingID(Integer bestellingID) {
        this.bestellingID = bestellingID;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public String getBestelDatum() {
        return bestelDatum;
    }

    public void setBestelDatum(String bestelDatum) {
        this.bestelDatum = bestelDatum;
    }

    public BigDecimal getTotaalBedrag() {
        return totaalBedrag;
    }

    public void setTotaalBedrag(BigDecimal totaalBedrag) {
        this.totaalBedrag = totaalBedrag;
    }

    public String getVerzendadres() {
        return verzendadres;
    }

    public void setVerzendadres(String verzendadres) {
        this.verzendadres = verzendadres;
    }

    public String getBetaalStatus() {
        return betaalStatus;
    }

    public void setBetaalStatus(String betaalStatus) {
        this.betaalStatus = betaalStatus;
    }
}
