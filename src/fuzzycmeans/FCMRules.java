/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzycmeans;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author A57
 */
public class FCMRules {

    public ArrayList getFuzzyRules(ArrayList orgdata)
    {
        
            ArrayList summation=new ArrayList();
            
          for (int i = 0; i <orgdata.size(); i++)
          {
            ArrayList row=(ArrayList) orgdata.get(i);
             double sum=0.0;
             
              for (int j = 2; j <row.size(); j++) 
              {
                  sum=sum+Double.parseDouble((String) row.get(j));                  
              }
              summation.add(Double.toString(sum));
          }
        
      //   System.out.println("Orgdata Row Mean" +mean);
          
        System.out.println("Summation List Print");
        System.out.println(summation);
            ArrayList rule=new FCMRange().getMinMax(summation);
         
         System.out.println("RULES ARE: "+rule);
              
     return rule;
    }

}
