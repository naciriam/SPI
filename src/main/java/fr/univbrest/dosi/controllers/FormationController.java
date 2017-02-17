package fr.univbrest.dosi.controllers;

import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.exceptions.EntitéeInvalideException;
import fr.univbrest.dosi.model.FormationComplete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import java.util.Collection;

@Api(value = "formation", description = "Description de la ressource formation.")
@RestController
@RequestMapping("/formation")
public class FormationController {

    private final FormationBusiness formationBusiness;

    @Autowired
    public FormationController(FormationBusiness formationBusiness) {
        this.formationBusiness = formationBusiness;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<FormationComplete> récupérerToutesLesFormations() {
        return this.formationBusiness.récupérerFormations();
    }
    
//    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    FormationComplete ajouterUneFormation(@RequestBody FormationComplete formationAEnregistrer) {
//    	System.err.println(">>>>>>>No Annee: "+formationAEnregistrer.getNombreDAnnee());
//    	System.err.println(">>>>>>>Nom: "+formationAEnregistrer.getNomFormation());
    	validerFormationAEnregistrer(formationAEnregistrer);
    	
        return this.formationBusiness.ajouterFormation(formationAEnregistrer);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    FormationComplete mettreAJourUneFormation(@RequestBody FormationComplete formationAMettreAJour) {

    	validerFormationAMettreAJour(formationAMettreAJour.getCodeFormation(), formationAMettreAJour);
    	
        return this.formationBusiness.ajouterFormation(formationAMettreAJour);
    }
    
    private void validerFormationAMettreAJour(String codeFormation, FormationComplete formationAMettreAJour) {
		if(codeFormation.equals(formationAMettreAJour.getCodeFormation())) {
			validerFormationAEnregistrer(formationAMettreAJour);
		} else {
			throw new EntitéeInvalideException();
		}
	}

	private void validerFormationAEnregistrer(FormationComplete formationAEnregistrer) {
		if(Strings.isNullOrEmpty(formationAEnregistrer.getCodeFormation())) {
			throw new EntitéeInvalideException();
		}
		
	}

	@ApiOperation(value = "", notes = "Permet de récupérer une formation à partir de son code formation.", response = FormationComplete.class, tags={  })
    @RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}")
    FormationComplete récupérerUneFormation(@PathVariable final String codeFormation) {
    	
        return this.formationBusiness.récupérerFormationParLeCode(codeFormation);
    }
    
    @ApiOperation(value = "", notes = "Permet de supprimer une formation à partir de son code formation.", response = FormationComplete.class, tags={  })
    @RequestMapping(value = "/delete/{codeFormation}")
    void suprimerUneFormation(@PathVariable final String codeFormation) {
    	
        this.formationBusiness.supprimerFormation(codeFormation);
    }
   
	
	
}
