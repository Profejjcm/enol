package calcularpi;


import java.math.BigDecimal;
import java.math.MathContext;

public class CalcPI extends ClasePadre {

     public static void main(String[] args) {
         final int NUM_DIG = 10; 
         //cree una constante llamada NUM_DIG que reemplazo todos los número 10 que hubiera en el código 
        MathContext mc = new MathContext(NUM_DIG);         
        compute(NUM_DIG, mc);
    }

    public static void compute(final int NUM_DIG, MathContext mc) {
        //Rodee todo lo que estaba entre los dos comentarios de compute, click derecho, refactor, introduce, method, le di el nombre compute
        BigDecimal pi = new BigDecimal(0);
        BigDecimal limit = new BigDecimal(1).movePointLeft(NUM_DIG);
        boolean stop = false;
        for (int k = 0; !stop; k++) {
            BigDecimal piK = piFunction(k, mc);              
            pi = pi.add(piK);
            if (piK.compareTo(limit) < 0) {
                stop = true;
            }
        }
        System.out.println(pi.round(mc));
    }

     
}
