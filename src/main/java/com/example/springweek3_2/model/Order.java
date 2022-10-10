package com.example.springweek3_2.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {
    @OneToMany
    private List<Food> foods;

		@OneToOne
		private Coupon coupon;
}