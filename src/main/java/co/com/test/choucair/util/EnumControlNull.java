package co.com.test.choucair.util;

public enum EnumControlNull {
	
	RECORD_NA ("NA");

		
	
	private String lista;	

	private EnumControlNull(String lista) {
		this.lista = lista;
	}

	public String getLista() {
		return lista;
	}

}
