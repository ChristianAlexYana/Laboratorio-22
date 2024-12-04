public class VideoJuego {
    private Ejercito ejercito1;
    private Ejercito ejercito2;
    private Mapa mapa;
    private Scanner scanner;

    public Juego() {
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
        Juego juego = new Juego();
        juego.iniciar();
    }
}