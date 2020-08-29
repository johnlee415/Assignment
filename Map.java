package entity;


public class Map {
    private short levelData;
    
    public Map(short levelData){
        this.levelData = levelData;
    }
    
    public short getArray(){
        return levelData;
    }
    
    public void setArray(short levelData)
    {
        this.levelData = levelData;
    }
}
