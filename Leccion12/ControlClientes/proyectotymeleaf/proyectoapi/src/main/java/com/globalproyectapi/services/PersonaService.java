package com.globalproyectapi.services;

import com.globalproyectapi.domain.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> listarPersona();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
