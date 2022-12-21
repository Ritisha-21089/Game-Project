public class Lab1 {
    public static Bullets getclone(Bullets bomb) throws CloneNotSupportedException {
        return (Bullets) bomb.clone();

    }
}