package sr.qualogy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "Producten")
public class Producten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    @Column(name = "ProductNaam", nullable = false, length = 255)
    private String productNaam;

    @Column(name = "Prijs", nullable = false, precision = 12, scale = 2)
    private BigDecimal prijs;


    @Column(name = "VoorraadAantal", nullable = false)
    private Integer voorraadAantal;

    @Column(name = "Omschrijving", columnDefinition = "TEXT")
    private String omschrijving;

    @Column(name = "Merk", length = 50)
    private String merk;

    public Producten() {
        // Default constructor required by JPA
    }

    public Producten(Integer productID, String productNaam, BigDecimal prijs, Integer voorraadAantal, String omschrijving, String merk) {
        this.productID = productID;
        this.productNaam = productNaam;
        this.prijs = prijs;
        this.voorraadAantal = voorraadAantal;
        this.omschrijving = omschrijving;
        this.merk = merk;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public Integer getVoorraadAantal() {
        return voorraadAantal;
    }

    public void setVoorraadAantal(Integer voorraadAantal) {
        this.voorraadAantal = voorraadAantal;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
