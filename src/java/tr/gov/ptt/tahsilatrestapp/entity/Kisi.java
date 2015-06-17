/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatrestapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_KISI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kisi.findAll", query = "SELECT k FROM Kisi k"),
    @NamedQuery(name = "Kisi.findById", query = "SELECT k FROM Kisi k WHERE k.id = :id"),
    @NamedQuery(name = "Kisi.findByAd", query = "SELECT k FROM Kisi k WHERE k.ad = :ad"),
    @NamedQuery(name = "Kisi.findBySoyad", query = "SELECT k FROM Kisi k WHERE k.soyad = :soyad"),
    @NamedQuery(name = "Kisi.findByKullaniciAd", query = "SELECT k FROM Kisi k WHERE k.kullaniciAd = :kullaniciAd"),
    @NamedQuery(name = "Kisi.findBySifre", query = "SELECT k FROM Kisi k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kisi.findByRol", query = "SELECT k FROM Kisi k WHERE k.rol = :rol"),
    @NamedQuery(name = "Kisi.findByTema", query = "SELECT k FROM Kisi k WHERE k.tema = :tema"),
    @NamedQuery(name = "Kisi.findBySirano", query = "SELECT k FROM Kisi k WHERE k.sirano = :sirano")})
public class Kisi implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 30)
    @Column(name = "AD")
    private String ad;
    @Size(max = 30)
    @Column(name = "SOYAD")
    private String soyad;
    @Size(max = 20)
    @Column(name = "KULLANICI_AD")
    private String kullaniciAd;
    @Size(max = 20)
    @Column(name = "SIFRE")
    private String sifre;
    @Size(max = 1)
    @Column(name = "ROL")
    private String rol;
    @Size(max = 50)
    @Column(name = "TEMA")
    private String tema;
    @Column(name = "SIRANO")
    private BigInteger sirano;
    @JoinTable(name = "THS_KISI_MENU", joinColumns = {
        @JoinColumn(name = "KISI_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Menu> menuCollection;
    @OneToMany(mappedBy = "kisiId")
    private Collection<Tahsilat> tahsilatCollection;

    public Kisi() {
    }

    public Kisi(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public BigInteger getSirano() {
        return sirano;
    }

    public void setSirano(BigInteger sirano) {
        this.sirano = sirano;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @XmlTransient
    public Collection<Tahsilat> getTahsilatCollection() {
        return tahsilatCollection;
    }

    public void setTahsilatCollection(Collection<Tahsilat> tahsilatCollection) {
        this.tahsilatCollection = tahsilatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.tahsilatrestapp.entity.Kisi[ id=" + id + " ]";
    }
    
}
