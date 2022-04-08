package com.semillero.practicatotal.entidades;

import javax.persistence.*;

@Entity
@Table(name = "TBL_OFICINAS")

public class OficinasEntity {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "idOficinasGenerator", sequenceName = "SEQ_OFICINAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idOficinasGenerator")
    @Column(name = "NUM_ID_OFICINA")
    private int numIdOficina;
    @Column(name = "STR_CODIGO_OFICINA")
    private String strCodigoOficina;
    @Column(name = "STR_NOMBRE_OFICINA")
    private String strNombreOficina;
    @Column(name = "STR_DIRECCION_OFICINA")
    private String strDireccionOficina;
    @JoinColumn(name = "NUM_CODIGO_CIUDAD", referencedColumnName = "NUM_CODIGO_CIUDAD")
    @ManyToOne
    private CiudadesEntity ciudadesEntity;

    public OficinasEntity() {
    }

    public OficinasEntity(int numIdOficina, String strCodigoOficina, String strNombreOficina, String strDireccionOficina, CiudadesEntity ciudadesEntity) {
        this.numIdOficina = numIdOficina;
        this.strCodigoOficina = strCodigoOficina;
        this.strNombreOficina = strNombreOficina;
        this.strDireccionOficina = strDireccionOficina;
        this.ciudadesEntity = ciudadesEntity;
    }

    public int getNumIdOficina() {
        return numIdOficina;
    }

    public void setNumIdOficina(int numIdOficina) {
        this.numIdOficina = numIdOficina;
    }

    public String getStrCodigoOficina() {
        return strCodigoOficina;
    }

    public void setStrCodigoOficina(String strCodigoOficina) {
        this.strCodigoOficina = strCodigoOficina;
    }

    public String getStrNombreOficina() {
        return strNombreOficina;
    }

    public void setStrNombreOficina(String strNombreOficina) {
        this.strNombreOficina = strNombreOficina;
    }

    public String getStrDireccionOficina() {
        return strDireccionOficina;
    }

    public void setStrDireccionOficina(String strDireccionOficina) {
        this.strDireccionOficina = strDireccionOficina;
    }

    public CiudadesEntity getCiudadesEntity() {
        return ciudadesEntity;
    }

    public void setCiudadesEntity(CiudadesEntity ciudadesEntity) {
        this.ciudadesEntity = ciudadesEntity;
    }
}
