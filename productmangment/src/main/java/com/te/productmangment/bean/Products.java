package com.te.productmangment.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "products")
public class Products implements Serializable{
@Id
private Integer pid;
private String pname;
private Date mgDate;
private Date exDate;
private Integer price;
private Integer quantity;
}
