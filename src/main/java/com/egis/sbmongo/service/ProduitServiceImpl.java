/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egis.sbmongo.service;

import com.egis.sbmongo.Repository.CategorieRepository;
import com.egis.sbmongo.Repository.ProduitRepository;
import com.egis.sbmongo.models.Categorie;
import com.egis.sbmongo.models.Produit;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DG
 */
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private CategorieRepository categorieRepository;
    private ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit c, String idCategorie) {
        if (produitRepository.findById(idCategorie).isPresent()) {
            Categorie categ = categorieRepository.findById(idCategorie).get();
            c.setCategorie(categ);
            return produitRepository.save(c);
        }
        return null;
    }

    @Override
    public Optional<Produit> findById(String id) {
        return produitRepository.findById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(String id) {
        Optional<Produit> data = findById(id);
        if (data.isPresent()) {
            produitRepository.deleteById(id);
        }
    }

}
