package com.example.springweek3_2.model;

@Entity
public class Owner {
	@ManyToOne
	Restaurant restaurant;
}