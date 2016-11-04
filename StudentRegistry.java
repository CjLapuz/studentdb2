package studentdb2;

import java.io.*;
import java.util.*;
// Imports from JFrame
import static studentdb2.StudentDB.sNum;
import static studentdb2.StudentDB.sFName;
import static studentdb2.StudentDB.sMName;
import static studentdb2.StudentDB.sLName;
import static studentdb2.StudentDB.sCourse;
import static studentdb2.StudentDB.sYear;
import static studentdb2.StudentDB.search;
import static studentdb2.StudentDB.adD;
import static studentdb2.StudentDB.deletE;
import static studentdb2.StudentDB.updatE;
import static studentdb2.StudentDB.indx;
import static studentdb2.StudentDB.crushName;
import static studentdb2.StudentDB.subjDesc;
import static studentdb2.StudentDB.subjCode;

public class StudentRegistry {
    
    private static final String FILE_NAME = "C:\\Users\\Jeremy\\Documents\\NetBeansProjects\\studentdb2\\src\\studentdb2\\studentListing.txt";
    
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    
    List<Student> studentList = new ArrayList<Student>();
    Student stud = new Student();
    
    public StudentRegistry(){}
    
    public void searchMode(){ // Search Mode
        search.setEnabled(true);
        sNum.setEnabled(true);
        sFName.setEnabled(false);
        sMName.setEnabled(false);
        sLName.setEnabled(false);
        sCourse.setEnabled(false);        
        sYear.setEnabled(false);
        adD.setEnabled(false);
        deletE.setEnabled(true);
        updatE.setEnabled(false);
        crushName.setEnabled(false);
        subjDesc.setEnabled(false);
        subjCode.setEnabled(false);
    }    
    public void addMode(){ // Add Mode
        search.setEnabled(false);
        sNum.setEnabled(true);
        sFName.setEnabled(true);
        sMName.setEnabled(true);
        sLName.setEnabled(true);
        sCourse.setEnabled(true);        
        sYear.setEnabled(true);
        adD.setEnabled(true);
        deletE.setEnabled(false);
        updatE.setEnabled(false);
        crushName.setEnabled(true);
        subjDesc.setEnabled(true);
        subjCode.setEnabled(true);
    }
    public void updateMode(){ // Update Mode
        search.setEnabled(false);
        sNum.setEnabled(false);
        sFName.setEnabled(true);
        sMName.setEnabled(true);
        sLName.setEnabled(true);
        sCourse.setEnabled(true);        
        sYear.setEnabled(true);
        adD.setEnabled(false);
        deletE.setEnabled(false);
        updatE.setEnabled(true);
        crushName.setEnabled(true);
        subjDesc.setEnabled(true);
        subjCode.setEnabled(true);
    }
    // Adds a student to the List
    public void add(){
        addDataToFile();
        reWriteFile();
    }
    // Deletes a student from the List
    public void delete(){
        int index = Integer.parseInt(indx.getText());
        studentList.remove(index);
        reWriteFile();
    }
    // Searches for the indicated student number
    public boolean search(String num){
        int index = 0;
        for (Student st: studentList) {
            indx.setText(String.valueOf(index));
            if(st.getStudentNumber().equals(num)){
                sFName.setText(st.getFirstName());
                String mid = String.valueOf(st.getMiddleInitial());
                sMName.setText(mid);
                sLName.setText(st.getLastName());
                sCourse.setText(st.getCourse());
                String yr = String.valueOf(st.getYearLevel());
                sYear.setText(yr);
                crushName.setText(st.getCrushName());
                subjCode.setText(st.getFavSubjCode());
                subjDesc.setText(st.getFavSubjDesc());
                return true;
            }
            index++;
	}
        return false;
    }
    // Searches for the indicated student number
    public void update(){
        int index = Integer.parseInt(indx.getText());
        Student stdnt = studentList.get(index);
        stdnt.setFirstName(sFName.getText());
        stdnt.setMiddleInitial((sMName.getText().charAt(0)));
        stdnt.setLastName(sLName.getText());
        stdnt.setCourse(sCourse.getText());
        stdnt.setYearLevel(Integer.parseInt(sYear.getText()));
        reWriteFile();
    }
    // Checks for repeated Studnet numbers
    public boolean ifRepetition(String num){
        for (Student st: studentList) {
            if(st.getStudentNumber().equals(num)){
                return true;
            }
	}
        return false;
    }
    //Writes Student data to file
    public void addDataToFile() {
        Course cs = new Course(subjCode.getText(), subjDesc.getText());
        Student st = new Student(sNum.getText(), sFName.getText(), sMName.getText().charAt(0), sLName.getText(), 
                                sCourse.getText(), Integer.parseInt(sYear.getText()), crushName.getText(), cs);
        studentList.add(st);
    }
    
    //Writes Student data to file
    public void reWriteFile() {
        try {
            File fout = new File(FILE_NAME);
            fos = new FileOutputStream(fout);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
           } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        }finally {
        // make sure to close the files!
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Performed when starting the main class, reads an initial file containing student information
    public void addFileData() {
            
            File fin = new File(FILE_NAME);
            if(fin.length() != 0) {
                try {
                    fis = new FileInputStream(fin);
                    ois = new ObjectInputStream(fis);
                    studentList = (ArrayList<Student>)ois.readObject();

                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException ce) {
                // this might be thrown by ois.readObject()
                    ce.printStackTrace();
                } finally {
                // make sure to close the files!
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
