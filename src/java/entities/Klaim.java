/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbayu
 */
@Entity
@Table(name = "KLAIM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klaim.findAll", query = "SELECT k FROM Klaim k")
    , @NamedQuery(name = "Klaim.findByIdklaim", query = "SELECT k FROM Klaim k WHERE k.idklaim = :idklaim")
    , @NamedQuery(name = "Klaim.findByTglKlaim", query = "SELECT k FROM Klaim k WHERE k.tglKlaim = :tglKlaim")})
public class Klaim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDKLAIM")
    private String idklaim;
    @Column(name = "TGL_KLAIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglKlaim;
    @JoinColumn(name = "KODE_ASURANSI", referencedColumnName = "KODE_ASURANSI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asuransi kodeAsuransi;
    @JoinColumn(name = "NO_POLIS", referencedColumnName = "NO_POLIS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nasabah noPolis;

    public Klaim() {
    }

    public Klaim(String idklaim) {
        this.idklaim = idklaim;
    }

    public String getIdklaim() {
        return idklaim;
    }

    public void setIdklaim(String idklaim) {
        this.idklaim = idklaim;
    }

    public Date getTglKlaim() {
        return tglKlaim;
    }

    public void setTglKlaim(Date tglKlaim) {
        this.tglKlaim = tglKlaim;
    }

    public Asuransi getKodeAsuransi() {
        return kodeAsuransi;
    }

    public void setKodeAsuransi(Asuransi kodeAsuransi) {
        this.kodeAsuransi = kodeAsuransi;
    }

    public Nasabah getNoPolis() {
        return noPolis;
    }

    public void setNoPolis(Nasabah noPolis) {
        this.noPolis = noPolis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idklaim != null ? idklaim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klaim)) {
            return false;
        }
        Klaim other = (Klaim) object;
        if ((this.idklaim == null && other.idklaim != null) || (this.idklaim != null && !this.idklaim.equals(other.idklaim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Klaim[ idklaim=" + idklaim + " ]";
    }
    
}
