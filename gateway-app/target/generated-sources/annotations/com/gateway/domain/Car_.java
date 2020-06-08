package com.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Car.class)
public abstract class Car_ {

	public static volatile SingularAttribute<Car, String> price;
	public static volatile SingularAttribute<Car, String> model;
	public static volatile SingularAttribute<Car, Long> id;
	public static volatile SingularAttribute<Car, String> make;

	public static final String PRICE = "price";
	public static final String MODEL = "model";
	public static final String ID = "id";
	public static final String MAKE = "make";

}

