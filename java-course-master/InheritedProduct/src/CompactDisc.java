public class CompactDisc extends Product {
    private String artist;

    public CompactDisc() {
        super();
        artist = "";
        count ++;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return super.toString() + "Version      " + artist + "\n";
    }
}
