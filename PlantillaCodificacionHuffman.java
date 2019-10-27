import java.util.Map;

import entrada_salida.EscritorBinario;
import entrada_salida.LectorBinario;
import estructuras_datos.ArbolHuffman;

/*********************************************************************************************
 *  Ejecucion: 
 *  	% Comprimir:    java PlantillaCodificacionHuffman -c filePathIn filePathOut
 *      % Decomprimir:  java PlantillaCodificacionHuffman -d filePathIn filePathOut
 *  
 *  Utilidad: Permite la compresion/descompresion usando el algoritmo de Huffman
 *  de un archivo de entrada hacia un archivo de salida. 
 *  
 *
 *********************************************************************************************/

public class PlantillaCodificacionHuffman {

	
	// Constructor
	private PlantillaCodificacionHuffman(){
		
	}
	
	/*
	* Se lee el archivo de entrada (filePathIn, a comprimir) como secuencia de palabras de 8 bits 
	* usando LectorBinario, despues se codifica con el algoritmo de Huffman y el resultado 
	* se escribe usando la clase EscritorBinario hacia el archivo de salida (filePathOut, comprimido).
	*/
    public void comprimir(String filePathIn, String filePathOut) {
		
    	LectorBinario lector = new LectorBinario(filePathIn);
		// Leer archivo de entrada y almacenar en una cadena
		StringBuilder sb = new StringBuilder();
		while (!lector.esVacio()) {
			char b = lector.leerPalabra();
			sb.append(b); 	// OJO! leerPalabra() devuelve una palabra 
							// de 8 bits y el tipo char es de 16 bits
		}
		char[] input = sb.toString().toCharArray();

		///////////////////////TAREA1.1///////////////////////
		// Generar tabla de frecuencias (freq) a partir del array de tipo char input.
		
		//////////////////////////////////////////////////////
		
		// Construir arbol de Huffman.
        // ArbolHuffman arbol = construirArbol(freq); 
		
		// Construir diccionario de busqueda -> Pares (simbolo,codigo).
		// diccionarioCodigos sera una estructura de tipo Map, Hashtable, String[], ...,
		// dependiendo de la implementacion elegida.
        // construirCodigos(diccionarioCodigos,arbol,"");
		
		// Codificar la trama (char[]input) usando el diccionario de codigos.
        // codificar(input,diccionarioCodigos,filePathOut,arbol);
	}
	
   /* 
    * Construir arbol de Huffman a partir de la tabla de frecuencias.
    * (Si se ha usado un arreglo int[] para albergar la tabla de frecuencias).
    */
    private ArbolHuffman construirArbol(int[] freq) {    
    	
        ///////////////////////TAREA1.2///////////////////////
        // Instanciar cola de prioridad (de tipo TreeSet, PriorityQueue o una 
    	// implementacion propia).
    
        //////////////////////////////////////////////////////
    	
    	
    	///////////////////////TAREA1.3///////////////////////
        // Inicializar la cola de prioridad con arboles simples (nodos hoja) para 
    	// cada simbolo de la tabla de frecuencias. Usar la estructura de datos 
    	// de tipo arbol binario que se facilita en los recursos de la practica
    	// (ArbolHuffman.java).
    	
        //////////////////////////////////////////////////////
    	
    	
    	///////////////////////TAREA1.4///////////////////////
    	// Construir el arbol de Huffman final/completo de manera iterativa 
    	// retirando de la cola de prioridad el par de nodos con menor frecuencia.
    	
        //////////////////////////////////////////////////////  
    	
    	// Sustituir este objeto retornando el arbol de Huffman final 
    	// construido en la TAREA1.4
    	return new ArbolHuffman(); 
    }
    
   /* 
    * Construir arbol de Huffman a partir de la tabla de frecuencias.
    * (Si se ha usado una estructura Map para albergar la tabla de frecuencias).
    */
 	private ArbolHuffman construirArbol(Map<Character,Integer> freq) {
 		
 		///////////////////////TAREA1.2///////////////////////
       
        //////////////////////////////////////////////////////
    	
 		
    	///////////////////////TAREA1.3///////////////////////
       
        //////////////////////////////////////////////////////
    	
 		
    	///////////////////////TAREA1.4///////////////////////
    	
        //////////////////////////////////////////////////////  
    	
 		// Sustituir este objeto retornando el arbol de Huffman final 
 		// construido en la TAREA1.4
     	return new ArbolHuffman(); 
 	}
 	
   /* 
    * Construir diccionario de busqueda -> Pares (simbolo,codigo).
    * (Si se usa un arreglo String[] para albergar el diccionario de codigos).
    */
    private void construirCodigos(String [] diccionarioCodigos, ArbolHuffman arbol,String codigoCamino){
    	
    	///////////////////////TAREA1.5///////////////////////
        // Para hacer la codificacion mas rapida, construir un diccionario de busqueda 
        // (String[], Map, Hashtable, ...) que permita obtener la codificacion binaria  
        // de cada uno de los simbolos. Construir dicho diccionario/tabla requerira recorrer 
        // el arbol de Huffman generado en la TAREA1.4. 
        // Para obtener la maxima calificacion en esta tarea la tabla debe construirse 
        // recorriendo al arbol una sola vez.

        //////////////////////////////////////////////////////
    }
    
