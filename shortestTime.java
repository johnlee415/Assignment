/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ADT.SortedArrayList;
import entity.Leaderboard;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author WellPLY
 */
public class shortestTime {
    shortestTime() throws FileNotFoundException, IOException{
         SortedArrayList <Leaderboard> LList=new SortedArrayList<Leaderboard>();
          
                  
          
        
          

           
           
                   
                     
                     
                      FileWriter writer= new FileWriter("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\client\\PlayerList.txt",true);
                       PrintWriter pw=new PrintWriter(writer);
                                          
                                    
                                  pw.println(LList.toString());
                                 
                                 
                                
                    
         
               
                  
               
                   
                    
                    
                   
                
                      
                 
                       
                     
                       
                       
                     
                    
                         
         
                     
                    
                        
                        
      int id=0;      
                     
                     int Time=0;
                  
                  
                     
              try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\client\\PlayerList.txt"))) {
             String line;
             
              int g=0;
             while( (line= br.readLine())!= null){
                 String tmp[]=line.split("-");
                   id=Integer.parseInt(tmp[0]);
                String name=tmp[1];
                
                 Time=Integer.parseInt(tmp[2]);
                 String Ranktype=tmp[3];
                 
                 LList.add(new Leaderboard(id,name,Time,Ranktype));
              g++;
                
                 System.out.println(id+"\t"+name+"\t"+Time+"\t"+Ranktype);
   
                
         
             
          }br.close();
                     
       
    
          

              }
              System.out.print(LList.toString());
            JTable j= new JTable();
            j.setBackground(new java.awt.Color(0, 0, 0));
        j.setFont(new java.awt.Font("Wide Latin", 0, 14)); // NOI18N
        j.setForeground(new java.awt.Color(255, 255, 255));
         j.setRowHeight(24);
           j.setRowSelectionAllowed(false);
             j.setShowGrid(false);
           JScrollPane sp = new JScrollPane(j);
           JFrame frame =new JFrame("Leaderboard");
        frame.setSize(300,100);
	  
               

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
       panel.add(sp);
        
        sp.setViewportView(j);
        	frame.add(panel);
		
		frame.setSize(30, 30);	
		frame.setVisible(true);
                panel.setBounds(211, 0, 0, 0);
                
            String[] columnsName={"PlayerName","PLayer_Name","FinishedTime","RanKType"};
                  
                  DefaultTableModel model =(DefaultTableModel)j.getModel();
                  model.setColumnIdentifiers(columnsName);
                
                  FileReader fr=new FileReader("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\client\\PlayerList.txt");
                  BufferedReader br1= new BufferedReader(fr);
          
                 Object  RowData[]=new Object[4];
                
             
                  for(int i=1;i<=LList.getLength();i++){
                      
                      RowData[0]=LList.getEntry(i).getPlayer_id();
                      RowData[1]=LList.getEntry(i).getName();
                      RowData[2]=LList.getEntry(i).getPlayer_Time();
                    
                       if (LList.getEntry(i)==LList.getEntry(1)){
                         RowData[3]="champion";
                     LList.getEntry(i).setRanktype("Campion");
                      }
                      else if (LList.getEntry(i)==LList.getEntry(2)){
                            RowData[3]="(2)Winner";
                            LList.getEntry(i).setRanktype("(2)Winner");
                      }
                      else if (LList.getEntry(i)==LList.getEntry(3)){
                         RowData[3]="(3)Winner";
                     LList.getEntry(i).setRanktype("(3)Winner");
                     
                         
                      }  
                       else if (LList.getEntry(i)==LList.getEntry(4)){
                         RowData[3]="(4)Winner";
                     LList.getEntry(i).setRanktype("(4)Winner");}
                        else if (LList.getEntry(i)==LList.getEntry(4)){
                         RowData[3]="(4)Winner";
                     LList.getEntry(i).setRanktype("(5)Winner");}
                       else RowData[3]="Gambateh!!!";
                      LList.getEntry(i).setRanktype("Gambateh!!!");

                
                      if(i<=20){
                                 model.addRow(RowData);
                      }
                       }
                     
                           
                      JButton back = new JButton("Back");
        back.setBounds(50,250,100,50);
        //signin.setBackground(new color.....);
        panel.add(back);
        back.addActionListener(new java.awt.event.ActionListener() {
          @Override  public void actionPerformed(java.awt.event.ActionEvent evt) { 
                   
                 new MainMenu();
     
                   
          }
        });     
                  
                       
                      
                     
                   
                      
                  }
               

                  
             
       
         
            
                  
       
            
                  
                
              
                     
                    public static void main(String[] args) throws IOException{
         
        new shortestTime();
        
}                    
     }              
             
            
                                   
    
   
                        
               
    
    
      
     
         
        
        
                       
                      


        


