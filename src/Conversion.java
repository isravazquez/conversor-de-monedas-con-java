public class Conversion {
   static public void convertirMoneda(int operacion, int valor){
       ConsultaMoneda consulta = new ConsultaMoneda();
       TasaDeCambio usd = consulta.buscaMoneda("USD");
       double factor;
       switch (operacion){
           case 1:
               factor = usd.ars();
               System.out.println("El valor de "
                                    + valor
                                    + "[USD] corresponde al valor final de =>"
                                    + valor * factor + "[ARS]");
               break;
           case 2:
               factor = usd.ars();
               System.out.println("El valor de "
                       + valor
                       + " [ARS] corresponde al valor final de => "
                       + valor / factor + " [USD]");
               break;
           case 3:
               factor = usd.brl();
               System.out.println("El valor de "
                       + valor
                       + " [USD] corresponde al valor final de => "
                       + valor * factor  + " [BRL]");
               break;
           case 4:
               factor = usd.brl();
               System.out.println("El valor de "
                       + valor
                       + " [BRL] corresponde al valor final de => "
                       + valor / factor  + " [USD]");
               break;
           case 5:
               factor = usd.cop();
               System.out.println("El valor de "
                       + valor
                       + " [USD] corresponde al valor final de => "
                       + valor * factor  + " [COP]");
               break;
           case 6:
               factor = usd.cop();
               System.out.println("El valor de "
                       + valor
                       + " [COP] corresponde al valor final de => "
                       + valor / factor  + " [USD]");
               break;
       }

    }
}
