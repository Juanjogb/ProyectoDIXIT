package objetos;

import android.os.Parcel;
import android.os.Parcelable;

public class Jugador implements Parcelable{
    private String nombre;
    private String email;
    private String password;
    private String nick;
    private String avatar;
    private int puntos;
    private int partidasJugadas;


    public Jugador() {
    }

    public Jugador(String nombre, String email, String password, String nick, String avatar, int puntos, int partidasJugadas) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.nick = nick;
        this.avatar = avatar;
        this.puntos = puntos;
        this.partidasJugadas = partidasJugadas;
    }

    protected Jugador(Parcel in) {
        nombre = in.readString();
        email = in.readString();
        password = in.readString();
        nick = in.readString();
        avatar = in.readString();
        puntos = in.readInt();
        partidasJugadas = in.readInt();
    }

    public static final Creator<Jugador> CREATOR = new Creator<Jugador>() {
        @Override
        public Jugador createFromParcel(Parcel in) {
            return new Jugador(in);
        }

        @Override
        public Jugador[] newArray(int size) {
            return new Jugador[size];
        }
    };

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(nick);
        dest.writeString(avatar);
        dest.writeInt(puntos);
        dest.writeInt(partidasJugadas);
    }
}
