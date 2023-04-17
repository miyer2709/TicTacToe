/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Usuario
 */
public class Line {
    private GameBean.GameState[] lineDatas;
    private int lineIndex;
    
    public Line(GameBean.GameState[] lineDatas, int lineIndex){
        this.lineDatas = lineDatas;
        this.lineIndex = lineIndex;
    }

    public GameBean.GameState[] getDatas() {
        return lineDatas;
    }
    public int getIndex() {
        return lineIndex;
    }
}
