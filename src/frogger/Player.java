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
public class Player {
    
    private String id;
    public String name;
    private String scoreList;

    /**
     * Get the value of scoreList
     *
     * @return the value of scoreList
     */
    public String getScoreList() {
        return scoreList;
    }

    /**
     * Set the value of scoreList
     *
     * @param scoreList new value of scoreList
     */
    public void setScoreList(String scoreList) {
        this.scoreList = scoreList;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }


    public Player() {
    }
    
    
    
}
