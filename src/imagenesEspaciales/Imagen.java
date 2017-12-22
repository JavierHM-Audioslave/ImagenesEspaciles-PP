package imagenesEspaciales;

public class Imagen {
	
	private char[] arrDeSec;
	private String secComp;
	
	public Imagen()
	{
		arrDeSec=new char[250];
		secComp=new String();
	}

	public char[] getArrDeSec() {
		return arrDeSec;
	}

	public void setArrDeSec(char[] arrDeSec) {
		this.arrDeSec = arrDeSec;
	}

	public String getSecComp() {
		return secComp;
	}

	public void setSecComp(String secComp) {
		this.secComp = secComp;
	}
}
