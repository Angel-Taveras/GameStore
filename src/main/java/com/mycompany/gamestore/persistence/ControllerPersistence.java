
package com.mycompany.gamestore.persistence;

import com.mycompany.gamestore.logica.Console;
import com.mycompany.gamestore.logica.Costumer;

public class ControllerPersistence {
    CostumerJpaController costumerJpa = new CostumerJpaController();
    ConsoleJpaController consoleJpa = new ConsoleJpaController();

    public void save(Costumer costumer, Console console) {
        
        costumerJpa.create(costumer);
        consoleJpa.create(console);
        
    }
}
