package com.dakr.DakrSolutionsMapping.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class DakrSolutions {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String name;

	    @OneToOne(mappedBy = "dakrSolutions", cascade = CascadeType.ALL)
	    private OwnEnterprises ownEnterprises;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public OwnEnterprises getOwnEnterprises() {
			return ownEnterprises;
		}

		public void setOwnEnterprises(OwnEnterprises ownEnterprises) {
			this.ownEnterprises = ownEnterprises;
	}
		
}
