public class ShikiMap {
    private String loc;
    private String lastMod;
    private float priority;

    public ShikiMap(String loc, String lastMod, float priority) {
        this.loc = loc;
        this.lastMod = lastMod;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ShikiMap{" +
                "loc='" + loc + '\'' +
                ", lastMod='" + lastMod + '\'' +
                ", priority=" + priority +
                '}';
    }
}
