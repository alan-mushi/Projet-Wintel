package control ;

import ihm.* ;
import datas.* ;

public interface Global {
	
	// Constantes
	public static final Wintel win = new Wintel() ;
	public static final Annuaire annu = win.getAnnuaire() ;
}
