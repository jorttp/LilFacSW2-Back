package co.edu.uco.lilfac.infrastructure.persistance.repository.sql.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Trabajador")
public class WorkerJPAEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name="nombre")
	private String name;
	
	@JoinColumn(name="tipoId")
	private UUID idType;
	
	@Column(name="numeroId")
	private String idNumber;
	
	@Column(name="telefono")
	private String phoneNumber;
	
	@Column(name="correo")
	private String mail;
	
	@Column(name="direccion")
	private String address;
	
	

	public WorkerJPAEntity(UUID id, String name, UUID idType, String idNumber, String phoneNumber, String mail,
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