   /* 
    * Construir diccionario de busqueda -> Pares (simbolo,codigo).
    * (Si se usa una estructura Map para albergar el diccionario de codigos).
    */
    private void construirCodigos(Map<Character,String>  diccionarioCodigos, ArbolHuffman arbol,String codigoCamino){
    	
    	///////////////////////TAREA1.5///////////////////////

        //////////////////////////////////////////////////////
    }
    
   /* 
    * Codificar la trama (char[]input) usando el diccionario de codigos y escribirla en el
    * archivo de salida cuyo path (String filePathOut) se facilita como argumento.
    * (Si se usa un arreglo String[] para albergar el diccionario de codigos).
    */
    private void codificar(char[] input, String [] diccionarioCodigos, String filePathOut, ArbolHuffman arbol){
    	
    	EscritorBinario escritor = new EscritorBinario(filePathOut);
    	
    	// Serializar arbol de Huffman para recuperarlo posteriormente en la descompresion.
        serializarArbol(arbol,escritor);
        
        // Escribir tambien el numero de bytes del mensaje original (sin comprimir).
        escritor.escribirEntero(input.length);
    	
    	///////////////////////TAREA1.6///////////////////////
        // Codificacion usando el diccionario de codigos y escritura en el archivo de salida. 
    	
        //////////////////////////////////////////////////////
        
    	escritor.cerrarFlujo();
    }
    
   /* 
    * Codificar la trama (char[]input) usando el diccionario de codigos y escribirla en el
    * archivo de salida cuyo path (String filePathOut) se facilita como argumento.
    * (Si se usa una estructura Map para albergar el diccionario de codigos).
    */
    private void codificar(char[] input, Map<Character,String> diccionarioCodigos, String filePathOut, ArbolHuffman arbol){
    	
    	EscritorBinario escritor = new EscritorBinario(filePathOut);
    	
    	// Serializar arbol de Huffman para recuperarlo posteriormente en la descompresion.
        serializarArbol(arbol,escritor);
        
        // Escribir tambien el numero de bytes del mensaje original (sin comprimir).
        escritor.escribirEntero(input.length);
    	
    	///////////////////////TAREA1.6///////////////////////
        // Codificacion usando el diccionario de codigos y escritura en el archivo de salida. 
        
        //////////////////////////////////////////////////////
        
    	escritor.cerrarFlujo();
    }
    
   /* 
    * Serializar arbol de Huffman para recuperarlo posteriormente en la descompresion. Se
    * escribe en la parte inicial del archivo de salida.
    */
    private void serializarArbol(ArbolHuffman arbol, EscritorBinario escritor){
    	
    	if (arbol.esHoja()) {
    		escritor.escribirBit(true);
    		escritor.escribirPalabra(arbol.getSimbolo()); //Escribir palabra de 8bits
    		return;
    	}
    	escritor.escribirBit(false);
    	serializarArbol(arbol.getIzquierdo(),escritor);
    	serializarArbol(arbol.getDerecho(),escritor);
    }
    
    /*
    * Se lee el archivo de entrada (filePathIn, a descomprimir) como secuencia de bits 
    * usando LectorBinario, despues se descodifica usando el arbol final de Huffman y el resultado 
    * se escribe con la clase EscritorBinario en el archivo de salida (filePathOut, descomprimido).
    */
    public void descomprimir(String filePathIn, String filePathOut) {
    
    	LectorBinario lector = new LectorBinario(filePathIn);
    	EscritorBinario escritor = new EscritorBinario(filePathOut);

    	ArbolHuffman arbol = leerArbol(lector);

    	// Numero de bytes a escribir
    	int length = lector.leerEntero();

    	///////////////////////TAREA1.7///////////////////////
    	// Decodificar usando el arbol de Huffman.
    	for (int i = 0; i < length; i++) {
    		ArbolHuffman x = arbol;
    		while (!x.esHoja()) {
    			boolean bit = lector.leerBit();
    			if (bit) x = x.getDerecho();
    			else     x = x.getIzquierdo();
    		}
    		escritor.escribirPalabra(x.getSimbolo());
    	}
    	//////////////////////////////////////////////////////

    	escritor.cerrarFlujo();
    }
    
    private ArbolHuffman leerArbol(LectorBinario lector) {
    	
    	boolean esHoja = lector.leerBit();
    	if (esHoja) {
    		char simbolo = lector.leerPalabra();
    		return new ArbolHuffman(simbolo, -1, null, null);
    	}
    	else {
    		return new ArbolHuffman('\0', -1, leerArbol(lector), leerArbol(lector));
    	}
    }

	public static void main(String[] args) {
		
		PlantillaCodificacionHuffman huffman = new PlantillaCodificacionHuffman();
		if(args.length==3){ // Control de argumentos mejorable!!
			if(args[0].equals("-c")){
				huffman.comprimir(args[1],args[2]);
			}else if (args[0].equals("-d")){

			}
		}
	}

}
