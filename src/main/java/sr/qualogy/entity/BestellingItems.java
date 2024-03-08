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
@Table(name = "BestellingItems")
public class BestellingItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bestellingItemID;

    @ManyToOne
    @JoinColumn(name = "BestellingID", nullable = false)
    private Bestellingen bestelling;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Producten product;

    @Column(name = "Hoeveelheid", nullable = false)
    private Integer hoeveelheid;

    @Column(name = "PrijsPerStuk", nullable = false, precision = 12, scale = 2)
    private BigDecimal prijsPerStuk;

    @Column(name = "TotaalPrijs", nullable = false, precision = 12, scale = 2)
    private BigDecimal totaalPrijs;

    public BestellingItems() {
        // Default constructor required by JPA
    }

    public BestellingItems(Integer bestellingItemID, Bestellingen bestelling, Producten product, Integer hoeveelheid, BigDecimal prijsPerStuk, BigDecimal totaalPrijs) {
        this.bestellingItemID = bestellingItemID;
        this.bestelling = bestelling;
        this.product = product;
        this.hoeveelheid = hoeveelheid;
        this.prijsPerStuk = prijsPerStuk;
        this.totaalPrijs = totaalPrijs;
    }

    public Integer getBestellingItemID() {
        return bestellingItemID;
    }

    public void setBestellingItemID(Integer bestellingItemID) {
        this.bestellingItemID = bestellingItemID;
    }

    public Bestellingen getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestellingen bestelling) {
        this.bestelling = bestelling;
    }

    public Producten getProduct() {
        return product;
    }

    public void setProduct(Producten product) {
        this.product = product;
    }

    public Integer getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(Integer hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public BigDecimal getPrijsPerStuk() {
        return prijsPerStuk;
    }

    public void setPrijsPerStuk(BigDecimal prijsPerStuk) {
        this.prijsPerStuk = prijsPerStuk;
    }

    public BigDecimal getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(BigDecimal totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }
}
