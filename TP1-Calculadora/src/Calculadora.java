import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Calculadora 
{	
	public Calculadora () {}					
						
	public void Calcular()
	{
		String cadena;
		Scanner sc = new Scanner(System.in);		
		cadena= sc.nextLine();		
		sc.close();
		StringTokenizer st= new StringTokenizer (cadena, "+-*", true);		
		
		int vnum= 0;
		int vop= 0;
		Vector <Integer> operandos = new Vector <Integer>(); //numero
		Vector <String> operadores = new Vector <String>();	 //operacion
		
		boolean valor= true;
		
		while (st.hasMoreTokens ())
		{			
			if(valor)
			{   
				operandos.add(Integer.parseInt(st.nextToken()));               	
				valor=false;
				vnum++;
			}
			else                                                        
			{				
				operadores.add(st.nextToken());                                
				valor=true;
				vop++;
			}
		}		
		int contador=0;
		double resultado= 0.0;
		resultado=operandos.elementAt(0);
		
		do 
		{
			if (operadores.elementAt(contador).compareTo("+")==0)				
			{				
				resultado= resultado + operandos.elementAt(contador + 1);				
			}
			else if (operadores.elementAt(contador).compareTo("-")==0)
			{
				resultado= resultado - operandos.elementAt(contador + 1);
			}
			
			else 
			{
				resultado= resultado * operandos.elementAt(contador + 1);
			}			
			contador++;
			vop--;		
		}
		while (vop != 0);
		System.out.println ("El resultado es: "+resultado);			
	}	
}