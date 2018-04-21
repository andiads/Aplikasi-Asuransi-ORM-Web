/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dbayu
 */
@Entity
@Table(name = "NASABAH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nasabah.findAll", query = "SELECT n FROM Nasabah n")
    , @NamedQuery(name = "Nasabah.findByNik", query = "SELECT n FROM Nasabah n WHERE n.nik = :nik")
    , @NamedQuery(name = "Nasabah.findByNmNasabah", query = "SELECT n FROM Nasabah n WHERE n.nmNasabah = :nmNasabah")
    , @NamedQuery(name = "Nasabah.findByTglLahir", query = "SELECT n FROM Nasabah n WHERE n.tglLahir = :tglLahir")
    , @NamedQuery(name = "Nasabah.findByPekerjaan", query = "SELECT n FROM Nasabah n WHERE n.pekerjaan = :pekerjaan")
    , @NamedQuery(name = "Nasabah.findByAlamat", query = "SELECT n FROM Nasabah n WHERE n.alamat = :alamat")
    , @NamedQuery(name = "Nasabah.findByStatus", query = "SELECT n FROM Nasabah n WHERE n.status = :status")
    , @NamedQuery(name = "Nasabah.findByPengBulan", query = "SELECT n FROM Nasabah n WHERE n.pengBulan = :pengBulan")
    , @NamedQuery(name = "Nasabah.findByNoPolis", query = "SELECT n FROM Nasabah n WHERE n.noPolis = :noPolis")})
public class Nasabah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "NIK")
    private String nik;
    @Column(name = "NM_NASABAH")
    private String nmNasabah;
    @Column(name = "TGL_LAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglLahir;
    @Column(name = "PEKERJAAN")
    private String pekerjaan;
    @Column(name = "ALAMAT")
    private String alamat;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PENG_BULAN")
    private String pengBulan;
    @Id
    @Basic(optional = false)
    @Column(name = "NO_POLIS")
    private String noPolis;
    @OneToMany(mappedBy = "noPolis", fetch = FetchType.LAZY)
    private List<Klaim> klaimList;
    @JoinColumn(name = "ID_ADMIN", referencedColumnName = "ID_ADMIN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin idAdmin;
    @OneToMany(mappedBy = "noPolis", fetch = FetchType.LAZY)
    private List<Pembayaran> pembayaranList;

    public Nasabah() {
    }

    public Nasabah(String noPolis) {
        this.noPolis = noPolis;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNmNasabah() {
        return nmNasabah;
    }

    public void setNmNasabah(String nmNasabah) {
        this.nmNasabah = nmNasabah;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPengBulan() {
        return pengBulan;
    }

    public void setPengBulan(String pengBulan) {
        this.pengBulan = pengBulan;
    }

    public String getNoPolis() {
        return noPolis;
    }

    public void setNoPolis(String noPolis) {
        this.noPolis = noPolis;
    }

    @XmlTransient
    public List<Klaim> getKlaimList() {
        return klaimList;
    }

    public void setKlaimList(List<Klaim> klaimList) {
        this.klaimList = klaimList;
    }

    public Admin getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Admin idAdmin) {
        this.idAdmin = idAdmin;
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
        hash += (noPolis != null ? noPolis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nasabah)) {
            return false;
        }
        Nasabah other = (Nasabah) object;
        if ((this.noPolis == null && other.noPolis != null) || (this.noPolis != null && !this.noPolis.equals(other.noPolis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + noPolis + "";
    }
    
}
