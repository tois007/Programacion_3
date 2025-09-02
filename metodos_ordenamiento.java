/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camil
 */
import java.util.Scanner;
import java.util.Random;
public class metodos_ordenamiento {
    //Matricez
  public static void sumar_matriz(){
    Scanner sc = new Scanner(System.in);

    System.out.println("----MATRIZ_A----");
		System.out.println("Ingrese el numero de filas de la matriz");
		int nfa = sc.nextInt();
		System.out.println("Ingrese el numero de columnas de la matriz");
		int nca = sc.nextInt();
	
		System.out.println("----MATRIZ_B----");
		System.out.println("Ingrese el numero de filas de la matriz");
		int nfb = sc.nextInt();
		System.out.println("Ingrese el numero de columnas de la matriz");
		int ncb = sc.nextInt();
		
		int [][] matrizC = new int [nfa][nca];
		
		//operacion de suma entre matricez
		if(nfa==nfb && nca==ncb ) {

			//ingresar valores a la matriz A
			System.out.println("Ingresar # matrizA :");
			int [][] matrizA = new int[nfa][nca];
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<nca; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizA [i][j]= sc.nextInt();
				}
			}
			//ingresar valores a la matriz B
			System.out.println("Ingresar # matrizB :");
			int [][] matrizB = new int[nfb][ncb];
			for(int i=0; i<nfb; i++) {
				for(int j=0; j<ncb; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizB [i][j]= sc.nextInt();
				}
			}

			//Imprimir matriz A
			System.out.println("MATRIZ_A");
			for(int i=0; i<nfa; i++) {
				System.out.println();
				for(int j=0; j<nca; j++) {
					System.out.print(matrizA [i][j]+"\t");
				}
			}

