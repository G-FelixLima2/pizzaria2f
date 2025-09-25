package com.itb.inf2fm.pizzaria2f.model.services;

import com.itb.inf2fm.pizzaria2f.model.entity.Categoria;
import com.itb.inf2fm.pizzaria2f.model.entity.Usuario;
import com.itb.inf2fm.pizzaria2f.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar Usuario
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //Salvar Usuario
    public Usuario save(Usuario usuario) {
        usuario.setCodStatus(true);
        return usuarioRepository.save(usuario);
    }

    //Listar usuario por ID
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuarionão encontrado com id" + id));
    }

    //Atualizar Usuario
    public Usuario update(Long id, Categoria categoria) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuarioExistente.getNome());
        usuarioExistente.setCpf(usuarioExistente.getCpf());
        usuarioExistente.setEmail(usuarioExistente.getEmail());
        usuarioExistente.setTipoUsuario(usuarioExistente.getTipoUsuario());
        usuarioExistente.setSenha(usuarioExistente.getSenha());
        usuarioExistente.setSexo(usuarioExistente.getSexo());
        usuarioExistente.setLogradouro(usuarioExistente.getLogradouro());
        usuarioExistente.setCep(usuarioExistente.getCep());
        usuarioExistente.setBairro(usuarioExistente.getBairro());
        usuarioExistente.setCidade(usuarioExistente.getCidade());
        usuarioExistente.setUf(usuarioExistente.getUf());
        return usuarioRepository.save(usuarioExistente);
    }

    //Excluir usuario
}
