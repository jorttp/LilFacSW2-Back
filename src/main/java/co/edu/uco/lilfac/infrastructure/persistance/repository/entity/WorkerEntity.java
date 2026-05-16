package co.edu.uco.lilfac.infrastructure.persistance.repository.entity;

import java.util.UUID;

public class WorkerEntity {
	private UUID id;
	private String name;
	private UUID idType;
	private String idNumber;
	private String phoneNumber;
	private String mail;
	private String address;
	
	
	public WorkerEntity(UUID id, String name, UUID idType, String idNumber, String phoneNumber, String mail,
			String address) {
		super();
		setId(id);
		setName(name);
		setIdType(idType);
		setIdNumber(idNumber);
		setPhoneNumber(phoneNumber);
		setMail(mail);
		setAddress(address);
		
		}
	private void setId(UUID id) {
		this.id = id;
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
