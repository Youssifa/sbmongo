/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egis.sbmongo.controller;

import com.egis.sbmongo.models.Produit;
import com.egis.sbmongo.service.ProduitService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DG
 */
@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @RequestMapping(value = "/addProduit/{categorieId}", method = RequestMethod.POST)
    public ResponseEntity<Produit> createProd(@RequestBody Produit p, @PathVariable("categorieId") String categorieId) {
        try {
            Produit prod = produitService.saveProduit(p, categorieId);
            return new ResponseEntity<>(prod, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getProduit/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Produit>> getProduit(@PathVariable("id") String id) {
        try {
            Optional<Produit> categ = produitService.findById(id);
            return new ResponseEntity<>(categ, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllProduit", method = RequestMethod.GET)
    public ResponseEntity<List<Produit>> getAll() {
        try {
            List<Produit> categories = produitService.findAll();
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/deleteProduit/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteCateegorie(@PathVariable("id") String id) {
        try {
            produitService.deleteProduit(id);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
