class Punto {
    private double[] atributos;
    private String clase;
    
    public Punto(double[] atributos, String clase){
        this.atributos = atributos;
        this.clase = clase;
    }

    public double[] getAtributos() {
        return atributos;
    }

    public String getClase() {
        return clase;
    }
    
}
