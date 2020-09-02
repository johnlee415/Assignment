package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
/**
 *
 * @author WellPLY
 */
 
public class  Leaderboard  implements  Comparable<Leaderboard>,Serializable {
    private  int player_id ;
    private  int player_Time;
    private String Ranktype;
    private String Name;
    private static int numplayer=1000;

   

   
   
    
    
    public Leaderboard(
    ){}
    
      public Leaderboard(int player_id,String Name,int player_Time,String Ranktype){
        this.player_id=player_id;
       this.player_Time=player_Time;
       this.Ranktype=Ranktype;
  
        this.Name=Name;
        
        }
     

  


   

    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
   
    

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getPlayer_Time() {
        return player_Time;
    }

    public void setPlayer_Time(int player_Time) {
        this.player_Time = player_Time;
    }

    public int getNumplayer() {
        return numplayer;
    }

    public void setNumplayer(int numplayer) {
        this.numplayer = numplayer;
    }
     public String getRanktype() {
        return Ranktype;
    }

    public void setRanktype(String Ranktype) {
        this.Ranktype = Ranktype;
    }
    public void dtmRankx(int PlayerTime){
        
    }
     public int hashCode() {
    int hash = 3;
    return hash;
  }
     

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Leaderboard other = (Leaderboard) obj;
   
    if (this.player_Time != other.player_Time) {
      return false;}
    
    return true;
    
    
    
  }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Leaderboard o) {
    return o.getPlayer_Time()- this.player_Time;

     }
 
   @Override
    public String toString() {
    return String.format("%d-%s-%d-%s",player_id,Name,player_Time,Ranktype);
    
  }
 
 
}
  
  
      
 

     
            
        
    
