package com.marcos.desenvolvimento.authapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String company;

	@NotBlank
	private String lastName;

	@NotBlank
	private String firstName;

	private String emailAddress;
	private String jobTitle;
	private String businessPhone;
	private String homePhone;
	private String mobilePhone;
	private String faxNumber;

	@NotBlank
	private String address;

	private String city;
	private String stateProvince;

	@NotBlank
	private String zipPostalCode;

	private String countryRegion;
	private String webPage;
	private String notes;
	private Byte[] attachments;
	private String user;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getZipPostalCode() {
		return zipPostalCode;
	}

	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Byte[] getAttachments() {
		return attachments;
	}

	public void setAttachments(Byte[] attachments) {
		this.attachments = attachments;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerModel that = (CustomerModel) o;
		return Objects.equals(id, that.id) && Objects.equals(company, that.company) && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(businessPhone, that.businessPhone) && Objects.equals(homePhone, that.homePhone) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(faxNumber, that.faxNumber) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(stateProvince, that.stateProvince) && Objects.equals(zipPostalCode, that.zipPostalCode) && Objects.equals(countryRegion, that.countryRegion) && Objects.equals(webPage, that.webPage) && Objects.equals(notes, that.notes) && Arrays.equals(attachments, that.attachments) && Objects.equals(user, that.user) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, company, lastName, firstName, emailAddress, jobTitle, businessPhone, homePhone, mobilePhone, faxNumber, address, city, stateProvince, zipPostalCode, countryRegion, webPage, notes, user, password);
		result = 31 * result + Arrays.hashCode(attachments);
		return result;
	}

	// Getters and setters...

	public CustomerModel(Long id, String company, String lastName, String firstName, String emailAddress,
						 String jobTitle, String businessPhone, String homePhone, String mobilePhone, String faxNumber,
						 String address, String city, String stateProvince, String zipPostalCode, String countryRegion,
						 String webPage, String notes, Byte[] attachments, String user, String password) {

	}

	public CustomerModel() {

	}
}