import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class HW_4
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String text = " ";
        FileReader reader = new FileReader("db.sql");
        //список в формате "Фамилия Имя Отчество возраст пол" сразу в SQL записал
        while (reader. ready ()) {
            text += (char) reader. read();
        }
        reader.close();
        String [] str = text.split("\r\n");
        for (int i = 1; i < str.length; i++){
            String [] sb = str[i].split(" ");

            family.add(sb[0] + " ");
            name.add(sb[1].substring(0, 1) + ".");
            soname.add(sb[2].substring(0, 1) + "." + " ");
            age.add(Integer.valueOf(sb[3]));
            gender.add(sb[4] == " M" ? true : false);
            index.add(i);
        }
        
        /*Collections.sort(age, new Comparator<Integer>() {
        
        @Override
        public int compare(Integer o1, Integer o2)  {
            return o2-o1;
        }        
        });*/
        // какая то фигня с сортировкой, сортирует только возраст, а остальные параметры не сортирует

        for (int i = 0; i < index.size(); i++){
            System.out.printf(family.get(i));
            System.out.printf(name.get(i));
            System.out.printf(soname.get(i));
            System.out.printf(age.get(i).toString());
            System.out.printf((gender.get(i) ? " M" : " Ж"));
            System.out.println();
        }   
    }   
}

    


   