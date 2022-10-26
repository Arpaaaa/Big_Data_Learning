package ObjectFile;

import java.io.Serializable;

public class Gamer implements Serializable {

    //必须设置一个serialVersionUID，用来唯一标识对象
    public static final long serialVersionUID = 34156491845343451L;

    private String name;

    private int blood;

    private String weapon;

    public Gamer() {
    }

    public Gamer(String name, int blood, String weapon) {
        this.name = name;
        this.blood = blood;
        this.weapon = weapon;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return blood
     */
    public int getBlood() {
        return blood;
    }

    /**
     * 设置
     * @param blood
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }

    /**
     * 获取
     * @return weapon
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * 设置
     * @param weapon
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String toString() {
        return "Gamer{name = " + name + ", blood = " + blood + ", weapon = " + weapon + "}";
    }
}
