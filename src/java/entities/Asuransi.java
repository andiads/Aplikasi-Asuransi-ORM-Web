/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    , @NamedQuery(name = "Asuransi.findByJenisAsuransi", query = "SELECT a FROM Asuransi a WHERE a.jenisAsuransi = :jenisAsuransi")})
public class Asuransi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODE_ASURANSI")
    private String kodeAsuransi;
    @Column(name = "JENIS_ASURANSI")
    private String jenisAsuransi;
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
        return " "+ kodeAsuransi +" " ;
    }
    
}
