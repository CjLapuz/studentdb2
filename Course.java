package studentdb2;

import java.io.Serializable;

/**
 *
 * @author Jeremy
 */
public class Course implements Serializable{
    private String courseCode;
    private String courseDesc;
    
    public Course(String courseCode, String courseDesc){
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
    }
    
    public void setCode(String code) {this.courseCode = code;}
    public String getCode(){return courseCode;}
    
    public void setDesc(String desc) {this.courseDesc = desc;}
    public String getDesc(){return courseDesc;}
    
    @Override
    public String toString(){
        String str = String.format("%s\n%s", courseCode, courseDesc);
        return str;
    }
}
