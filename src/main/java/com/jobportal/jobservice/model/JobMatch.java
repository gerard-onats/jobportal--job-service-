package com.jobportal.jobservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="job_posts", schema = "job")
public class JobMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private Long id;

    @Column(name="job_title",
            nullable = false)
    private String jobTitle;

    @Column(name="job_description",
            nullable = false)
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

    @Column(name="date_added")
    private Date dateAdded;

    /*Warning - Can cause (n + 1) if invoked during a normal search query */
    @OneToMany(orphanRemoval = true, mappedBy = "jobMatch")
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
