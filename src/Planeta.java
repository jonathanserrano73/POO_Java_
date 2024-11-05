import java.security.spec.RSAOtherPrimeInfo;

public class Planeta {
    String nombre=null;
    int cantidadSatelites=0;
    double masa=0.0;
    double volumen=0.0;
    int diametro=0;
    int distanciaDelSol=0;
    TipoPlaneta tipoPlaneta;
    boolean observableAVista=false;

    public enum TipoPlaneta{
        GASEOSO,
        TERRESTRE,
        ENANO
    }
    Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distanciaDelSol, TipoPlaneta tipoPlaneta, boolean observableAVista){
        this.nombre=nombre;
        this.cantidadSatelites=cantidadSatelites;
        this.masa=masa;
        this.volumen=volumen;
        this.diametro=diametro;
        this.distanciaDelSol=distanciaDelSol;
        this.tipoPlaneta=tipoPlaneta;
        this.observableAVista=observableAVista;
    }
    void imprimir(){
        System.out.println("Nombre="+nombre);
        System.out.println("Cantidad de satelites="+cantidadSatelites);
        System.out.println("Masa="+masa);
        System.out.println("Volumen="+volumen);
        System.out.println("Diametro="+diametro);
        System.out.println("Distancia media al Sol="+distanciaDelSol);
        System.out.println("Tipo de planeta="+tipoPlaneta);
        System.out.println("Observable a simple vista="+observableAVista);
        System.out.println();
    }
    public double calcularDensidad(){
        if (volumen==0){
            return 0;
        }
        return masa/volumen;
    }
    public boolean esPlanetaExterior(){
        double distanciaKm=distanciaDelSol*1000000;
        double distanciaMinima=2.1*149597870;
        double distanciaMaxima=3.4*149597870;

        return distanciaKm>= distanciaMinima && distanciaKm<= distanciaMaxima;
    }
    public void mostrarDensidadYExterno(){
        double densidad = calcularDensidad();
        System.out.println("Densidad="+densidad+" kg/km³");
        System.out.println("Es Planeta exterior"+esPlanetaExterior());
    }
    public static void main(String[]args){
        Planeta p1= new Planeta("Tierra", 1, 5.9736e12, 1.08921e12, 12742, 150000000, TipoPlaneta.TERRESTRE, true);
        Planeta p2= new Planeta("Jupiter", 1, 1.899e27, 1.4313e15, 139820, 750000000,TipoPlaneta.GASEOSO, true);
        p1.imprimir();
        p1.mostrarDensidadYExterno();
        p2.imprimir();
        p2.mostrarDensidadYExterno();
    }
}
