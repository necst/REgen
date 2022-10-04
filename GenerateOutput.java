import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class GenerateOutput {
  private static String title;
  private FileWriter myWriter;

    public GenerateOutput(String name, String ext){
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      title = name+timestamp.getTime();
      try {
        File myObj = new File("./output/"+title+"."+ext);
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
          
        } else {
          System.out.println("File already exists.");
        }
        try {
          myWriter = new FileWriter("./output/"+title+"."+ext);
          
          //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred(2).");
          e.printStackTrace();
        }
      } catch (IOException e) {
        System.out.println("An error occurred(1).");
        e.printStackTrace();
      }
    }

    public void writeFile(String output) {
      try {
        //myWriter = new FileWriter("parser/output/"+title+".txt");
        //for(String s: output){
            myWriter.write(output+"\n");
        //}
        
        //System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    public void closeFile(){
      try {
        myWriter.close();
        System.out.println("Successfully file closed.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      
    }
    
}
