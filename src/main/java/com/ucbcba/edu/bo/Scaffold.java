package com.ucbcba.edu.bo;

import java.io.IOException;
import java.util.List;
import java.util.jar.Attributes;


public class Scaffold {
    public static boolean scaffold(String obj, Directions directions,List<Attribute> prop) throws IOException {
        String Page="package "+directions.getPackg()+";\n" +
                "\n" +
                "import org.springframework.data.annotation.Id;\n" +
                "\n" +
                "import javax.persistence.Entity;\n";
        String Class="@Entity\n" +
                "public class "+obj+"{\n";
        String Prop=create_props(prop);
        String Setters=create_setters(prop);
        String java=Page+Class+Prop+Setters;
        System.out.println(java);
        return true;
    }

    private static String create_setters(List<Attribute> prop) {
      String result="";
        String setter="";
        String getter="";
        for (Attribute attrib:prop) {
            setter="public void set";
            char att;
            String Prop="";
            att=attrib.name.toCharArray()[0];
            Prop=attrib.name;
            String replace = Prop.replace(att,'\u0000');
            String car= String.valueOf(att).toUpperCase();
            setter+=car+replace+"("+attrib.type+" "+attrib.name+"){ \n";
            setter+="     {this."+attrib.name+"="+attrib.name+";}\n";
            result+=setter;

            getter="public "+attrib.type+" get";
            getter+=car+replace+"(){ \n";
            getter+="     {return "+attrib.name+";}\n";
            result+=getter;
        }

       return result;
    }

    private static String create_props(List<Attribute> attributes) {
        String Prop="";
        for (Attribute attrib:attributes) {
            Prop+="     private "+attrib.type+" "+attrib.name+";\n";
        }
        Prop+="\n";
        return Prop;
    }

}
