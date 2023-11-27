import java.util.Scanner;

public class CalculadoraAppRefactorizada {
    public static void main(String[] args) {

        //Creamos y nombramos una nueva instancia de la clase Scanner, le indicamos con Systen.in()
        //que leeremos los datos que se ingresen por consola.
        Scanner scanner = new Scanner(System.in);

        //Usaremos un bucle While para que nuestro programa se ejecute continuamente hasta que el
        //usuario decida salir con la opcion 5.
        while(true) {
            System.out.println("**** Aplicacion Calculadora ****");

            mostrarMenu(); //Llamada de nuestro metodo para mostrar el menu de la calculadora

            //Consultamos con el usuario la opcion a realizar:
            System.out.println("¿Que operacion quiere realizar? ");

            //Manejaremos excepciones y errores utilizando los bloques Try y Catch.
            //Esto nos permite ejecutar cierto bloque de codigo en caso de que nuestro programa
            //nos lance un error.
            try {
                //Utilizando el metodo nextLine() indicamos que el valor de la variable sera igual al valor
                //que el usuario ingrese por consola. Asi mismo parseamos el valor que se proporcione, ya que
                //por defecto los valores ingresados son de tipo String.
                var operacion = Integer.parseInt(scanner.nextLine());

                //Ahora evaluaremos la decision del usuario ante las posibles operaciones de nuestra calculadora
                //Revisamos que el valor proporcionado este dentro del rango de las operaciones
                if (operacion >= 1 && operacion <=4) {

                    operacionNumerica(operacion, scanner); //Llamamos a nuestra funcion

                } else if (operacion == 5) {
                    //Evaluamos si el usuario decide salir de nuestro programa, si es asi utilizamos la sentencia
                    //Break para cortar la ejecucion de nuestro bucle While y cerrar nuestro programa.
                    System.out.println("Hasta pronto...");
                    break; //Corte de ejecucion de nuestro programa
                } else {
                    System.out.println("Opcion erronea -> " + operacion);
                }
                //Imprimimos un salto de linea para antes de que se ejecute nuestro programa de nuevo
                System.out.println();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }

    //Crearemos nuevas funciones para separar las funcionalidades de nuestra calculadora

    private static void mostrarMenu() {
        //Menu de acciones de la calculadora
        //Con saltos de linea "\n":
        //System.out.println("1. Suma \n2. Resta \n3. Multiplicacion \n4. Division \n5. Salir");
        //Con comillas triples """ """:
        System.out.print("""
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                """);
    } //Hacemos las funciones privadas para que no se puedan ejecutar desde otras clases(archivos)


    //Creamos un metodo para evaluar las operaciones que se necesiten realizar
    private static void operacionNumerica(int operacion, Scanner scanner) {
        //Solicitamos los valores
        //Parseamos los valores a numero flotantes (Double) para poder realizar operaciones con
        //numeros flotates.
        System.out.print("Proporciona el primer valor: ");
        var operando1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Proporciona el segundo valor: ");
        var operando2 = Double.parseDouble(scanner.nextLine());

        //Inicializamos nuestra variable resultado
        double resultado;

        //Evaluamos y procesamos los valores segun la operacion seleccionada
        //Sintaxis actual de Switch -> {}
        switch (operacion) {
            case 1 -> { //Suma
                resultado = operando1 + operando2;
                System.out.println("El resultado de la suma es: " + resultado);
            }
            case 2 -> { //Resta
                resultado = operando1 - operando2;
                System.out.println("El resultado de la resta es: " + resultado);
            }
            case 3 -> { //Multiplicacion
                resultado = operando1 * operando2;
                System.out.println("El resultado de la multiplicacion es: " + resultado);
            }
            case 4 -> { //Division
                resultado = operando1 / operando2;
                System.out.println("El resultado de la division es: " + resultado);
            }
            default -> System.out.println("Opcion erronea -> " + operacion);
        }
    }
}
