package objetos;

public class Partida {
    private int idPartida;
    private String nombreJugador;
    private int numJugadores;
    private int numRondas;
    private int maxPuntos;

    public Partida() {
    }

    public Partida(int idPartida,String nombreJugador, int numJugadores, int numRondas, int maxPuntos) {
        this.idPartida = idPartida;
        this.nombreJugador = nombreJugador;
        this.numJugadores = numJugadores;
        this.numRondas = numRondas;
        this.maxPuntos = maxPuntos;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getNumRondas() {
        return numRondas;
    }

    public void setNumRondas(int numRondas) {
        this.numRondas = numRondas;
    }

    public int getMaxPuntos() {
        return maxPuntos;
    }

    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }
}