			//Imprimir matriz B
			System.out.println();
			System.out.println("MATRIZ_B");
			for(int i=0; i<nfb; i++) {
				System.out.println();
				for(int j=0; j<ncb; j++) {
					System.out.print(matrizB [i][j]+"\t");
				}
			}
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<nca; j++) {
					matrizC[i][j] = matrizA [i][j] + matrizB [i][j];
				}
			}
			
			//imprimir suma
			System.out.println();
			System.out.println("---- Resultado de la suma ----");
			for(int i=0; i<nfa; i++) {
				System.out.println();
				for(int j=0; j<nca; j++) {
					System.out.print(matrizC[i][j]+"\t");
				}
			}
		}else{
			System.out.println();
			System.out.println("no se pueden sumar matrices de diferentes tamaños axb == axb");
		}
  }
	
  public static void producto_matriz(){
		Scanner sc = new Scanner(System.in);
		System.out.println("----MATRIZ_A----");
		System.out.println("Ingrese el numero de filas de la matriz");
		int nfa = sc.nextInt();
		System.out.println("Ingrese el numero de columnas de la matriz");
		int nca = sc.nextInt();

		System.out.println("----MATRIZ_B----");
		System.out.println("Ingrese el numero de filas de la matriz");
		int nfb = sc.nextInt();
		System.out.println("Ingrese el numero de columnas de la matriz");
		int ncb = sc.nextInt();
		
		int[][] resultado = new int[nfa][ncb];
		//operacion de multiplicacion entre matrices
		if(nca == nfb) {
			//ingresar valores a la matriz A
			System.out.println("Ingresar # matrizA :");
			int [][] matrizA = new int[nfa][nca];
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<nca; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizA [i][j]= sc.nextInt();
				}
			}
			//ingresar valores a la matriz B
			System.out.println("Ingresar # matrizB :");
			int [][] matrizB = new int[nfb][ncb];
			for(int i=0; i<nfb; i++) {
				for(int j=0; j<ncb; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizB [i][j]= sc.nextInt();
				}
			}
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<ncb; j++) {
					resultado[i][j]=0;
					for(int k=0; k<nca; k++) {
						resultado[i][j] = resultado[i][j]+(matrizA[i][k]*matrizB[k][j]);
					}
				}
			}
			//imprimir matriz resultado multiplicacion
			System.out.println();
			System.out.println("---- Resultado de la Multiplicacion ----");
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<ncb; j++) {
					System.out.print(resultado[i][j]+"\t");

				}
				System.out.println();
			}
		}else{
			System.out.println("No se puede realizar la multiplicacion, ya que el numero de columnas de A debe ser igual al numero de filas de B");
		}

  }

  public static void inversa_matriz(){
		Scanner sc = new Scanner(System.in);
		//matriz inversa
		System.out.println("ingrese el tamaño de la matriz (filas=columnas)");
		int ni = sc.nextInt();
		System.out.println("");
		double [][] matriz_inv = new double[ni][ni];
		for(int i=0; i<ni; i++) {
			for(int j=0; j<ni; j++) {
				System.out.print("ingrese el valor de la posicion: ("+i+","+j+")");
				matriz_inv [i][j] = sc.nextInt();
			}
		}
		//crear matriz identidad
		double [][] identidad = new double[ni][ni];
		for(int i=0;i<ni;i++){
			identidad[i][i]=1.0;
		}
		//aplicacion de gauus jordan
		for (int i = 0; i < ni; i++) {
			double pivote = matriz_inv[i][i];

			if (pivote == 0) {
				System.out.println("La matriz no tiene inversa (det=0).");
				return;
			}
			// Normalizar fila del pivote
			for (int j = 0; j < ni; j++) {
				matriz_inv[i][j] /= pivote;
				identidad[i][j] /= pivote;
			}

			// Eliminar los demás elementos en la columna
			for (int k = 0; k < ni; k++) {
				if (k != i) {
					double factor = matriz_inv[k][i];
					for (int j = 0; j < ni; j++) {
						matriz_inv[k][j] -= factor * matriz_inv[i][j];
						identidad[k][j] -= factor * identidad[i][j];
					}
				}
			}
		}
		//imprimir matriz inversa
		System.out.println("---- Matriz inversa----");
		for(int i=0;i<ni;i++){
			System.out.println();
			for(int j=0;j<ni;j++){
				System.out.printf("%.3f\t", identidad[i][j]);
			}
		}
  }
  public static void producto_vector(){
        Scanner sc = new Scanner(System.in);
		System.out.println("----MATRIZ----");
		System.out.println("Ingrese el numero de filas de la matriz");
		int nfa = sc.nextInt();
		System.out.println("Ingrese el numero de columnas de la matriz");
		int nca = sc.nextInt();

		System.out.println("----VECTOR----");
		System.out.println("Ingrese el numero de elementos del vector");
		int nfb = sc.nextInt();
		
		int[][] resultado = new int[nfa][1];
		//operacion de multiplicacion entre matrices
		if(nca == nfb) {
			//ingresar valores a la matriz
			System.out.println("Ingresar # matriz :");
			int [][] matrizA = new int[nfa][nca];
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<nca; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizA [i][j]= sc.nextInt();
				}
			}
			//ingresar valores al vector 
			System.out.println("Ingresar # vector :");
			int [][] matrizB = new int[nfb][1];
			for(int i=0; i<nfb; i++) {
				for(int j=0; j<1; j++) {
					System.out.println("ingrese el numero en la posicion: ("+ i + ","+ j +")");
					matrizB [i][j]= sc.nextInt();
				}
			}
			for(int i=0; i<nfa; i++) {
				for(int j=0; j<1; j++) {
					resultado[i][j]=0;
					for(int k=0; k<nca; k++) {
						resultado[i][j] = resultado[i][j]+(matrizA[i][k]*matrizB[k][j]);
					}
				}
			}
			System.out.println("----RESULTADO----");
			for(int i=0;i<nfa;i++){
				for(int j=0;j<1;j++){
					System.out.println(resultado[i][j]);
				}
			}
		}else{
			System.out.println("El numero de columnas de a debe ser igual al numero de filas de b");
		}
		
		
  }
	//Ordenamiento
	public static void Metodo_burbuja(){
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese la cantidad de numeros");
			int num = sc.nextInt();
			int [] numeros = new int[num];
			System.out.println("Numeros desorganizados");
			for(int i=0;i<num;i++){
					numeros[i] = (int)(Math.random()*10+1);

					System.out.println(numeros[i]);
			}
			System.out.println("Numeros Ordenados");
			//ordenar datos metodo burbuja
			int aux=0;
			for(int i=0;i<num-1;i++){
					for(int j=0;j<num-1;j++){
							if(numeros[j]>numeros[j+1]){
									aux = numeros[j];
									numeros[j] = numeros [j+1];
									numeros[j+1] = aux;
							}
					}
			}
			// imprimir array ordenado
			for(int i=0;i<num;i++){
					System.out.println(numeros[i]);
			}
	}
	public static void Metodo_seleccion(){
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			System.out.println("Ingrese el numero de elementos del array");
			int num = sc.nextInt();
			int [] numeros = new int[num];
			System.out.println("Numeros desorganizados");
			for(int i=0;i<num;i++){
					numeros[i] = random.nextInt(num)+1;

					System.out.println(numeros[i]);
			}

			System.out.println("Numeros Ordenados");
			for(int i=0;i<num-1;i++){
					int indice = i;
					for(int j = i+1;j<num;j++){
							if(numeros[j] < numeros[indice]){
									indice = j;
							}
					}
					int aux = numeros[i];
					numeros[i] = numeros[indice];
					numeros[indice] = aux;
			}
			for(int i=0;i<num;i++){
					System.out.println(numeros[i]);
			}
	}
	public static void Metodo_insercion(){
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			System.out.println("Ingrese el numero de elementos del array");
			int num = sc.nextInt();
			int [] numeros = new int[num];
			System.out.println("Numeros desorganizados");
			for(int i=0;i<num;i++){
					numeros[i] = random.nextInt(num)+1;

					System.out.println(numeros[i]);
			}

			System.out.println("Numeros Ordenados");
			for(int i=1;i<num;i++){
					int clave = numeros[i];
					int j= i-1;

					while(j >= 0 && numeros[j] > clave){
							numeros[j + 1] = numeros[j];
							j--;
					}
					numeros[j+1] = clave;
			}
			//impresion de los datos
			for(int i=0;i<num;i++){
					System.out.println(numeros[i]);
			}
	}
	// Método recursivo de MergeSort
	public static void mergeSort(int[] arr, int izquierda, int derecha) {
			if (izquierda < derecha) {
					int medio = (izquierda + derecha) / 2;

					// Ordenar la mitad izquierda
					mergeSort(arr, izquierda, medio);
					// Ordenar la mitad derecha
					mergeSort(arr, medio + 1, derecha);

					// Combinar ambas mitades
					merge(arr, izquierda, medio, derecha);
			}
	}
	// Método para combinar (merge)
	public static void merge(int[] arr, int izquierda, int medio, int derecha) {
			int n1 = medio - izquierda + 1;
			int n2 = derecha - medio;

			int[] L = new int[n1];
			int[] R = new int[n2];

			// Copiamos a arreglos temporales
			for (int i = 0; i < n1; i++)
					L[i] = arr[izquierda + i];
			for (int j = 0; j < n2; j++)
					R[j] = arr[medio + 1 + j];

			int i = 0, j = 0;
			int k = izquierda;

			// Mezclar comparando
			while (i < n1 && j < n2) {
					if (L[i] <= R[j]) {
							arr[k] = L[i];
							i++;
					} else {
							arr[k] = R[j];
							j++;
					}
					k++;
			}

			// Copiar los elementos restantes
			while (i < n1) {
					arr[k] = L[i];
					i++;
					k++;
			}
			while (j < n2) {
					arr[k] = R[j];
					j++;
					k++;
			}
	}
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
	    int opc1;
			
			do{
				System.out.println("Ingrese la opcion a realizar");
				System.out.println("1. Matricez");
				System.out.println("2. Metodos Ordenamiento");
				System.out.println("3. Salir");
				opc1 = sc.nextInt();

				switch(opc1){
					case 1:
						int opc2;
						do{
								System.out.println("\n--- Operaciones con Matrices ---");
								System.out.println();
								System.out.println("1. Suma de matricez.");
								System.out.println("2. Producto entre matricez.");
								System.out.println("3. Inversa de una matriz.");
								System.out.println("4. Producto de una matriz por un vector.");
								System.out.println("5. Salir.");
								opc2 = sc.nextInt();

								switch(opc2){
										case 1:
												System.out.println("\nHas selecionado suma de matricez");
												sumar_matriz();
												break;
										case 2:
												System.out.println("\nHas seleccionado producto entre matricez");
												producto_matriz();
												break;
										case 3:
												System.out.println("\nHas seleccionado inversa de una matriz");
												inversa_matriz();
												break;
										case 4:
												System.out.println("\nHas seleccionado producto de una matriz por un vector");
												producto_vector();
												break;
										case 5:
												System.out.println("");
												System.out.println("¡Hasta Luego!");
												break;
										default:
												System.out.println("");
												System.out.println("¡Opcion no valida! intente nuevamente. ");
								}
						}while(opc2 != 5);
						break;

					case 2:
						int opc3;
						do{
								System.out.println("\n--- Métodos de Ordenamiento ---");
								System.out.println();
								System.out.println("Seleccione el metodo de ordenamiento");
								System.out.println("1. Metodo Burbuja");
								System.out.println("2. Metodo Selección");
								System.out.println("3. Metodo Inserción");
								System.out.println("4. Metodo Merge Sort");
								System.out.println("5. Salir");
								opc3 = sc.nextInt();

								switch(opc3){
										case 1:
												System.out.println("\nHas seleccionado Metodo Burbuja");
												Metodo_burbuja();
												break;
										case 2:
												System.out.println("\nHas seleccionado Metodo Selección");
												Metodo_seleccion();
												break;
										case 3:
												System.out.println("\nHas seleccionado Metodo Inserción");
												Metodo_insercion();
												break;
										case 4:
												System.out.println("\nHas seleccionado Metodo Merge Sort");
												Random random = new Random();
												System.out.println("Ingrese el numero de elementos del array");
												int num = sc.nextInt();
												int [] numeros = new int[num];
												System.out.println("Numeros desorganizados");
												for(int i=0;i<num;i++){
														numeros[i] = random.nextInt(num)+1;
														System.out.println(numeros[i]);
												}
												// Llamamos al mergesort
												mergeSort(numeros, 0, num - 1);
												// Imprimir array ordenado
												System.out.println("\n\nNúmeros ordenados:");
												for (int i = 0; i < num; i++) {
														System.out.print(numeros[i] + " ");
												}
												break;
										case 5:
												System.out.println("");
												System.out.println("¡Hasta luego!");
												break;
										default:
												System.out.println("");
												System.out.println("¡Opción no válida! Intente nuevamente");
								}
						}while(opc3 != 5);
					case 3:
						System.out.println("");
						System.out.println("¡Hasta luego!");
						break;
					default:
						System.out.println("");
						System.out.println("¡Opción no válida! Intente nuevamente");
				}
			}while(opc1 != 3); 
	}
}
