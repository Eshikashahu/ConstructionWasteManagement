/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import constructionwmanagement.FinalMaterialEstimationFrame;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class DecisionForRCC 
{
   public  ArrayList  getWastageDecision(ArrayList user,ArrayList abt)
    {
        ArrayList result=new ArrayList();
        
        int lengthuser = Integer.parseInt((String) user.get(1));
        int brduser = Integer.parseInt((String) user.get(2));
        int thkuser = Integer.parseInt((String) user.get(3));
        double cementuser = Double.parseDouble((String) user.get(4));
        double agg20mmuser = Double.parseDouble((String) user.get(5));
        double msanduser = Double.parseDouble((String) user.get(6));
        
        String str1="Length: "+" "+Integer.toString(lengthuser);
        String str2="Breadth: "+" "+Integer.toString(brduser);
        String str3="Thickness: "+" "+Integer.toString(thkuser);
        String str4="Cement (Bags): "+" "+Double.toString(cementuser);
        String str5="20 mm Aggregates (Cft): "+" "+Double.toString(agg20mmuser);
        String str6="Msand (Cft): "+" "+Double.toString(msanduser);
       
        
        String userrccinput="\n"+str1+"\n"+str2+"\n"+str3+"\n"+str4+"\n"+str5+"\n"+str6;
        FinalMaterialEstimationFrame.res2=userrccinput;
    
        int lenabt = Integer.parseInt((String) abt.get(1));
        double cementabt = Double.parseDouble((String) abt.get(4));
        double agg20mmabt = Double.parseDouble((String) abt.get(5));
        double msandabt = Double.parseDouble((String) abt.get(6));
        double actualcement = (double) ((lengthuser * cementabt) / lenabt);
        double actualagg20mm = (double) (lengthuser * agg20mmabt) / lenabt;
        double actualmsand = (double) (lengthuser * msandabt) / lenabt;

        System.out.println("Actual Required Cement: "+actualcement);
        System.out.println("Actual Required agg20mm: "+actualagg20mm);
        System.out.println("Actual Required msand: "+actualmsand);
     
        double diffcement=cementuser-actualcement;
        diffcement=Double.parseDouble(new DecimalFormat("##.##").format(diffcement));
        double diffagg20mm=agg20mmuser-actualagg20mm;
        diffagg20mm=Double.parseDouble(new DecimalFormat("##.##").format(diffagg20mm));
        double diffmsand=msanduser-actualmsand;
        diffmsand=Double.parseDouble(new DecimalFormat("##.##").format(diffmsand));
       
        
String cementresult=(diffcement>0)?"Cement is wasted by Units:  "+diffcement:(diffcement<0)?"Cement is Shortage by Units:  "+Math.abs(diffcement):"No Wastage of Cement";
String agg20mmresult=(diffagg20mm>0)?"Aggregate 20mm is wasted by Units:  "+diffagg20mm:(diffagg20mm<0)?"Aggregate 20mm is Shortage by Units:  "+Math.abs(diffagg20mm):"No Wastage of Aggregate 20mm";
String msandresult=(diffmsand>0)?"Msand is wasted by Units:  "+diffmsand:(diffmsand<0)?"Msand is Shortage by Units:  "+Math.abs(diffmsand):"No Wastage of Msand";

String rccestimated="\n"+cementresult+"\n"+agg20mmresult+"\n"+msandresult;
FinalMaterialEstimationFrame.res4=rccestimated;

        ArrayList temp1=new ArrayList();
        ArrayList temp2=new ArrayList();
        ArrayList temp3=new ArrayList();
        ArrayList temp4=new ArrayList();
        ArrayList temp5=new ArrayList();
        ArrayList temp6=new ArrayList();
        
       
        
        temp1.add(Integer.toString(lengthuser));
        temp1.add("");
        
        temp2.add(Integer.toString(brduser));
        temp2.add("");
        
        temp3.add(Integer.toString(thkuser));
        temp3.add("");
        
        temp4.add(Double.toString(cementuser));
        temp4.add(cementresult);
        
        temp5.add(Double.toString(agg20mmuser));
        temp5.add(agg20mmresult);
        
        temp6.add(Double.toString(msanduser));
        temp6.add(msandresult);
        
         
        result.add(temp1);
        result.add(temp2);
        result.add(temp3);
        result.add(temp4);
        result.add(temp5);
        result.add(temp6);
     
        

        return result;
    }
}
