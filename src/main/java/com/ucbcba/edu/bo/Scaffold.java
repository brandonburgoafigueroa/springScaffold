package com.ucbcba.edu.bo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class Scaffold {
    public static boolean scaffold(Object object) throws IOException {
        scaffold_java_file(object);
        return true;
    }
    private static void scaffold_java_file(Object object) throws IOException {
        String Page="package "+object.packg+";\n" +
                "\n" +
                "import org.springframework.data.annotation.Id;\n" +
                "\n" +
                "import javax.persistence.Entity;\n";
        String Class="@Entity\n" +
                "public class "+object.name+"{\n";
        String Prop=create_props(object.attributes);
        String Setters=create_setters(object.attributes);
        String java=Page+Class+Prop+Setters+"}";
        write_model_file(java, object);
    }

    private static void write_model_file(String java,Object object) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(object.directions.JavaFile));
        writer.write(java);
        writer.close();
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
            setter+=car+replace+"("+attrib.type+" "+attrib.name+") \n";
            setter+="     {this."+attrib.name+"="+attrib.name+";}\n";
            result+=setter;

            getter="public "+attrib.type+" get";
            getter+=car+replace+"() \n";
            getter+="     {return "+attrib.name+";}\n";
            result+=getter;
        }

       return result;
    }

    private static String create_props(List<Attribute> attributes) {
        String Prop="";
        for (Attribute attrib:attributes) {
            if (attrib.key.equals(""))
            {Prop+="     private "+attrib.type+" "+attrib.name+";\n";}
            else
            {
                Prop+="@Id \n";
                Prop+="@GeneratedValue(strategy = GenerationType.AUTO)";
                Prop+="     private "+attrib.type+" "+attrib.name+";\n";
            }
        }
        Prop+="\n";
        return Prop;
    }
}
