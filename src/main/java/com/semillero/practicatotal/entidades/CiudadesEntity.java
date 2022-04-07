package com.semillero.practicatotal.entidades;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CIUDADES")
public class CiudadesEntity {
	 @SuppressWarnings("unused")
	 private static final long serialVersionUID = 1L;
	 @Id
	 @SequenceGenerator(name = "idCiudadesGenerator", sequenceName = "SEQ_CIUDADES", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idCiudadesGenerator")
	 @Column(name = "NUM_CODIGO_CIUDAD")
	 private int numCodigoCiudad;
	 @Column(name = "STR_CODIGO_DANE_CIUDAD")
	 private String strCodigoDaneCiudad;
	 @Column(name = "STR_NOMBRE_CIUDAD")
	 private String strNombreCiudad;
	 @JoinColumn(name = "NUM_CODIGO_DEPARTAMENTO", referencedColumnName = "NUM_CODIGO_DEPARTAMENTO")
	 @ManyToOne
	 private DepartamentosEntity departamentosEntity;

	 public CiudadesEntity() {
	 }

	 public CiudadesEntity(int numCodigoCiudad, String strCodigoDaneCiudad, String strNombreCiudad, DepartamentosEntity departamentosEntity) {
	     this.numCodigoCiudad = numCodigoCiudad;
	     this.strCodigoDaneCiudad = strCodigoDaneCiudad;
	     this.strNombreCiudad = strNombreCiudad;
	     this.departamentosEntity = departamentosEntity;
	 }

	 public int getNumCodigoCiudad() {
	     return numCodigoCiudad;
	 }

	 public void setNumCodigoCiudad(int numCodigoCiudad) {
	     this.numCodigoCiudad = numCodigoCiudad;
	 }

	 public String getStrCodigoDaneCiudad() {
	     return strCodigoDaneCiudad;
	 }

	 public void setStrCodigoDaneCiudad(String strCodigoDaneCiudad) {
	     this.strCodigoDaneCiudad = strCodigoDaneCiudad;
	 }

	 public String getStrNombreCiudad() {
	     return strNombreCiudad;
	 }

	 public void setStrNombreCiudad(String strNombreCiudad) {
	     this.strNombreCiudad = strNombreCiudad;
	 }

	 public DepartamentosEntity getDepartamentosEntity() {
	     return departamentosEntity;
	 }

	 public void setDepartamentosEntity(DepartamentosEntity departamentosEntity) {
	     this.departamentosEntity = departamentosEntity;
	 }
}
