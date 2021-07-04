/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class DecisionTreeInit {
    
    public ArrayList getDTResult(ArrayList annprobability, ArrayList userinputproblist)
    {
        ArrayList dtresult=new ArrayList();      
        
           
            int rowid=0;
            
//        
            ArrayList row1=(ArrayList) userinputproblist.get(0);            
            double avgvalue1=Double.parseDouble((String) row1.get(row1.size()-1));
//            System.out.println("Average Value: "+avgvalue1);
              double smalldiff=avgvalue1;
        
            for (int j = 0; j <annprobability.size(); j++) 
            {
               ArrayList row2=(ArrayList) annprobability.get(j);
         //       System.out.println("Row2: "+row2);
               double avgvalue2=Double.parseDouble((String) row2.get(row2.size()-1)); 
          //     System.out.println("Average Value: "+avgvalue2);
               
               double diff=Math.abs(avgvalue1-avgvalue2);
//               System.out.println("Difference: "+diff);
               
               if(smalldiff>diff)
               {
                   smalldiff=diff;
                   rowid=j;
                   
               
            }
        }
        
             
        dtresult=(ArrayList) annprobability.get(rowid);
    
        
        return dtresult;
    }
    
}
