import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        while (true){
            System.out.println("""
                    ***************************************************
                    Sea bienvenido/a al Conversor de Monedas =]
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileño
                    4) Real brasileño => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Salir
                    Elija una opción válida:  
                    **************************************************
                    """);
            try {
                Scanner entrada = new Scanner(System.in);
                int operacion = entrada.nextInt();
                if (operacion == 7){
                    break;
                }else if (operacion < 1 || operacion > 7) {
                    System.out.println("Operación incorrecta intente nuevamente.");
                }else {
                    System.out.println("Ingresa el valor que desea convertir: ");
                    int valor = entrada.nextInt();
                    Conversion.convertirMoneda(operacion,valor);
                }
            }catch (Exception e){
                System.out.println("Ocurrió un error, intente nuevamente");
            }

        }
    }
}
