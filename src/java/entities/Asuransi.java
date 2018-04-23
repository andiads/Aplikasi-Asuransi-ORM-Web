/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dbayu
 */
@Entity
@Table(name = "ASURANSI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asuransi.findAll", query = "SELECT a FROM Asuransi a")
    , @NamedQuery(name = "Asuransi.findByKodeAsuransi", query = "SELECT a FROM Asuransi a WHERE a.kodeAsuransi = :kodeAsuransi")
    , @NamedQuery(name = "Asuransi.findByJenisAsuransi", query = "SELECT a FROM Asuransi a WHERE a.jenisAsuransi = :jenisAsuransi")
    , @NamedQuery(name = "Asuransi.findByBunga", query = "SELECT a FROM Asuransi a WHERE a.bunga = :bunga")
    , @NamedQuery(name = "Asuransi.findByJmlBayar", query = "SELECT a FROM Asuransi a WHERE a.jmlBayar = :jmlBayar")
    , @NamedQuery(name = "Asuransi.findByMasaBerlaku", query = "SELECT a FROM Asuransi a WHERE a.masaBerlaku = :masaBerlaku")})
public class Asuransi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODE_ASURANSI")
    private String kodeAsuransi;
    @Column(name = "JENIS_ASURANSI")
    private String jenisAsuransi;
    @Column(name = "BUNGA")
    private BigInteger bunga;
    @Column(name = "JML_BAYAR")
    private BigInteger jmlBayar;
    @Column(name = "MASA_BERLAKU")
    private String masaBerlaku;
    @OneToMany(mappedBy = "kodeAsuransi", fetch = FetchType.LAZY)
    private List<Klaim> klaimList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kodeAsuransi", fetch = FetchType.LAZY)
    private List<DetailNasabah> detailNasabahList;
    @OneToMany(mappedBy = "kodeAsuransi", fetch = FetchType.LAZY)
    private List<Pembayaran> pembayaranList;

    public Asuransi() {
    }

    public Asuransi(String kodeAsuransi) {
        this.kodeAsuransi = kodeAsuransi;
    }

    public String getKodeAsuransi() {
        return kodeAsuransi;
    }

    public void setKodeAsuransi(String kodeAsuransi) {
        this.kodeAsuransi = kodeAsuransi;
    }

    public String getJenisAsuransi() {
        return jenisAsuransi;
    }

    public void setJenisAsuransi(String jenisAsuransi) {
        this.jenisAsuransi = jenisAsuransi;
    }

    public BigInteger getBunga() {
        return bunga;
    }

    public void setBunga(BigInteger bunga) {
        this.bunga = bunga;
    }

    public BigInteger getJmlBayar() {
        return jmlBayar;
    }

    public void setJmlBayar(BigInteger jmlBayar) {
        this.jmlBayar = jmlBayar;
    }

    public String getMasaBerlaku() {
        return masaBerlaku;
    }

    public void setMasaBerlaku(String masaBerlaku) {
        this.masaBerlaku = masaBerlaku;
    }

    @XmlTransient
    public List<Klaim> getKlaimList() {
        return klaimList;
    }

    public void setKlaimList(List<Klaim> klaimList) {
        this.klaimList = klaimList;
    }

    @XmlTransient
    public List<DetailNasabah> getDetailNasabahList() {
        return detailNasabahList;
    }

    public void setDetailNasabahList(List<DetailNasabah> detailNasabahList) {
        this.detailNasabahList = detailNasabahList;
    }

    @XmlTransient
    public List<Pembayaran> getPembayaranList() {
        return pembayaranList;
    }

    public void setPembayaranList(List<Pembayaran> pembayaranList) {
        this.pembayaranList = pembayaranList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeAsuransi != null ? kodeAsuransi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asuransi)) {
            return false;
        }
        Asuransi other = (Asuransi) object;
        if ((this.kodeAsuransi == null && other.kodeAsuransi != null) || (this.kodeAsuransi != null && !this.kodeAsuransi.equals(other.kodeAsuransi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + kodeAsuransi + "";
    }
    
}
