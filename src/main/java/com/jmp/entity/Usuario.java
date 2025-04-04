package com.jmp.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.jmp.enums.Perfil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false, length = 200)
	private String password;
	
	@Enumerated(EnumType.STRING)//transforma para string
	@Column(nullable = false, length = 25)
	private Perfil perfil;
		
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	private String criadoPor;
	private String modificadoPor;

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + "]";
	}
	
	
	
	
}
