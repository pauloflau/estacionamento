package com.jmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.entity.Usuario;
import com.jmp.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new RuntimeException("Usuario nao encontrado")
		);
	}
	
	@Transactional
	public Usuario editarSenha(Long id, String senha) {
		Usuario user = buscarPorId(id);
		user.setPassword(senha);
		usuarioRepository.save(user);
		return user;
	}
	
	@Transactional
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
	
}
