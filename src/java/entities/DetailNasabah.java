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
@Table(name = "DETAIL_NASABAH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailNasabah.findAll", query = "SELECT d FROM DetailNasabah d")
    , @NamedQuery(name = "DetailNasabah.findByTglJoin", query = "SELECT d FROM DetailNasabah d WHERE d.tglJoin = :tglJoin")
    , @NamedQuery(name = "DetailNasabah.findBySaldo", query = "SELECT d FROM DetailNasabah d WHERE d.saldo = :saldo")
    , @NamedQuery(name = "DetailNasabah.findByIdDetail", query = "SELECT d FROM DetailNasabah d WHERE d.idDetail = :idDetail")})
public class DetailNasabah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TGL_JOIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglJoin;
    @Column(name = "SALDO")
    private BigInteger saldo;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETAIL")
    private String idDetail;
    @JoinColumn(name = "KODE_ASURANSI", referencedColumnName = "KODE_ASURANSI")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asuransi kodeAsuransi;
    @JoinColumn(name = "NO_POLIS", referencedColumnName = "NO_POLIS")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Nasabah noPolis;

    public DetailNasabah() {
    }

    public DetailNasabah(String idDetail) {
        this.idDetail = idDetail;
    }

    public Date getTglJoin() {
        return tglJoin;
    }

    public void setTglJoin(Date tglJoin) {
        this.tglJoin = tglJoin;
    }

    public BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(BigInteger saldo) {
        this.saldo = saldo;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
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
        hash += (idDetail != null ? idDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailNasabah)) {
            return false;
        }
        DetailNasabah other = (DetailNasabah) object;
        if ((this.idDetail == null && other.idDetail != null) || (this.idDetail != null && !this.idDetail.equals(other.idDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idDetail + "";
    }
    
}
