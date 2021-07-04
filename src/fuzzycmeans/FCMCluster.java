/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzycmeans;

import java.util.ArrayList;

/**
 *
 * @author A57
 */
public class FCMCluster {

   
    public ArrayList getFuzzyClusters(ArrayList orgdata,ArrayList rules)
    {
        
          ArrayList clusters=new ArrayList();   
          
        for(int i=0;i<rules.size();i++)
        {
            ArrayList rule =(ArrayList)rules.get(i);
            
            ArrayList single=new ArrayList();
     
               double r1=(double) rule.get(0);
               double r2=(double) rule.get(1);
                      
                for(int j=0;j<orgdata.size();j++)
                {
                ArrayList row=(ArrayList)orgdata.get(j);
                
                double rowsum=0;
                    for (int k =2; k <row.size(); k++) 
                    {
                       rowsum=rowsum+ Double.parseDouble((String) row.get(k));
                    }
                if(rowsum>=r1&&rowsum<=r2)
                {             
                    single.add(row);
                }

                }
               // System.out.println("cluster size is ++++++++++++++ "+cluster.size());
                if(single.size()>0)
                {
                   // System.out.println("Cluster is "+cluster);
                     clusters.add(single);
                }
        }

 //System.out.println(fclusters);

return clusters;

    }
}
