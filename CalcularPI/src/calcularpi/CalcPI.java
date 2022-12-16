package calcularpi;


import java.math.BigDecimal;
import java.math.MathContext;

public class CalcPI {

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
            //meter en el método piFunction                
            pi = pi.add(piK);
            if (piK.compareTo(limit) < 0) {
                stop = true;
            }
        }
        System.out.println(pi.round(mc));
    }

    public static BigDecimal piFunction(int k, MathContext mc) {
        //Hice click derecho, refactor, introduce, method y puse el nombre de piFunction y le di a finish.
        int k8 = 8 * k;
        BigDecimal val1 = new BigDecimal(4);
        val1 = val1.divide(new BigDecimal(k8 + 1), mc);
        BigDecimal val2 = new BigDecimal(-2);
        val2 = val2.divide(new BigDecimal(k8 + 4), mc);
        BigDecimal val3 = new BigDecimal(-1);
        val3 = val3.divide(new BigDecimal(k8 + 5), mc);
        BigDecimal val4 = new BigDecimal(-1);
        val4 = val4.divide(new BigDecimal(k8 + 6), mc);
        BigDecimal val = val1;
        val = val.add(val2);
        val = val.add(val3);
        val = val.add(val4);
        BigDecimal multiplier = new BigDecimal(16);
        multiplier = multiplier.pow(k);
        BigDecimal one = new BigDecimal(1);
        multiplier = one.divide(multiplier, mc);
        val = val.multiply(multiplier);
        BigDecimal piK = val;
        return piK;
    }
     
}
