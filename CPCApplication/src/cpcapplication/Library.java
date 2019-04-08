<<<<<<< HEAD

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpcapplication;
/**
 *
 * @author kyle addy and Taylor Perry-- base code
 * @author chris mcclure-- bug fixes
 */
import java.io.*;
import java.io.File;
import java.io.File.*;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class  Library {
      public static void main(String[] args) throws IOException{
                    
    }
   
    Library() throws IOException {//contructor
        // gets the username of the current user
        String username = System.getProperty("user.name");
        
        //creates a file instance of the library and its path
        File file=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
        boolean exists = file.isDirectory();
        
        //if the library directory does not exist then create it else do nothing
        if (!exists){
            System.out.println("The Library does not exist");
            
            file.getAbsoluteFile().mkdirs();
            if (exists) {
                System.out.println("Library was created!");
            } else {
                System.out.println("Failed to create the Library!");
            }
        } else {
            System.out.println("The Library exists");
        }
    }
    
    
    static void addAFile(File src) throws FileNotFoundException, IOException {
        
        //checks to see if the file that is being added to the Library directory exist
        if (src.exists()){
            
            //gets the username of the current user
            String username = System.getProperty("user.name");
            
            //creats a file instance of the destination file
            File dest=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library\\" + src.getName());

            //creates the file into the Library directory
            dest.createNewFile();

            //creates the options used for the copy
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            
            //copy the contents of the file to the destination file in the Library directory
             Files.copy(src.toPath(), dest.toPath(), options);
             System.out.println("File: " +dest.getName() + " has been copied to the Library");
        } else
        {
            System.out.println("File does not exist or path is bad");
        }
        
    }
      
     static void remAFile(File file){
        //gets the username of the current user
            String username = System.getProperty("user.name");
            
            //creats a file instance of the destination file
            File libFile = new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library\\" + file.getName());
            
            //checks to see if the file exists in the Library
            if (libFile.exists())
            {
                libFile.delete();
                System.out.println("File in library with the name of " + file.getName() + " has been deleted from the library");
            }
            else {
                System.out.println("There was no file with the name of " + file.getName() + " in the library");
 
                }
    }
}

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpcapplication;
/**
 *
 * @author Kyle Addy, Taylor Perry
 * 
 */
import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;



public class  Library {
      public static void main(String[] args) throws IOException{
          
//// this makes it to where you can get a file from any machines desktop(doesnt make it specific to each computer)
          String username = System.getProperty("user.name");
         // String please = ("C:\\Users\\"+ username +"\\Desktop\\test.txt");
          // Path test = new Paths.get("C:\\Users\\"+ username +"\\Desktop\\test.txt");
          
//// mading 'please' to the source of the text file you want to use
          Path please = Paths.get("C:\\Users\\"+ username +"\\Desktop\\test.txt");
        
//// takes the path and gets the file from the path
          File src = please.toFile();
//// checks to see if the src location exists
          boolean exist = src.exists();
//// outputs the result
          System.out.println(exist);
          //File dest=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
          
            //File dest = new File("Library Path: C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
         //addAFile(test);
         //fileCopy(test,dest);
         //copydir(src,dest);
    }
   
    Library() {//contructor
        
        String username = System.getProperty("user.name");
        
//// THis sets File to be the location of where the library of files will be stored. 
        File file=new File("C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
        boolean exists = file.isDirectory();
        if (!exists){
//// if the destination library is not there.. it tells you
            System.out.println("The Library does not exist");
           
//// if destination library isnt there it will amake it for you. it is called library.         
            if (file.mkdir()) {
                System.out.println("Library was created!");
                 System.out.println("Library Path: C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");
            } else {
                System.out.println("Failed to create the Library!");
            }
        }
        else{
        System.out.println("The Library exist");
        }
    }
    
    
    private static void addAFile(File src) throws FileNotFoundException, IOException {
//// this still makes it to any machine can acess the right files.        
        String username = System.getProperty("user.name");
          
//// this sets "dest" as the location of where you want to put your copied file. 
            File dest = new File("Library Path: C:\\Users\\" + username +"\\Documents\\cpcapplication\\library");

//            if(!srcdir.exists()){
//                System.out.println("Directory not found");
//            }
//            else{
//                Library fileDemo = new Library();
//                fileDemo.copydir(srcdir, destdir);
//                System.out.println("Coppied success");
//            }
        
        ////sets the input and output of key words in && out as zero
             InputStream in = null;
            OutputStream out = null; 
//// this try loop will look at a file and make the file YOU WANT TO copy and out
 //  puts the copied file to the 'dest'ination folder. 
            try
            {
                in = new FileInputStream(src);
                out = new FileOutputStream(dest);
                
  //// THis reads what is in the "in" and then stores it then puts it into the "out" therefore creating a copy of the file
                byte[] buffer = new byte[1024];
                
                int length; 
                while ((length = in.read(buffer)) > 0 )
                {
                    out.write(buffer,0, length);
                }
            }
// one it gets to the end of each file from the folder it will close both the folders. 
            finally
            {
                if (in != null)
                {
                    in.close();
                }
                if(out != null)
                {
                    out.close();
                }
            }
            System.out.println("File copied from " + src + "to " + dest);           
        }
    
     public static void copydir(File src, File dest) throws IOException
        {
//            if(src.isDirectory())
//            {
//                if(!dest.exists())
//                {
//                    dest.mkdir();
//                    System.out.print("Directory copied from " + src + "to " + dest);
//                }
//                String files[] = src.list();
//                
//                for (String fileName : files)
//                {
//                    File srcFile = new File(src, fileName);
//                    File destFile = new File(dest, fileName);
//                    copydir(srcFile, destFile);
//                   
//                }
//            }
//            else{
         //// i think kyle ddidnt finish this part. Having trouble just reading the .txt file and not just the whole folder. 
                fileCopy(src, dest);
            //}
          }
     //// this was the attempt to make it to were we didnt need the src file to be in a folder. 
    //// but i think this is where we crashed at 1 pm. 
        private static void fileCopy(File src, File dest)
                throws FileNotFoundException, IOException
                
        {
            InputStream in = null;
            OutputStream out = null; 
            
            try
            {
                in = new FileInputStream(src);
                out = new FileOutputStream(dest);
                
                byte[] buffer = new byte[1024];
                
                int length; 
                while ((length = in.read(buffer)) > 0 )
                {
                    out.write(buffer,0, length);
                }
            }
            
            finally
            {
                if (in != null)
                {
                    in.close();
                }
                if(out != null)
                {
                    out.close();
                }
            }
            System.out.println("File copied from " + src + "to " + dest);
        }
}
>>>>>>> 7715ed19cd1b348591547591a48c4b11469e5927
