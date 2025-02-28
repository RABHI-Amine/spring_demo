package country.app;

import country.model.Continent;
import country.model.Country;
import country.service.IServiceWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Scanner;

@SuppressWarnings("all")
@EnableTransactionManagement
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/*.xml");
		IServiceWorker serviceWorker = applicationContext.getBean(IServiceWorker.class);
		while (true) {
			System.out.println("\n");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("\n1- Pour l'ajout d'un nouveau pays");
			System.out.println("2- Pour lister les informations d'un pays");
			System.out.println("3- Pour supprimer un pays");
			System.out.println("4- Pour modifier des informations d'un pays");
			System.out.println("5- Pour lister tous les pays d'un continent");
			System.out.println("0- pour sortir de l'application\n");
			System.out.print("Entrer un nombre de 0 à 5:");
			Scanner inputFromConsole = new Scanner(System.in);
			String code = inputFromConsole.next();
			String codePays ;
			switch (code){
				case "0":
					//sortir de l'application en affichant le code 1
					System.exit(0);
					break;

				case "1":
					//ajout d'un nouveau pays
					System.out.print("Entrer le pays à ajouter sous le format suivant (code,nom,devise,greetings,nom du continent): ");
					String country = inputFromConsole.next();
					serviceWorker.addCountry(country);
					break;

				case "2":
					//affichage des infos d'un pays
					System.out.print("Entrer le code pays: ");
					codePays = inputFromConsole.next();
					serviceWorker.dealWithCountryByCode(codePays);
					break;

				case "3":
					//supprimer un pays par son code
					System.out.print("Entrer le code pays à supprimer: ");
					codePays = inputFromConsole.next();
					serviceWorker.deleteCountryByCode(codePays);
					break;

				case "4":
					//mise à jour d'un pays
					System.out.print("Entrer le code du pays à modifier: ");
					codePays = inputFromConsole.next();
					serviceWorker.updateCountry(codePays,inputFromConsole);
					break;

				case "5":
					//recuperation des pays d'un continent
					System.out.print("Entrer le code du continent pour afficher les pays: ");
					String codeContinent = inputFromConsole.next();
					serviceWorker.getContinentCountries(codeContinent);
					break;

			}


		}

	}
	
}
