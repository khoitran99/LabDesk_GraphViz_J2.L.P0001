/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class FileController {

    /* get file content from path */
    public String getFileContent(String path)  {
        String fileContent = "";
        try {
            Scanner scanner = new Scanner(new FileReader(path));
            while (scanner.hasNext()) {
                fileContent += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error in saveFile : "+e.getMessage());
        }
        return fileContent;
    }
    
    /* save file to path */
    public void saveFile(String path, String content) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error in saveFile : "+e.getMessage());
        }
    }
}
