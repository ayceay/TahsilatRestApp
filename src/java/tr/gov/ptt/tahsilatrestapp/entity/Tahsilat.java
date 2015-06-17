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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_TAHSILAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tahsilat.findAll", query = "SELECT t FROM Tahsilat t"),
    @NamedQuery(name = "Tahsilat.findById", query = "SELECT t FROM Tahsilat t WHERE t.id = :id"),
    @NamedQuery(name = "Tahsilat.findByIslemTrh", query = "SELECT t FROM Tahsilat t WHERE t.islemTrh = :islemTrh"),
    @NamedQuery(name = "Tahsilat.findByKisiSiraNo", query = "SELECT t FROM Tahsilat t WHERE t.kisiSiraNo = :kisiSiraNo"),
    @NamedQuery(name = "Tahsilat.findByTutar", query = "SELECT t FROM Tahsilat t WHERE t.tutar = :tutar")})
public class Tahsilat implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ISLEM_TRH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date islemTrh;
    @Column(name = "KISI_SIRA_NO")
    private BigInteger kisiSiraNo;
    @Column(name = "TUTAR")
    private BigDecimal tutar;
    @JoinColumn(name = "KURUM_ID", referencedColumnName = "ID")
    @ManyToOne
    private Kurum kurumId;
    @JoinColumn(name = "KISI_ID", referencedColumnName = "ID")
    @ManyToOne
    private Kisi kisiId;
    @OneToMany(mappedBy = "tahsilatId")
    private Collection<TahsilatDetay> tahsilatDetayCollection;
    @OneToMany(mappedBy = "tahsilatId")
    private Collection<TahsilatMuhasebe> tahsilatMuhasebeCollection;

    public Tahsilat() {
    }

    public Tahsilat(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getIslemTrh() {
        return islemTrh;
    }

    public void setIslemTrh(Date islemTrh) {
        this.islemTrh = islemTrh;
    }

    public BigInteger getKisiSiraNo() {
        return kisiSiraNo;
    }

    public void setKisiSiraNo(BigInteger kisiSiraNo) {
        this.kisiSiraNo = kisiSiraNo;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    public void setTutar(BigDecimal tutar) {
        this.tutar = tutar;
    }

    public Kurum getKurumId() {
        return kurumId;
    }

    public void setKurumId(Kurum kurumId) {
        this.kurumId = kurumId;
    }

    public Kisi getKisiId() {
        return kisiId;
    }

    public void setKisiId(Kisi kisiId) {
        this.kisiId = kisiId;
    }

    @XmlTransient
    public Collection<TahsilatDetay> getTahsilatDetayCollection() {
        return tahsilatDetayCollection;
    }

    public void setTahsilatDetayCollection(Collection<TahsilatDetay> tahsilatDetayCollection) {
        this.tahsilatDetayCollection = tahsilatDetayCollection;
    }

    @XmlTransient
    public Collection<TahsilatMuhasebe> getTahsilatMuhasebeCollection() {
        return tahsilatMuhasebeCollection;
    }

    public void setTahsilatMuhasebeCollection(Collection<TahsilatMuhasebe> tahsilatMuhasebeCollection) {
        this.tahsilatMuhasebeCollection = tahsilatMuhasebeCollection;
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
        if (!(object instanceof Tahsilat)) {
            return false;
        }
        Tahsilat other = (Tahsilat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.tahsilatrestapp.entity.Tahsilat[ id=" + id + " ]";
    }
    
}
