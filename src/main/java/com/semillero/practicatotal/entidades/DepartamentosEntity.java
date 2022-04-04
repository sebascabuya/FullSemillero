package com.semillero.practicatotal.entidades;

import javax.persistence.*;

@Entity
@Table(name = "TBL_DEPARTAMENTOS")
public class DepartamentosEntity {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "idDepartamentosGenerator", sequenceName = "SEQ_DEPARTAMENTOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idDepartamentosGenerator")
    @Column(name = "NUM_CODIGO_DEPARTAMENTO")
    private int numCodigoDepartamento;
    @Column(name = "STR_CODIGO_DANE_DEPARTAMENTO")
    private String strCodigoDaneDepartamento;
    @Column(name = "STR_NOMBRE_DEPARTAMENTO")
    private String strNombreDepartamento;

    public DepartamentosEntity() {
    }

    public DepartamentosEntity(int numCodigoDepartamento, String strCodigoDaneDepartamento, String strNombreDepartamento) {
        this.numCodigoDepartamento = numCodigoDepartamento;
        this.strCodigoDaneDepartamento = strCodigoDaneDepartamento;
        this.strNombreDepartamento = strNombreDepartamento;
    }

    public int getNumCodigoDepartamento() {
        return numCodigoDepartamento;
    }

    public void setNumCodigoDepartamento(int numCodigoDepartamento) {
        this.numCodigoDepartamento = numCodigoDepartamento;
    }

    public String getStrCodigoDaneDepartamento() {
        return strCodigoDaneDepartamento;
    }

    public void setStrCodigoDaneDepartamento(String strCodigoDaneDepartamento) {
        this.strCodigoDaneDepartamento = strCodigoDaneDepartamento;
    }

    public String getStrNombreDepartamento() {
        return strNombreDepartamento;
    }

    public void setStrNombreDepartamento(String strNombreDepartamento) {
        this.strNombreDepartamento = strNombreDepartamento;
    }
}
