public class Map {
    
    int height;
    int width;
    int posX;
    int posY;
    char[] mapDesign;


    public Map(int height, int width, int posX, int posY, char[] mapDesign) {
        this.height = height;
        this.width = width;
        this.posX = posX;
        this.posY = posY;
        this.mapDesign = mapDesign;
    }

    //print Map
    public void printMap(){

        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                System.out.print(mapDesign[i*width + j]);
            }
            System.out.println();
        }
        
    }

    public char[] getMapDesign() {
        return mapDesign;
    }

    public void setMapDesign(char[] mapDesign) {
        this.mapDesign = mapDesign;
    }



}
