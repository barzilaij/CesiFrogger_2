/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

/**
 *
 * @author jb
 */
public class Bug {
    
    private String id;
    private String position;

    /**
    *Pour obtenir la position (index mare)
    * 
    * @author jb
    * @version %v%
    */
    public String getPosition() {
        return position;
    }

    /**
    *Pour déterminer la position (index mare)
    * 
    * @author jb
    * @version %v%
    */
    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Bug() {
    }
    
    
    
}
