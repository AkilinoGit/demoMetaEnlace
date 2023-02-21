package com.example.demo.security;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    MedicoRepository medicoRepository; /*Hago la prueba solo en la tabla medicos,
                                         realmente tiene que ser en la union de ambas
                                         Y Crear unclase usuario genérico con la información
                                         de inicio de sesion.
                                        */

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Medico medico = medicoRepository
                .findOneByUsuario(usuario)
                .orElseThrow(()->new UsernameNotFoundException("El usuario: " + usuario + " no existe"));


        return new UserDetailsImpl(medico);


    }
}
