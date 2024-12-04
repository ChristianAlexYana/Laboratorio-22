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