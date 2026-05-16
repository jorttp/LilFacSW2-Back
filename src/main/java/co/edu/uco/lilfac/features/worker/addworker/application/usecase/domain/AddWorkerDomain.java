package co.edu.uco.lilfac.features.worker.addworker.application.usecase.domain;

import java.util.UUID;

public class AddWorkerDomain {
	
	private UUID id;
	private String name;
	private UUID idType;
	private String idNumber;
	private String phoneNumber;
	private String mail;
	private String address;
	
	
	public AddWorkerDomain(UUID id, String name, UUID idType, String idNumber, String phoneNumber, String mail,
			String address) {
		super();
		generateId();
		setName(name);
		setIdType(idType);
		setIdNumber(idNumber);
		setPhoneNumber(phoneNumber);
		setMail(mail);
		setAddress(address);
		
		}
	private void generateId() {
		this.id = UUID.randomUUID();
	}
	private void regenerateId() {
		generateId();
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setIdType(UUID idType) {
		this.idType = idType;
	}
	private void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private void setMail(String mail) {
		this.mail = mail;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UUID getIdType() {
		return idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public String getAddress() {
		return address;
	}

}
