import java.util.*;
abstract class Soldado {
    protected String nombre;
    protected int nivelVida;
    protected int ataque;
    protected int defensa;
    protected int fila;
    protected int columna;
    protected String reino;

    public Soldado(String nombre, int nivelVida, int ataque, int defensa, String reino) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.reino = reino;
    }
public String getNombre() { return nombre; }
    public int getNivelVida() { return nivelVida; }
    public void setNivelVida(int nivelVida) { this.nivelVida = nivelVida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }
    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }
    public String getReino() { return reino; }

    
    public abstract String representar();

   
    public void aplicarBonus() {
        this.nivelVida += 1;
    }
}

class Espadachin extends Soldado {
    protected double longitudEspada;

    public Espadachin(String nombre, int nivelVida, int ataque, int defensa, String reino, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, reino);
        this.longitudEspada = longitudEspada;
    }

    public double getLongitudEspada() { return longitudEspada; }
    public void setLongitudEspada(double longitudEspada) { this.longitudEspada = longitudEspada; }

    public String representar() {
        return "E";
    }
}
class Arquero extends Soldado {
    private int flechasDisponibles;

    public Arquero(String nombre, int nivelVida, int ataque, int defensa, String reino, int flechasDisponibles) {
        super(nombre, nivelVida, ataque, defensa, reino);
        this.flechasDisponibles = flechasDisponibles;
    }
    public int getFlechasDisponibles() { return flechasDisponibles; }
    public void setFlechasDisponibles(int flechasDisponibles) { this.flechasDisponibles = flechasDisponibles; }

    public String representar() {
        return "A";
    }
   
}
class Caballero extends Soldado {
    private String arma; // "Espada" o "Lanza"
    private boolean montado;

    public Caballero(String nombre, int nivelVida, int ataque, int defensa, String reino, String arma, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, reino);
        this.arma = arma;
        this.montado = montado;
    }
    public String getArma() { return arma; }
    public void setArma(String arma) { this.arma = arma; }

    public boolean isMontado() { return montado; }
    public void setMontado(boolean montado) { this.montado = montado; }

    public String representar() {
        return "C";
    }

}

class Lancero extends Soldado {
    protected double longitudLanza;

    public Lancero(String nombre, int nivelVida, int ataque, int defensa, String reino, double longitudLanza) {
        super(nombre, nivelVida, ataque, defensa, reino);
        this.longitudLanza = longitudLanza;
    }

    public double getLongitudLanza() { return longitudLanza; }
    public void setLongitudLanza(double longitudLanza) { this.longitudLanza = longitudLanza; }

    public String representar() {
        return "L";
    }
}
interface UnidadEspecial {
    void habilidadEspecial();
    int getNivelEvolucion();
    void evolucionar();
}
class EspadachinReal extends Espadachin implements UnidadEspecial {
    private int nivelEvolucion;
    private int cuchillosDisponibles;
    private double tamanoCuchillos;

    public EspadachinReal(String nombre, int nivelVida, int ataque, int defensa, String reino, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, reino, longitudEspada);
        this.nivelEvolucion = 1;
        this.cuchillosDisponibles = 5;
        this.tamanoCuchillos = 1.0;
    }

    public void habilidadEspecial() {
        if (cuchillosDisponibles > 0) {
            cuchillosDisponibles--;
            System.out.println(nombre + " lanza un cuchillo. Cuchillos restantes: " + cuchillosDisponibles);
        } else {
            System.out.println(nombre + " no tiene cuchillos para lanzar.");
        }
    }

    public int getNivelEvolucion() { return nivelEvolucion; }

    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;
            cuchillosDisponibles += 2;
            tamanoCuchillos += 0.5;
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + ". Cuchillos disponibles: " + cuchillosDisponibles);
        } else {
            System.out.println(nombre + " ya ha alcanzado el máximo nivel de evolución.");
        }
    }

    public String representar() {
        return "ER";
    }
}

class CaballeroFranco extends Caballero implements UnidadEspecial {
    private int nivelEvolucion;
    private int lanzasDisponibles;
    private double tamanoLanzas;

    public CaballeroFranco(String nombre, int nivelVida, int ataque, int defensa, String reino, String arma, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, reino, arma, montado);
        this.nivelEvolucion = 1;
        this.lanzasDisponibles = 3;
        this.tamanoLanzas = 1.5;
    }

    public void habilidadEspecial() {
        if (lanzasDisponibles > 0) {
            lanzasDisponibles--;
            System.out.println(nombre + " lanza una lanza. Lanzas restantes: " + lanzasDisponibles);
        } else {
            System.out.println(nombre + " no tiene lanzas para lanzar.");
        }
    }

    public int getNivelEvolucion() { return nivelEvolucion; }

    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;
            lanzasDisponibles += 2;
            tamanoLanzas += 0.5;
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + ". Lanzas disponibles: " + lanzasDisponibles);
        } else {
            System.out.println(nombre + " ya ha alcanzado el máximo nivel de evolución.");
        }
    }

    public String representar() {
        return "CF";
    }
}
class EspadachinTeutonico extends Espadachin implements UnidadEspecial {
    private int nivelEvolucion;
    private int jabalinasDisponibles;
    private double tamanoJabalinas;

