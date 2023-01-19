package com.example.enchere.ControllerAdmin;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelAdmin.Categorie;

@Controller
@CrossOrigin
@RequestMapping("/CategorieAdmin")
public class CategorieAdminController {
	
	@GetMapping
	public String selectAll(Model ModelAdmin) throws Exception
	{
		ArrayList<Categorie> liste = new Categorie().selectall();
		ModelAdmin.addAttribute("categ", liste);
		return "";
	}
	
	@PostMapping
	public boolean insertion(@RequestBody Categorie categorie, HttpServletRequest request) throws Exception
	{
		categorie.setCategorie(request.getParameter("categorie"));
		String duree = request.getParameter("duree");
		categorie.setDureeEnchereCategorie(Double.parseDouble(duree));
		boolean cat = new Categorie().insert(categorie);
		return cat;
	}
}
