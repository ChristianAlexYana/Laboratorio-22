
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

class Mapa {
    private static final int TAMANIO = 10;
    private Soldado[][] tablero;
    private String territorio;
    private Ejercito ejercito1;
    private Ejercito ejercito2;
    private Random random;

    private final String[] TERRITORIOS = {
        "Bosque",
        "Campo Abierto",
        "Montaña",
        "Desierto",
        "Playa"
    };

    public Mapa(Ejercito ejercito1, Ejercito ejercito2) {
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
        this.tablero = new Soldado[TAMANIO][TAMANIO];
        this.random = new Random();
        
        this.territorio = TERRITORIOS[random.nextInt(TERRITORIOS.length)];
        
        posicionarSoldados(ejercito1);
        posicionarSoldados(ejercito2);
        
        aplicarBonusTerritorio();
    }

    public String getTerritorio() { return territorio; }

    private void posicionarSoldados(Ejercito ejercito) {
        
        int maxRegularSoldados = 5;
        int regularSoldados = random.nextInt(maxRegularSoldados + 1); 
        int totalSoldados = 1 + regularSoldados;
        for (int i = 0; i < totalSoldados; i++) {
            Soldado soldado;
            if (i == 0) {
            
                soldado = crearUnidadEspecial(ejercito.getReino(), i + 1);
            } else {
                
                soldado = generarSoldado(ejercito.getReino(), i + 1);
            }
           
            while (true) {
                int fila = random.nextInt(TAMANIO);
                int columna = random.nextInt(TAMANIO);
                if (tablero[fila][columna] == null) {
                    soldado.setFila(fila + 1); 
                    soldado.setColumna(columna + 1);
                    tablero[fila][columna] = soldado;
                    ejercito.agregarSoldado(soldado);
                    break;
                }
            }
        }
    }

    private Soldado generarSoldado(String reino, int contador) {
        
        int tipo = random.nextInt(4); 
        String nombre = "";
        Soldado soldado = null;

        switch (tipo) {
            case 0:
                nombre = "E" + contador;
                soldado = new Espadachin(nombre, generarNivelVida("Espadachin"), 10, 8, reino, 1.2);
                break;
            case 1: 
                nombre = "A" + contador;
                soldado = new Arquero(nombre, generarNivelVida("Arquero"), 7, 3, reino, random.nextInt(5) + 1);
                break;
            case 2:
                nombre = "C" + contador;
                soldado = new Caballero(nombre, generarNivelVida("Caballero"), 13, 7, reino, "Espada", false);
                break;
            case 3: 
                nombre = "L" + contador;
                soldado = new Lancero(nombre, generarNivelVida("Lancero"), 5, 10, reino, 1.5);
                break;
            default:
              
                nombre = "E" + contador;
                soldado = new Espadachin(nombre, generarNivelVida("Espadachin"), 10, 8, reino, 1.2);
        }

        return soldado;
    }

    private int generarNivelVida(String tipo) {
        switch (tipo) {
            case "Espadachin":
                return random.nextInt(3) + 8; 
            case "Arquero":
                return random.nextInt(3) + 3; 
            case "Caballero":
                return random.nextInt(3) + 10; 
            case "Lancero":
                return random.nextInt(4) + 5;
            default:
                return 5;
        }
    }

    private Soldado crearUnidadEspecial(String reino, int contador) {
        String nombre = "";
        Soldado soldado = null;
        switch (reino) {
            case "Inglaterra":
                nombre = "ER" + contador;
                soldado = new EspadachinReal(nombre, 12, 10, 8, reino, 1.5);
                break;
            case "Francia":
                nombre = "CF" + contador;
                soldado = new CaballeroFranco(nombre, 15, 13, 7, reino, "Espada", false);
                break;
            case "Sacro Imperio Romano Germánico":
                nombre = "ET" + contador;
                soldado = new EspadachinTeutonico(nombre, 13, 10, 8, reino, 1.4);
                break;
            case "Castilla-Aragón":
                nombre = "EC" + contador;
                soldado = new EspadachinConquistador(nombre, 14, 10, 8, reino, 1.3);
                break;
            case "Moros":
                nombre = "CM" + contador;
                soldado = new CaballeroMoro(nombre, 13, 13, 7, reino, "Lanza", true);
                break;
            default:
                // Por defecto, generar un espadachín
                nombre = "E" + contador;
                soldado = new Espadachin(nombre, generarNivelVida("Espadachin"), 10, 8, reino, 1.2);
        }
        return soldado;
    }

