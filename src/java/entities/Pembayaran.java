/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "PEMBAYARAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pembayaran.findAll", query = "SELECT p FROM Pembayaran p")
    , @NamedQuery(name = "Pembayaran.findByNoPembayaran", query = "SELECT p FROM Pembayaran p WHERE p.noPembayaran = :noPembayaran")
    , @NamedQuery(name = "Pembayaran.findByTglPembayaran", query = "SELECT p FROM Pembayaran p WHERE p.tglPembayaran = :tglPembayaran")
    , @NamedQuery(name = "Pembayaran.findByJmlhBayar", query = "SELECT p FROM Pembayaran p WHERE p.jmlhBayar = :jmlhBayar")
    , @NamedQuery(name = "Pembayaran.findBySaldo", query = "SELECT p FROM Pembayaran p WHERE p.saldo = :saldo")})
public class Pembayaran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NO_PEMBAYARAN")
    private String noPembayaran;
    @Column(name = "TGL_PEMBAYARAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglPembayaran;
    @Column(name = "JMLH_BAYAR")
    private Long jmlhBayar;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @JoinColumn(name = "KODE_ASURANSI", referencedColumnName = "KODE_ASURANSI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asuransi kodeAsuransi;
    @JoinColumn(name = "NO_POLIS", referencedColumnName = "NO_POLIS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Nasabah noPolis;

    public Pembayaran() {
    }

    public Pembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public String getNoPembayaran() {
        return noPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public Date getTglPembayaran() {
        return tglPembayaran;
    }

    public void setTglPembayaran(Date tglPembayaran) {
        this.tglPembayaran = tglPembayaran;
    }

    public Long getJmlhBayar() {
        return jmlhBayar;
    }

    public void setJmlhBayar(Long jmlhBayar) {
        this.jmlhBayar = jmlhBayar;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
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
        hash += (noPembayaran != null ? noPembayaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pembayaran)) {
            return false;
        }
        Pembayaran other = (Pembayaran) object;
        if ((this.noPembayaran == null && other.noPembayaran != null) || (this.noPembayaran != null && !this.noPembayaran.equals(other.noPembayaran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pembayaran[ noPembayaran=" + noPembayaran + " ]";
    }
    
}
