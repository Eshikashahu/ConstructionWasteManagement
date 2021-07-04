/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzycmeans;

import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class FCMInit {
    
    public ArrayList FCMinit(ArrayList orgdata)
    {
        
        FCMRules fz=new FCMRules();
        
        ArrayList rule=fz.getFuzzyRules(orgdata);
            
        ArrayList fcluster=new FCMCluster().getFuzzyClusters(orgdata, rule);
        
        return fcluster;
        
        
    }
    
}