    public EspadachinTeutonico(String nombre, int nivelVida, int ataque, int defensa, String reino, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, reino, longitudEspada);
        this.nivelEvolucion = 1;
        this.jabalinasDisponibles = 4;
        this.tamanoJabalinas = 1.2;
    }

    public void habilidadEspecial() {
        if (jabalinasDisponibles > 0) {
            jabalinasDisponibles--;
            System.out.println(nombre + " lanza una jabalina. Jabalinas restantes: " + jabalinasDisponibles);
        } else {
            System.out.println(nombre + " no tiene jabalinas para lanzar.");
        }
    }

    public void modoTortuga() {
        System.out.println(nombre + " activa modo tortuga. Defensa aumentada en 2.");
        this.defensa += 2;
    }

    public int getNivelEvolucion() { return nivelEvolucion; }

    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;
            jabalinasDisponibles += 2;
            tamanoJabalinas += 0.5;
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + ". Jabalinas disponibles: " + jabalinasDisponibles);
        } else {
            System.out.println(nombre + " ya ha alcanzado el máximo nivel de evolución.");
        }
    }

    public String representar() {
        return "ET";
    }
}
class EspadachinConquistador extends Espadachin implements UnidadEspecial {
    private int nivelEvolucion;
    private int hachasDisponibles;
    private double tamanoHachas;

    public EspadachinConquistador(String nombre, int nivelVida, int ataque, int defensa, String reino, double longitudEspada) {
        super(nombre, nivelVida, ataque, defensa, reino, longitudEspada);
        this.nivelEvolucion = 1;
        this.hachasDisponibles = 3;
        this.tamanoHachas = 1.0;
    }

    public void habilidadEspecial() {
        if (hachasDisponibles > 0) {
            hachasDisponibles--;
            System.out.println(nombre + " lanza un hacha. Hachas restantes: " + hachasDisponibles);
        } else {
            System.out.println(nombre + " no tiene hachas para lanzar.");
        }
    }

    public int getNivelEvolucion() { return nivelEvolucion; }

    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;
            hachasDisponibles += 2;
            tamanoHachas += 0.5;
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + ". Hachas disponibles: " + hachasDisponibles);
        } else {
            System.out.println(nombre + " ya ha alcanzado el máximo nivel de evolución.");
        }
    }

    public String representar() {
        return "EC";
    }
}

class CaballeroMoro extends Caballero implements UnidadEspecial {
    private int nivelEvolucion;
    private int flechasDisponibles;
    private double tamanoFlechas;

    public CaballeroMoro(String nombre, int nivelVida, int ataque, int defensa, String reino, String arma, boolean montado) {
        super(nombre, nivelVida, ataque, defensa, reino, arma, montado);
        this.nivelEvolucion = 1;
        this.flechasDisponibles = 6;
        this.tamanoFlechas = 1.3;
    }

    public void habilidadEspecial() {
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(nombre + " lanza una flecha. Flechas restantes: " + flechasDisponibles);
        } else {
            System.out.println(nombre + " no tiene flechas para lanzar.");
        }
    }

    public int getNivelEvolucion() { return nivelEvolucion; }

    public void evolucionar() {
        if (nivelEvolucion < 4) {
            nivelEvolucion++;
            flechasDisponibles += 3;
            tamanoFlechas += 0.4;
            System.out.println(nombre + " ha evolucionado a nivel " + nivelEvolucion + ". Flechas disponibles: " + flechasDisponibles);
        } else {
            System.out.println(nombre + " ya ha alcanzado el máximo nivel de evolución.");
        }
    }

    public String representar() {
        return "CM";
    }
class Ejercito {
    private String reino;
    private List<Soldado> soldados;

    public Ejercito(String reino) {
        this.reino = reino;
        this.soldados = new ArrayList<>();
    }

    public String getReino() { return reino; }
    public List<Soldado> getSoldados() { return soldados; }

    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public void eliminarSoldado(Soldado soldado) {
        soldados.remove(soldado);
    }

    public boolean estaVacio() {
        return soldados.isEmpty();
    }

    public void mostrarEjercito() {
        System.out.println("Ejército: " + reino);
        System.out.println("Cantidad total de soldados: " + soldados.size());

        int espadachines = 0, arqueros = 0, caballeros = 0, lanceros = 0;
        int espadachinReal = 0, caballeroFranco = 0, espadachinTeutonico = 0, espadachinConquistador = 0, caballeroMoro = 0;

        for (Soldado s : soldados) {
            if (s instanceof EspadachinReal) espadachinReal++;
            else if (s instanceof CaballeroFranco) caballeroFranco++;
            else if (s instanceof EspadachinTeutonico) espadachinTeutonico++;
            else if (s instanceof EspadachinConquistador) espadachinConquistador++;
            else if (s instanceof CaballeroMoro) caballeroMoro++;
            else if (s instanceof Espadachin) espadachines++;
            else if (s instanceof Arquero) arqueros++;
            else if (s instanceof Caballero) caballeros++;
            else if (s instanceof Lancero) lanceros++;
        }

        System.out.println("Espadachines: " + espadachines);
        System.out.println("Arqueros: " + arqueros);
        System.out.println("Caballeros: " + caballeros);
        System.out.println("Lanceros: " + lanceros);
        if (espadachinReal > 0) System.out.println("Espadachín Real: " + espadachinReal);
        if (caballeroFranco > 0) System.out.println("Caballero Franco: " + caballeroFranco);
        if (espadachinTeutonico > 0) System.out.println("Espadachín Teutónico: " + espadachinTeutonico);
        if (espadachinConquistador > 0) System.out.println("Espadachín Conquistador: " + espadachinConquistador);
        if (caballeroMoro > 0) System.out.println("Caballero Moro: " + caballeroMoro);
        System.out.println();
    }
}