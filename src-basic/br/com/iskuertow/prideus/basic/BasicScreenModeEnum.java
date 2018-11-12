/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic;

/**
 *
 * @author Thiago
 */
public enum BasicScreenModeEnum {
    FULL_SCREEN(1, "fullscreen"), WINDOW(2, "window");
    
    public long index;
    public String type;
    
    private BasicScreenModeEnum(long index, String type) {
        this.index = index;
        this.type = type;
    }
    
    public long getIndex() {
        return index;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return type;
    }
    
    public static BasicScreenModeEnum getScreenMode(String type) {
        for (BasicScreenModeEnum value : BasicScreenModeEnum.values()) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return null;
    }
}
