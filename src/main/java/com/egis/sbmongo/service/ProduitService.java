/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egis.sbmongo.service;

import com.egis.sbmongo.models.Produit;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DG
 */
public interface ProduitService {
     public Produit saveProduit(Produit c,String idCategorie);
    public Optional<Produit> findById(String id);
    public List<Produit> findAll();
    public void deleteProduit(String id);
}
