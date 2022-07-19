package com.egis.sbmongo.controller;


import com.egis.sbmongo.models.Categorie;
import com.egis.sbmongo.service.CategorieService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author DG
 */
@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categoryService;

    @RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
    public ResponseEntity<Categorie> createCateg(@RequestBody Categorie c) {
        try {
            Categorie categ = categoryService.saveCategorie(c);
                    return  new ResponseEntity<>(categ, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getCategorie/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Categorie>> getCateegorie(@PathVariable("id") String id ) { 
        try {
            Optional<Categorie> categ = categoryService.findById(id);
                    return  new ResponseEntity<>(categ, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
@RequestMapping(value = "/getAllCategorie", method = RequestMethod.GET)
    public ResponseEntity<List<Categorie>> getAll() {
        try {
            List<Categorie> categories = categoryService.findAll();
            if(categories.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @RequestMapping(value = "/deleteCategorie/{id}", method = RequestMethod.GET)
     public ResponseEntity<Object> deleteCateegorie(@PathVariable("id") String id ) { 
        try {
        categoryService.deleteCategorie(id);
           return  new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
