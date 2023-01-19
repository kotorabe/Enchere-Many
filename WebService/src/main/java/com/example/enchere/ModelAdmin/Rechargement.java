package com.example.enchere.ModelAdmin;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.example.enchere.Base.Connexion;

public class Rechargement {
	private int idutilisateur;
	private float montantrecharge;
	private LocalDateTime dateheurechargement;
	private int validation;
	public int getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public float getMontantrecharge() {
		return montantrecharge;
	}
	public void setMontantrecharge(float montantrecharge) {
		this.montantrecharge = montantrecharge;
	}
	public void setMontantrecharge(String montant)
	{
		this.montantrecharge = Float.parseFloat(montant);
	}
	
	public LocalDateTime getDateheurechargement() {
		return dateheurechargement;
	}
	public void setDateheurechargement(LocalDateTime dateheurechargement) {
		this.dateheurechargement = dateheurechargement;
	}
	public int getValidation() {
		return validation;
	}
	public void setValidation(int validation) {
		this.validation = validation;
	}
	
	public boolean create(Rechargement recharge) throws Exception
	{
		boolean retour = false;
		Connection connex = null;
		Statement state = null;
		try
		{
			connex = Connexion.setConnect();
			state = connex.createStatement();
			String requete = "insert into rechargement values('"+recharge.getIdutilisateur()+"','"+recharge.getMontantrecharge()+"')";
			state.execute(requete);
			retour = true;
		}
		catch(Exception e)
		{
			throw new Exception("L'insertion du rechargement est impossible");
		}
		finally
		{
			connex.close();
			state.close();
		}
		return retour;
		
	}
	
}
