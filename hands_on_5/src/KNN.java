import static java.lang.Math.*;
import java.util.*;

class KNN {
    private List<Punto> puntosEntrenamiento;
    
    public KNN(){
        this.puntosEntrenamiento = new ArrayList<>();
    }
    
    public void entrenar(List<Punto> puntosEntrenamiento){
        this.puntosEntrenamiento = puntosEntrenamiento;
    }
    
    public double distancia(double[] puntoA, double[] puntoB){
        double sum = 0.0;
        for(int i = 0; i < puntoA.length; i++){
            sum += pow(puntoA[i] - puntoB[i], 2);
        }
        
        return sqrt(sum);
    }
    
    public String predecir(double[] nuevoPunto, int k){
        PriorityQueue<Punto> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> distancia(p.getAtributos(), nuevoPunto)));
        
        for(Punto punto : puntosEntrenamiento) { 
            pq.offer(punto);
        }
        
        Map<String, Integer> claseContador = new HashMap<>();
        
        for(int i = 0; i < k; i++){
            Punto puntoActual = pq.poll();
            String claseActual = puntoActual.getClase();
            claseContador.put(claseActual, claseContador.getOrDefault(claseActual, 0) + 1);
        }
        
        String clasePredominante = null;
        int maxFrecuencia = -1;
        
        for(Map.Entry<String, Integer> entry : claseContador.entrySet()){
            if(entry.getValue() > maxFrecuencia){
                maxFrecuencia = entry.getValue();
                clasePredominante = entry.getKey();
            }
        }
        
        return clasePredominante;
    }
    
}
