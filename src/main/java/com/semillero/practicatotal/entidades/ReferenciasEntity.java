package com.semillero.practicatotal.entidades;

import javax.persistence.*;

@Entity
@Table(name = "TBL_REFERENCIAS")
public class ReferenciasEntity {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "idReferenciasGenerator", sequenceName = "SEQ_REFERENCIAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idReferenciasGenerator")
    @Column(name = "NUM_ID_REFERENCIA")
    private int numIdReferencia;
    @Column(name = "STR_DOMINIO")
    private String strDominio;
    @Column(name = "STR_RANGO_VALOR")
    private String strRangoValor;
    @Column(name = "STR_DESCRIPCION")
    private String strDescripcion;
    @Column(name = "STR_VALOR_PARAMETRO")
    private String strValorParametro;
    @Column(name = "STR_ESTADO")
    private String strEstado;
    @Column(name = "STR_TIPO_PRODUCTO_FK", insertable = false, updatable = false)
    private String strTipoProductoFk;
    @Column(name = "STR_TIPO_CLAVE_FK", insertable = false, updatable = false)
    private String strTipoClaveFk;
    @Column(name = "STR_TIPO_CUENTA_FK", insertable = false, updatable = false)
    private String strTipoCuentaFk;
    @Column(name = "STR_TIPO_ID_FK", insertable = false, updatable = false)
    private String strTipoIdFk;
    @Column(name = "STR_ES_ACTIVO_FK", insertable = false, updatable = false)
    private String strEsActivoFk;

    public ReferenciasEntity(){
        
    }

    public ReferenciasEntity(int numIdReferencia, String strDominio, String strRangoValor, String strDescripcion,
                             String strValorParametro, String strEstado, String strTipoProductoFk,
                             String strTipoClaveFk, String strTipoCuentaFk, String strTipoIdFk, String strEsActivoFk) {
        this.numIdReferencia = numIdReferencia;
        this.strDominio = strDominio;
        this.strRangoValor = strRangoValor;
        this.strDescripcion = strDescripcion;
        this.strValorParametro = strValorParametro;
        this.strEstado = strEstado;
        this.strTipoProductoFk = strTipoProductoFk;
        this.strTipoClaveFk = strTipoClaveFk;
        this.strTipoCuentaFk = strTipoCuentaFk;
        this.strTipoIdFk = strTipoIdFk;
        this.strEsActivoFk = strEsActivoFk;
    }

    public int getNumIdReferencia() {
        return numIdReferencia;
    }

    public void setNumIdReferencia(int numIdReferencia) {
        this.numIdReferencia = numIdReferencia;
    }

    public String getStrDominio() {
        return strDominio;
    }

    public void setStrDominio(String strDominio) {
        this.strDominio = strDominio;
    }

    public String getStrRangoValor() {
        return strRangoValor;
    }

    public void setStrRangoValor(String strRangoValor) {
        this.strRangoValor = strRangoValor;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrValorParametro() {
        return strValorParametro;
    }

    public void setStrValorParametro(String strValorParametro) {
        this.strValorParametro = strValorParametro;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public String getStrTipoProductoFk() {
        return strTipoProductoFk;
    }

    public void setStrTipoProductoFk(String strTipoProductoFk) {
        this.strTipoProductoFk = strTipoProductoFk;
    }

    public String getStrTipoClaveFk() {
        return strTipoClaveFk;
    }

    public void setStrTipoClaveFk(String strTipoClaveFk) {
        this.strTipoClaveFk = strTipoClaveFk;
    }

    public String getStrTipoCuentaFk() {
        return strTipoCuentaFk;
    }

    public void setStrTipoCuentaFk(String strTipoCuentaFk) {
        this.strTipoCuentaFk = strTipoCuentaFk;
    }

    public String getStrTipoIdFk() {
        return strTipoIdFk;
    }

    public void setStrTipoIdFk(String strTipoIdFk) {
        this.strTipoIdFk = strTipoIdFk;
    }

    public String getStrEsActivoFk() {
        return strEsActivoFk;
    }

    public void setStrEsActivoFk(String strEsActivoFk) {
        this.strEsActivoFk = strEsActivoFk;
    }
}
