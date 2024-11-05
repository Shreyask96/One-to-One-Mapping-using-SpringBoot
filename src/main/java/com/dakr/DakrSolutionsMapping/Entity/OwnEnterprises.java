package com.dakr.DakrSolutionsMapping.Entity;

import jakarta.persistence.*;

@Entity
public class OwnEnterprises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int employeeCount;

    @Column(nullable = false)
    private String clientTargets;

    @Column(nullable = false)
    private String projectQuality;

    @Column(nullable = false)
    private String clientSatisfaction;

    @OneToOne
    @JoinColumn(name = "dakr_solutions_id", referencedColumnName = "id")
    private DakrSolutions dakrSolutions;

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

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getClientTargets() {
		return clientTargets;
	}

	public void setClientTargets(String clientTargets) {
		this.clientTargets = clientTargets;
	}

	public String getProjectQuality() {
		return projectQuality;
	}

	public void setProjectQuality(String projectQuality) {
		this.projectQuality = projectQuality;
	}

	public String getClientSatisfaction() {
		return clientSatisfaction;
	}

	public void setClientSatisfaction(String clientSatisfaction) {
		this.clientSatisfaction = clientSatisfaction;
	}

	public DakrSolutions getDakrSolutions() {
		return dakrSolutions;
	}

	public void setDakrSolutions(DakrSolutions dakrSolutions) {
		this.dakrSolutions = dakrSolutions;
	}
    
    
}