    private void aplicarBonusTerritorio() {
        for (Ejercito ejercito : Arrays.asList(ejercito1, ejercito2)) {
           
            boolean bonus = false;
            switch (ejercito.getReino()) {
                case "Inglaterra":
                    if (territorio.equals("Bosque")) bonus = true;
                    break;
                case "Francia":
                    if (territorio.equals("Campo Abierto")) bonus = true;
                    break;
                case "Castilla-Aragón":
                    if (territorio.equals("Montaña")) bonus = true;
                    break;
                case "Moros":
                    if (territorio.equals("Desierto")) bonus = true;
                    break;
                case "Sacro Imperio Romano Germánico":
                    if (territorio.equals("Bosque") || territorio.equals("Playa") || territorio.equals("Campo Abierto"))
                        bonus = true;
                    break;
            }
            if (bonus) {
                for (Soldado s : ejercito.getSoldados()) {
                    s.aplicarBonus();
                }
                System.out.println("El reino " + ejercito.getReino() + " recibe bono por territorio favorable");
            }
        }
        System.out.println();
    }

    public void dibujarMapa() {
      
        System.out.println("Territorio: " + territorio); 
        System.out.print("      ");
        for (int i = 1; i <= TAMANIO; i++) {
            System.out.printf("%8d", i);
        }
        System.out.println();
        
        for (int i = 0; i < TAMANIO; i++) {
            System.out.printf("%4d  ", i + 1);
            for (int j = 0; j < TAMANIO; j++) {
                if (tablero[i][j] == null) {
                    System.out.print(" |___ ");
                } else {
                    String representacion = tablero[i][j].representar();
                    String sigJugador = obtenerSiglasJugador(tablero[i][j]);
                    String tipoSoldado = obtenerTipoSoldado(tablero[i][j]);
                    String celda = sigJugador + ":" + representacion + tipoSoldado;
                    String cellRepresentation = String.format("%-5s", celda);
                    System.out.print(" |" + cellRepresentation + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println();
    }

    private String obtenerSiglasJugador(Soldado soldado) {
        if (ejercito1.getSoldados().contains(soldado)) return "1";
        if (ejercito2.getSoldados().contains(soldado)) return "2";
        return "0"; // Por si acaso
    }
 
    private String obtenerTipoSoldado(Soldado soldado) {
        String nombre = soldado.getNombre();
        String numero = nombre.substring(nombre.length() - 1); 
        
        if (numero.length() == 1) {
            numero += " ";
        }
        return numero;
    }

    public boolean moverSoldado(int fila, int columna, String direccion, Ejercito ejercito1, Ejercito ejercito2) {
        // Validar posiciones
        if (fila < 1 || fila > TAMANIO || columna < 1 || columna > TAMANIO) {
            System.out.println("Coordenadas fuera del mapa.");
            return false;
        }
        Soldado soldado = tablero[fila - 1][columna - 1];
        if (soldado == null) {
            System.out.println("No hay ningún soldado en la posición especificada.");
            return false;
        }

        int nuevaFila = fila;
        int nuevaColumna = columna;
        switch (direccion.toLowerCase()) {
            case "arriba":
                nuevaFila -= 1;
                break;
            case "abajo":
                nuevaFila += 1;
                break;
            case "izquierda":
                nuevaColumna -= 1;
                break;
            case "derecha":
                nuevaColumna += 1;
                break;
            default:
                System.out.println("Dirección inválida.");
                return false;
        }

        if (nuevaFila < 1 || nuevaFila > TAMANIO || nuevaColumna < 1 || nuevaColumna > TAMANIO) {
            System.out.println("Movimiento fuera del mapa.");
            return false;
        }

        Soldado objetivo = tablero[nuevaFila - 1][nuevaColumna - 1];
        if (objetivo == null) {
            
            tablero[nuevaFila - 1][nuevaColumna - 1] = soldado;
            tablero[fila - 1][columna - 1] = null;
            soldado.setFila(nuevaFila);
            soldado.setColumna(nuevaColumna);
            System.out.println(soldado.getNombre() + " se ha movido " + direccion + " a (" + nuevaFila + ", " + nuevaColumna + ").");
        } else {
            
            if (!soldado.getReino().equals(objetivo.getReino())) {
               
                System.out.println("¡Batalla entre " + soldado.getNombre() + " (" + soldado.getReino() + ") y " + objetivo.getNombre() + " (" + objetivo.getReino() + ")!");
                realizarBatalla(soldado, objetivo, fila - 1, columna - 1, nuevaFila - 1, nuevaColumna - 1, ejercito1, ejercito2);
            } else {
                System.out.println("No se puede mover a una posición ocupada por un soldado del mismo ejército.");
                return false;
            }
        }
        return true;
    }

    private void realizarBatalla(Soldado atacante, Soldado defensor, int filaDefensor, int columnaDefensor, int filaNuevo, int columnaNuevo, Ejercito ejercito1, Ejercito ejercito2) {
        int sumaVida = atacante.getNivelVida() + defensor.getNivelVida();
        double probAtacante = ((double) atacante.getNivelVida() / sumaVida) * 100;
        double probDefensor = ((double) defensor.getNivelVida() / sumaVida) * 100;

        double aleatorio = random.nextDouble() * 100;

        Soldado ganador;
        Soldado perdedor;

        if (aleatorio <= probAtacante) {
            ganador = atacante;
            perdedor = defensor;
        } else {
            ganador = defensor;
            perdedor = atacante;
        }

        tablero[filaNuevo][columnaNuevo] = ganador;
        ganador.setFila(filaNuevo + 1);
        ganador.setColumna(columnaNuevo + 1);
        tablero[filaDefensor][columnaDefensor] = null;

        if (ejercito1.getSoldados().contains(perdedor)) {
            ejercito1.eliminarSoldado(perdedor);
        } else {
            ejercito2.eliminarSoldado(perdedor);
        }

        System.out.println("Resultado de la batalla: " + ganador.getNombre() + " ha vencido a " + perdedor.getNombre() + ".");
        System.out.println();
    }
}

public class VideoJuego {
    private Ejercito ejercito1;
    private Ejercito ejercito2;
    private Mapa mapa;
    private Scanner scanner;


    public VideoJuego() {
        scanner = new Scanner(System.in);
        inicializarEjercitos();
        mapa = new Mapa(ejercito1, ejercito2);
        mostrarResumenEjercitos();
        mapa.dibujarMapa();
    }

    private void inicializarEjercitos() {
        
        Random rand = new Random();
        String reino1 = seleccionarReino(rand);
        String reino2;
        do {
            reino2 = seleccionarReino(rand);
        } while (reino2.equals(reino1));

        ejercito1 = new Ejercito(reino1);
        ejercito2 = new Ejercito(reino2);
    }

    private String seleccionarReino(Random rand) {
        String[] reinos = {
            "Inglaterra",
            "Francia",
            "Castilla-Aragón",
            "Moros",
            "Sacro Imperio Romano Germánico"
        };
        return reinos[rand.nextInt(reinos.length)];
    }

    private void mostrarResumenEjercitos() {

        System.out.println("Jugador 1:");
        ejercito1.mostrarEjercito();

        
        System.out.println("Jugador 2:");
        ejercito2.mostrarEjercito();
    }

    public void iniciar() {
        System.out.println("=== Inicio del Juego ===\n");

        while (true) {
            
            if (ejercito1.estaVacio()) {
                System.out.println("¡El ejército " + ejercito2.getReino() + " ha ganado!");
                break;
            }
            if (ejercito2.estaVacio()) {
                System.out.println("¡El ejército " + ejercito1.getReino() + " ha ganado!");
                break;
            }

            
            turno(ejercito1, ejercito2, 1);
            mapa.dibujarMapa();

            
            if (ejercito1.estaVacio()) {
                System.out.println("¡El ejército " + ejercito2.getReino() + " ha ganado!");
                break;
            }
            if (ejercito2.estaVacio()) {
                System.out.println("¡El ejército " + ejercito1.getReino() + " ha ganado!");
                break;
            }

            
            turno(ejercito2, ejercito1, 2);
            mapa.dibujarMapa();
        }

        System.out.println("=== Fin del Juego ===");
    }

    private void turno(Ejercito atacante, Ejercito defensor, int numeroJugador) {
        System.out.println("Turno del Jugador " + numeroJugador + " (Ejército: " + atacante.getReino() + ").");

        Soldado soldadoSeleccionado = null;
        while (soldadoSeleccionado == null) {
            try {
                System.out.print("Ingrese la fila del soldado a mover (1-10): ");
                int fila = scanner.nextInt();
                System.out.print("Ingrese la columna del soldado a mover (1-10): ");
                int columna = scanner.nextInt();

                if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {
                    System.out.println("Coordenadas fuera del mapa. Intente nuevamente.\n");
                    continue;
                }

                for (Soldado s : atacante.getSoldados()) {
                    if (s.getFila() == fila && s.getColumna() == columna) {
                        soldadoSeleccionado = s;
                        break;
                    }
                }

                if (soldadoSeleccionado == null) {
                    System.out.println("No hay ningún soldado de su ejército en la posición especificada. Intente nuevamente.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese números válidos.\n");
                scanner.next();
            }
        }

        String direccion;
        while (true) {
            System.out.print("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha): ");
            direccion = scanner.next().toLowerCase();
            if (direccion.equals("arriba") || direccion.equals("abajo") ||
                direccion.equals("izquierda") || direccion.equals("derecha")) {
                break;
            } else {
                System.out.println("Dirección inválida. Intente nuevamente.\n");
            }
        }

        boolean movido = mapa.moverSoldado(soldadoSeleccionado.getFila(), soldadoSeleccionado.getColumna(),
                direccion, ejercito1, ejercito2);

        if (movido) {
            
            if (soldadoSeleccionado instanceof UnidadEspecial) {
                UnidadEspecial unidad = (UnidadEspecial) soldadoSeleccionado;
                System.out.print("¿Desea usar la habilidad especial de " + soldadoSeleccionado.getNombre() + "? (si/no): ");
                String respuesta = scanner.next().toLowerCase();
                if (respuesta.equals("si")) {
                    unidad.habilidadEspecial();
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        VideoJuego juego = new VideoJuego();

        juego.iniciar();
    }
}