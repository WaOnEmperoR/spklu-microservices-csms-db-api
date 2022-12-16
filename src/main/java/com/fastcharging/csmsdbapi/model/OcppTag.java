package com.fastcharging.csmsdbapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ocpp_tag")
@Getter
@Setter
@NoArgsConstructor
public class OcppTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ocppTagPk;

	@Column(name = "id_tag")
	private String idTag;
	@Column(name = "parent_id_tag")
	private String parentIdTag;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@Column(name = "max_active_transaction_count")
	private int maxActiveTransactionCount;
	@Column(name = "note")
	private String note;

}