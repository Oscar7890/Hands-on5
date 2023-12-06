import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Punto> puntosEntrenamiento = new ArrayList<>();
        puntosEntrenamiento.add(new Punto(new double[]{1.0, 2.0}, "Clase A"));
        puntosEntrenamiento.add(new Punto(new double[]{2.0, 3.0}, "Clase A"));
        puntosEntrenamiento.add(new Punto(new double[]{3.0, 4.0}, "Clase B"));
        puntosEntrenamiento.add(new Punto(new double[]{4.0, 5.0}, "Clase B"));
        puntosEntrenamiento.add(new Punto(new double[]{5.0, 6.0}, "Clase C"));
        puntosEntrenamiento.add(new Punto(new double[]{6.0, 7.0}, "Clase C"));
        
        KNN algoritmoKNN = new KNN();
        algoritmoKNN.entrenar(puntosEntrenamiento);
        
        double[] nuevoPunto = {1.5, 2.5};
        int k = 2;
        String clasePredictora = algoritmoKNN.predecir(nuevoPunto, k);
        
        System.out.println("El nuevo punto se encuentra en: " + clasePredictora);
    }
}
