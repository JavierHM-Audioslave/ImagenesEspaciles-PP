package imagenesEspaciales;

import java.io.*;
import javax.swing.JOptionPane;

public class LogicaDeCreacion {
	
	//private Imagen imagenAComprimir;
	private Imagen miImagen;
		
	public LogicaDeCreacion()
	{
		File archIn;
		FileReader fr;
		BufferedReader br;
		miImagen=new Imagen();
		try
		{
			archIn=new File(JOptionPane.showInputDialog("Ingrese la ruta completa del archivo de entrada a comprimir"));
			fr=new FileReader(archIn);
			br=new BufferedReader(fr);
			String lineaTotal=new String(br.readLine());
			int pos=0;
			char ultCarLeido=lineaTotal.charAt(0);
			if(!lineaTotal.equalsIgnoreCase("null") && lineaTotal.length()<=250) // Lo de dentro de este if es llenar el objeto con la imagen comprimida a partir de la imagen descomprimida. //
			{
				for(int i=0; i<lineaTotal.length(); i++)
				{
					int j=i+1;
					int cantDeRepetidas=1;
					boolean existeCarRepetido=false;
					while(j<lineaTotal.length() && lineaTotal.charAt(j)==ultCarLeido)
					{
						cantDeRepetidas++;
						j++;
						existeCarRepetido=true;
					}
					if(existeCarRepetido==true)
					{
						if(cantDeRepetidas>4)
						{
							miImagen.setSecComp(miImagen.getSecComp()+" ("+lineaTotal.charAt(i)+cantDeRepetidas+") ");
							i=j-1;
							if(i<lineaTotal.length()-1)
							{
								ultCarLeido=lineaTotal.charAt(i+1);
							}
						}
						else
						{
							for(int z=0; z<cantDeRepetidas; z++)
							{
								miImagen.setSecComp(miImagen.getSecComp()+ultCarLeido);
							}
							i+=cantDeRepetidas-1;
						}
					}
					else
					{
						miImagen.setSecComp(miImagen.getSecComp()+ultCarLeido);
						if(i<lineaTotal.length()-1)
						{
							ultCarLeido=lineaTotal.charAt(i+1);
						}
						else
						{
							break;
						}
						
					}
				}
			}
			
			lineaTotal=new String(br.readLine());
			if(!lineaTotal.equals("null") && lineaTotal.length()<=250) // Lo hecho dentro de este if es la descompresion de la imagen a partir de la imagen comprimida, colocandola en el objeto miImagen. Este objeto esta mal llamado ya que deberia ser llamado imagenDescomprimida. //
			{
				pos=0;
				for(int i=0; i<lineaTotal.length(); i++)
				{
					if( lineaTotal.charAt(i)!='(' )
					{
						miImagen.getArrDeSec()[pos]=lineaTotal.charAt(i);
						pos++;
					}
					else
					{
						for(int j=pos; j<Character.digit(lineaTotal.charAt(i+2),10)+pos; j++)
						{
							miImagen.getArrDeSec()[j]=lineaTotal.charAt(i+1);
						}
						pos+=Character.digit(lineaTotal.charAt(pos+2),10);
						i+=4;
					}
				}
			}
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
		
		
	public void generarSalida()
	{
		try
		{
			File archSal=new File(JOptionPane.showInputDialog("Ingrese el path completo del archivo de salida"));
			FileWriter fw=new FileWriter(archSal);
			PrintWriter pw=new PrintWriter(fw);
			pw.println(miImagen.getSecComp());
			pw.println(miImagen.getArrDeSec());
			try
			{
				fw.close();
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

}
