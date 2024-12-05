public class Sokoban {

    //we will define '#' as a wall, '$' as a box not placed on its final spot, '*' as a box placed on its final spot,
    //'.' as a final spot for a box, '@' as the player, '+' as the player on a final spot, and '' for an empty case

    public static Map move(Map map, int movX, int movY) {
        int height = map.height;
        int width = map.width;
        char[] newElements = map.getMapDesign().clone();
        int posX = map.posX;
        int posY = map.posY;

        int newX = posX + movX;
        int newY = posY + movY;

        if (newX < 0 || newX >= width || newY < 0 || newY >= height || map.mapDesign[newY * width + newX] == '#') {
            return map; 
        }

        if (map.mapDesign[newY * width + newX] == '$') {
            int newBoxX = newX + movX;
            int newBoxY = newY + movY;

            if (map.mapDesign[newBoxY * width + newBoxX] == '#' || map.mapDesign[newBoxY * width + newBoxX] == '$' || map.mapDesign[newBoxY * width + newBoxX] == '*') {
                return map;
            }

            if (map.mapDesign[newBoxY * width + newBoxX] == '.') {
                newElements[newBoxY * width + newBoxX] = '*';
                newElements[newY * width + newX] = '@';
            } 
            
            else {
                newElements[newBoxY * width + newBoxX] = '$';
                newElements[newY * width + newX] = '@';
            }
        } 
        
        else if (map.mapDesign[newY * width + newX] == '*') {
            int newBoxX = newX + movX;
            int newBoxY = newY + movY;

            if (map.mapDesign[newBoxY * width + newBoxX] == '#' || map.mapDesign[newBoxY * width + newBoxX] == '$' || map.mapDesign[newBoxY * width + newBoxX] == '*') {
                return map;
            }

            if (map.mapDesign[newBoxY * width + newBoxX] == '.') {
                newElements[newBoxY * width + newBoxX] = '*';
                newElements[newY * width + newX] = '+';
            } 
            
            else {
                newElements[newBoxY * width + newBoxX] = '$';
                newElements[newY * width + newX] = '+';
            }
        } 
        
        else if (map.mapDesign[newY * width + newX] == '.') {
            newElements[newY * width + newX] = '+';
        } 
        
        else {
            newElements[newY * width + newX] = '@';
        }

        if (map.mapDesign[posY * width + posX] == '+') {
            newElements[posY * width + posX] = '.';
        } 
        
        else if (map.mapDesign[posY * width + posX] == '@') {
            newElements[posY * width + posX] = ' ';
        }

        return new Map(height, width, newX, newY, newElements);
    }

  
    public static Map replay(Map map, int length, char[] movements) {
        Map newMap = map;

        for (int i = 0; i < length; i++) {
            switch (movements[i]) {
                case 'N': newMap = move(newMap, 0, -1); break;
                case 'E': newMap = move(newMap, 1, 0); break;
                case 'S': newMap = move(newMap, 0, 1); break;
                case 'W': newMap = move(newMap, -1, 0); break;
            }
        }

        return newMap;
    }




    

}






















