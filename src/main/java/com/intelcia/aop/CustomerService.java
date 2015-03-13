package com.intelcia.aop;

import javax.persistence.Entity;
import javax.persistence.Id;

import static java.lang.Thread.sleep;

@Entity
public class CustomerService {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;


    @Secured(role="admin")
    public String getUrl() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String url;


	public void setName(String name) {
		this.name = name;
	}
 
	public void setUrl(String url) {
		this.url = url;
	}

    @Secured
	public void printName() {
		System.out.println("Customer name : " + this.name);
	}
    @Transactionnal
	public void printURL() {
		System.out.println("Customer website : " + this.url);
	}

    @Transactionnal
	public void printThrowException() {
		throw new IllegalArgumentException();
	}
 
}