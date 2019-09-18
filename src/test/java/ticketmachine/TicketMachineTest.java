package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}
        
        @Test
        // S3 : on n’imprime pas le ticket si le montant inséréest insuffisant
        public void insertMoneyInsufficient() {
            machine.insertMoney(10);
            assertEquals("Le montant inseré est suffisant pour imprimer le ticket",false,machine.printTicket());
        }
        @Test
        // S4
        public void insertMoneySufficient(){
            machine.insertMoney(10);
            assertEquals("Le montant inseré est insuffisant pour imprimer le ticket", true, machine.printTicket());
        
        }
        @Test
        //S5 :
        public void balanceIsCorrectlyUpdated(){
            machine.insertMoney(50);
            machine.printTicket();
            assertEquals("La balance n'a pas été décrementée corretement", machine.getBalance(), 0);
            
        }
        @Test
        //S6 :
        public void totalIsCorrectlyUpdated(){
            machine.insertMoney(50);
            assertEquals("Le montant collecté a été correment mit à jour trop tôt", machine.getTotal(),0);
            machine.printTicket();
            assertEquals("Le montant collecté n'a pas été correment mit à jour", machine.getTotal(),50);
            
        }
        @Test
        //S7 :
        public void ticketIsCorrectlyRefunded(){
            machine.insertMoney(30);  
            assertEquals("La monnaie n'a pas été rendue",machine.refund(),30);
        }
        @Test
        //S8 :
        public void refundResetBalance(){
            machine.insertMoney(60);
            machine.refund();
            assertEquals("La monnaie n'a pas été rendue",machine.getBalance(),0);
        }
            @Test
        //S9 :
        public void insertMoneyIsNegative(){
           try{
               machine.insertMoney(-1);
           }
           catch(IllegalArgumentException e ){
               throw e;
        }
           
        }
        @Test
        //S10 
        public void priceIsNegative(){
            try{
               TicketMachine MachineErr = new TicketMachine(-1);
            }catch(IllegalArgumentException e){
                    throw e;
            }
        }
}
