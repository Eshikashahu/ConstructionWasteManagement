/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructionwmanagement;


import Utililty.DataSetReader;
import ann.ANNInit;
import decisiontree.DecisionForRCC;
import decisiontree.DecisionForRaw;
import decisiontree.DecisionTreeInit;
import fuzzycmeans.FCMInit;
import java.util.ArrayList;
import linearselection.LinearSelectionInit;


public class ProcessInit {
    
    public void initProcess()
    {
        
      
        ArrayList rawmaterial=new DataSetReader().getExcelData("D://Construction Dataset.xls", 0);
        
         String res1="";
         for(int i=0;i<rawmaterial.size();i++)
           {
               ArrayList t=(ArrayList) rawmaterial.get(i);
               String temp=t.toString();
               res1=res1+"\n "+temp;
                //               System.out.println(temp);
           }
            DataDisplayFrame.res1=res1;
            
            
            ArrayList rccmaterial=new DataSetReader().getExcelData("D://Construction Dataset.xls", 1);
        
         String res2="";
         for(int i=0;i<rccmaterial.size();i++)
           {
               ArrayList t=(ArrayList) rccmaterial.get(i);
               String temp=t.toString();
               res2=res2+"\n "+temp;
                //               System.out.println(temp);
           }
            DataDisplayFrame.res2=res2;
            
            
            System.out.println("\n");
            System.out.println("Fuzzy C-means Clusters for Raw Materials************************************************************");
            
            ArrayList fcmrawmat=new FCMInit().FCMinit(rawmaterial);
            
            for(int i=0;i<fcmrawmat.size();i++)
        {
            System.out.println("CLUSTER NO "+(i+1));
            ArrayList t=(ArrayList) fcmrawmat.get(i);
            
            for(int j=0;j<t.size();j++)
            {
                ArrayList t1=(ArrayList) t.get(j);
                System.out.println(t1);
            }
                        
                    System.out.println();
            
        }
         
            String res3="";
           
         for(int i=0;i<fcmrawmat.size();i++)
           {
              res3=res3+" FUZZYC-MEANS CLUSTER NO "+(i+1)+"\n";
               String s1="";
               
               ArrayList t=(ArrayList) fcmrawmat.get(i);
               for(int j=0;j<t.size();j++)
               {
                 ArrayList t1=(ArrayList) t.get(j);
                 String s2=t1.toString();
                  s1=s1+"\n"+s2;      
               }
               
               res3=res3+"\n"+s1;
               res3=res3+"\n\n--------------------------------------------------\n\n";
               
                //               System.out.println(temp);
           }
         FuzzyCMeansClusterFrame.res1=res3;
            
             System.out.println("\n");
            System.out.println("Fuzzy C-means Clusters for RCC************************************************************");
            
            ArrayList fcmrcc=new FCMInit().FCMinit(rccmaterial);
            
            for(int i=0;i<fcmrcc.size();i++)
        {
            System.out.println("CLUSTER NO "+(i+1));
            ArrayList t=(ArrayList) fcmrcc.get(i);
            
            for(int j=0;j<t.size();j++)
            {
                ArrayList t1=(ArrayList) t.get(j);
                System.out.println(t1);
            }
                        
                    System.out.println();
            
        }
            
            String res4="";
           
         for(int i=0;i<fcmrcc.size();i++)
           {
              res4=res4+" FUZZYC-MEANS CLUSTER NO "+(i+1)+"\n";
               String s1="";
               
               ArrayList t=(ArrayList) fcmrcc.get(i);
               for(int j=0;j<t.size();j++)
               {
                 ArrayList t1=(ArrayList) t.get(j);
                 String s2=t1.toString();
                  s1=s1+"\n"+s2;      
               }
               
               res4=res4+"\n"+s1;
               res4=res4+"\n\n--------------------------------------------------\n\n";
               
                //               System.out.println(temp);
           }
         FuzzyCMeansClusterFrame.res2=res4;
         
           
        System.out.println("\n");
          System.out.println(" Cluster from Linear Selection for Raw Material************************************************************");
          
          double inputsum1=Double.parseDouble(DataKeeper.cement1)+Double.parseDouble(DataKeeper.sand)+Double.parseDouble(DataKeeper.stone1)+Double.parseDouble(DataKeeper.stone2)+Double.parseDouble(DataKeeper.bricks)+Double.parseDouble(DataKeeper.steel);    
          
          ArrayList lnrraw=new LinearSelectionInit().getLinearSelectionResult(fcmrawmat, inputsum1);
          
          for (int i = 0; i <lnrraw.size(); i++) 
          {
              System.out.println(lnrraw.get(i));
          }
          
           String res5="";
         for(int i=0;i<lnrraw.size();i++)
           {
               ArrayList t=(ArrayList) lnrraw.get(i);
               String temp=t.toString();
               res5=res5+"\n "+temp;
                //               System.out.println(temp);
           }
            LinearSelectionFrame.res1=res5;
          
          
          System.out.println("\n");
          System.out.println("Linear Selection for RCC************************************************************");
          
          double inputsum2=Double.parseDouble(DataKeeper.breadth)+Double.parseDouble(DataKeeper.thickness)+Double.parseDouble(DataKeeper.cement2)+Double.parseDouble(DataKeeper.agggregat)+Double.parseDouble(DataKeeper.msand);    
          
          ArrayList lnrrcc=new LinearSelectionInit().getLinearSelectionResult(fcmrcc, inputsum2);
          
            for (int i = 0; i <lnrrcc.size(); i++) 
          {
              System.out.println(lnrrcc.get(i));
          }
          
        //  System.out.println(lsrcccluster);
          
          String res6="";
         for(int i=0;i<lnrrcc.size();i++)
           {
               ArrayList t=(ArrayList) lnrrcc.get(i);
               String temp=t.toString();
               res6=res6+"\n "+temp;
                //               System.out.println(temp);
           }
            LinearSelectionFrame.res2=res6;
            
          
            System.out.println("\n");
          System.out.println("ANN Probability Value for Raw Materials************************************************************");
   
          ArrayList annlistraw=new ANNInit().getANNResult(lnrraw);
          
          System.out.println("P1"+" "+"P2"+ " "+"P3"+" "+"P4"+" "+"P5"+ " "+"P6"+" "+"Average");
          for (int i = 0; i <annlistraw.size(); i++) 
          {
              System.out.println(annlistraw.get(i));
          }
          
          
          String res7="";
         for(int i=0;i<annlistraw.size();i++)
           {
               ArrayList t=(ArrayList) annlistraw.get(i);
               String temp=t.toString();
               res7=res7+"\n "+temp;
                //               System.out.println(temp);
           }
            ANNProbabilityFrame.res1=res7;
            
            
          System.out.println("\n");
          System.out.println("ANN Probability Value for User Raw Materials Input************************************************************");
          ArrayList temp=new ArrayList();
          
          temp.add(Integer.toString(1));
          temp.add(DataKeeper.area);
          temp.add(DataKeeper.cement1);
          temp.add(DataKeeper.sand);
          temp.add(DataKeeper.stone1);
          temp.add(DataKeeper.stone2);
          temp.add(DataKeeper.bricks);
          temp.add(DataKeeper.steel);
          
          ArrayList userinputlist=new ArrayList();
          userinputlist.add(temp);
//          
          ArrayList userinputannprobvalue=new ANNInit().getANNResult(userinputlist);
          
          System.out.println("user input Probability value "+userinputannprobvalue);
          
          
         
          System.out.println("ANN Probability Value for RCC Materials************************************************************");
   
          ArrayList annlistrcc=new ANNInit().getANNResult(lnrrcc);
          
         System.out.println("P1"+" "+"P2"+ " "+"P3"+" "+"P4"+" "+"P5"+ " "+""+" "+"Average");
          for (int i = 0; i <annlistrcc.size(); i++) 
          {
              System.out.println(annlistrcc.get(i));
          }
          
          
          String res8="";
         for(int i=0;i<annlistrcc.size();i++)
           {
               ArrayList t=(ArrayList) annlistrcc.get(i);
               String temp1=t.toString();
               res8=res8+"\n "+temp1;
                //               System.out.println(temp);
           }
            ANNProbabilityFrame.res2=res8;
            
          
          System.out.println("\n");
          System.out.println("ANN Probability Value for User RCC Materials Input************************************************************");
          ArrayList temp1=new ArrayList();
          
          temp1.add(Integer.toString(1));
          temp1.add(DataKeeper.length);
          temp1.add(DataKeeper.breadth);
          temp1.add(DataKeeper.thickness);
          temp1.add(DataKeeper.cement2);
          temp1.add(DataKeeper.agggregat);
          temp1.add(DataKeeper.msand);
         
          
          ArrayList userinputlistrcc=new ArrayList();
          userinputlistrcc.add(temp1);
//          
          ArrayList userinputannprobvaluercc=new ANNInit().getANNResult(userinputlistrcc);
//          
          System.out.println("user input Probability value for RCC "+userinputannprobvaluercc);
          
         ArrayList dtresult=  new DecisionTreeInit().getDTResult(annlistraw, userinputannprobvalue);
        
        System.out.println("Matched Row Probability Score from Decision Tree: "+dtresult);
        
        ArrayList annobtained=new ArrayList();
        
        String rowid=(String) dtresult.get(0);
        
        for (int i = 0; i <lnrraw.size(); i++) 
        {
            ArrayList row=(ArrayList) lnrraw.get(i);
            
            String id=(String) row.get(0);
            
            if(rowid.equals(id))
            {
                annobtained=row;
            }
            
        }
        
        
        System.out.println("Original Row Result: "+annobtained);
        
        System.out.println("User Input List: "+temp);
        
        ArrayList rawresult=new DecisionForRaw().getWastageDecision(temp, annobtained);
          System.out.println("\n============================================================\n");
        System.out.println("Obtained Wastege Result For Raw Construction Material is");
        for (int i = 0; i < rawresult.size(); i++)
        {
            ArrayList rrow=(ArrayList)rawresult.get(i);
            System.out.println(rrow);
        }
        System.out.println("\n============================================================\n");
        

        // FOR RCC Deceision Tree STARTS FROM HERE  ==============================
        
      
//          
        ArrayList dtresultrcc=  new DecisionTreeInit().getDTResult(annlistrcc, userinputannprobvaluercc);
//        
        System.out.println("Matched Row Probability Score from Decision Tree for RCC: "+dtresultrcc);
        
        ArrayList annobtainedrcc=new ArrayList();
        
        String rowidrcc=(String) dtresultrcc.get(0);
        
        for (int i = 0; i <lnrrcc.size(); i++) 
        {
            ArrayList row=(ArrayList) lnrrcc.get(i);
            
            String id=(String) row.get(0);
            
            if(rowidrcc.equals(id))
            {
                annobtainedrcc=row;
            }
            
        }
        
        
        System.out.println("Original Row Result for RCC: "+annobtainedrcc);
        
        System.out.println("User Input List for RCC: "+temp1);
        
        ArrayList rccresult=new DecisionForRCC().getWastageDecision(temp1, annobtainedrcc);
          System.out.println("\n============================================================\n");
        System.out.println("Obtained Wastege Result For RCC Construction Material is");
        for (int i = 0; i < rccresult.size(); i++)
        {
            ArrayList rrow=(ArrayList)rccresult.get(i);
            System.out.println(rrow);
        }
        System.out.println("\n============================================================\n");
        
            
        
    }
    
}
