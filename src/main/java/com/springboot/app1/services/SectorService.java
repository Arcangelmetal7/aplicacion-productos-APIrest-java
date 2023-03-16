/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springboot.app1.services;

import com.springboot.app1.domains.Sector;
import com.springboot.app1.repositories.SectorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pepeGuapo
 */

@Service
@Transactional
public class SectorService {
    
     @Autowired
	private SectorRepository sectorRepository;
     
     public List<Sector> buscarTodos() {
		return sectorRepository.findAll();
	}
    
     public Sector insertarProducto(Sector sector) {

		return sectorRepository.save(sector);
	}

	public Sector buscarPorId(Long id) {

		return sectorRepository.findById(id).orElse(null);

	}

	public void borrarPorId(Long id) {
		sectorRepository.deleteById(id);
	}
}
