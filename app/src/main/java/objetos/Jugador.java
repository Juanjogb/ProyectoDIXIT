package objetos;

import android.widget.ImageButton;

public class Jugador {
    private String nombre;
    private String email;
    private String password;
    private String nick;
    private ImageButton avatar;
    private int puntos;
    private int partidasJugadas;


    public Jugador() {
    }

    public Jugador(String nombre, String email, String password, String nick, ImageButton avatar, int puntos, int partidasJugadas) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.avatar = avatar;
        this.puntos = puntos;
        this.partidasJugadas = partidasJugadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public ImageButton getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageButton avatar) {
        this.avatar = avatar;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }
}
