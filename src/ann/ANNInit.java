/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ann;

import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class ANNInit {
    
    public ArrayList getANNResult(ArrayList prelist)
    {
           
         WeightKeeper.b1=0.30;
         WeightKeeper.b2=0.50;
         
         WeightKeeper.w1=0.15;
         WeightKeeper.w2=0.28;
         
         WeightKeeper.w3=0.35;
         WeightKeeper.w4=0.46;
         WeightKeeper.w5=0.55;
         WeightKeeper.w6=0.67;
         
         WeightKeeper.w7=0.75;
         WeightKeeper.w8=0.78;
         
        

         ArrayList annprobabilitylist=new ArrayList();
        
         for (int i = 0; i <prelist.size(); i++) 
         {
             
             ArrayList row=(ArrayList) prelist.get(i);
           
             String str=(String) row.get(1);
             double attr1=Double.parseDouble(str);
             double target1=attr1;
             
             ArrayList temp=new ArrayList();
             double sum=0.0;
             
             String id=(String) row.get(0);
             temp.add(id);
             for (int j =2; j <row.size(); j++) 
             {       
                double attr2=Double.parseDouble((String) row.get(j)); 
                double target2=attr2;
                double probability=new HiddenLayerEstimation().getHiddenLayer(attr1, attr2, target1, target2 );
                sum=sum+probability;
                temp.add(Double.toString(probability));
             }
             
             double mean=sum/row.size()-1;
             temp.add(Double.toString(mean));
             annprobabilitylist.add(temp);
            
         }
         
        // ArrayList sortedannprobabilitylist= new Sorter().getSortedList(annprobabilitylist);
        return annprobabilitylist;
    }
    
}
